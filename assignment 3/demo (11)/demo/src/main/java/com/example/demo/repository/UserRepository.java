package com.example.demo.repository;

@Testcontainers
@SpringBootTest
public class UserRepositoryTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("user")
            .withPassword("pass");

    @DynamicPropertySource
    static void config(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User(null, "test", "pass");
        userRepository.save(user);
        assertNotNull(user.getId());
    }
}
