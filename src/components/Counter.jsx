import React, { useState, useEffect } from 'react';
import './Counter.css';

const Counter = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log(`Count updated: ${count}`);
  }, [count]);

  return (
    <div className="counter-container">
      <h1>Count: {count}</h1>
      <button className="increment" onClick={() => setCount(count + 1)}>Increment</button>
      <button 
        className="decrement" 
        onClick={() => setCount(count - 1)} 
        disabled={count === 0}
      >
        Decrement
      </button>
      <button className="reset" onClick={() => setCount(0)}>Reset</button>
    </div>
  );
};

export default Counter;
