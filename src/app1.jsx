import React from 'react';
import greetings from './greetings';

function App() {
  const userName = "Sudeep"; // Dynamic value

  return (
    <div>
      <Greeting name={userName} />
    </div>
  );
}

export default App;
