import React, { useState, useEffect } from 'react';

const DigitalClock = () => {

  const [currentTime, setCurrentTime] = useState(
    new Date().toLocaleTimeString()
  );

  const [isRunning, setIsRunning] = useState(true);

  useEffect(() => {
    let timer;

    if (isRunning) {
      timer = setInterval(() => {
        setCurrentTime(new Date().toLocaleTimeString());
      }, 1000);
    }


    return () => clearInterval(timer);
  }, [isRunning]);


  const toggleClock = () => {
    setIsRunning((prev) => !prev);
  };

  return (
    <div
      style={{
        border: '2px solid #ccc',
        borderRadius: '10px',
        width: '350px',
        padding: '20px',
        textAlign: 'center',
        fontFamily: 'Arial, sans-serif',
        margin: '40px auto',
        boxShadow: '0 0 10px rgba(0,0,0,0.2)',
      }}
    >
      <h2>🕒 Current Time:</h2>
      <h1>{currentTime}</h1>
      <button
        onClick={toggleClock}
        style={{
          marginTop: '20px',
          padding: '10px 20px',
          fontSize: '16px',
          cursor: 'pointer',
        }}
      >
        {isRunning ? 'Stop Clock' : 'Start Clock'}
      </button>
    </div>
  );
};

export default DigitalClock;
