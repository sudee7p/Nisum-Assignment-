import React from 'react';
import { ThemeProvider } from './themeContent';
import ThemeToggle from './themeToggle';

function App() {
  return (
    <ThemeProvider>
      <div style={{ padding: '20px' }}>
        <h1>Hello Theme!</h1>
        <ThemeToggle />
      </div>
    </ThemeProvider>
  );
}

export default App;
