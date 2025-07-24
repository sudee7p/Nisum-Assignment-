package com.example.KafkaLoginCounter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;

import java.util.Properties;

public class LoginCountApp {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "login-counter-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        ObjectMapper mapper = new ObjectMapper();

        KStream<String, String> loginEvents = builder.stream("user-login-events");

        KStream<String, String> userEvents = loginEvents
                .map((key, value) -> {
                    try {
                        LoginEvent event = mapper.readValue(value, LoginEvent.class);
                        return KeyValue.pair(event.getUserId(), "1");
                    } catch (Exception e) {
                        return KeyValue.pair("invalid", "1");
                    }
                });

        KTable<String, Long> loginCounts = userEvents
                .groupByKey()
                .count();

        loginCounts.toStream()
                .mapValues(String::valueOf)
                .to("login-counts", Produced.with(Serdes.String(), Serdes.String()));

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
