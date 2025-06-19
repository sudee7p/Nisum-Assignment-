import React, { useState } from 'react';
import './ThemeToggle.css'; 

const ThemeToggle = () => {
  const [isDark, setIsDark] = useState(false);

  const toggleTheme = () => {
    setIsDark(prevTheme => !prevTheme);
  };

  const containerStyle = {
    backgroundColor: isDark ? '#222' : '#f0f0f0',
    color: isDark ? '#fff' : '#000',
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'column',
    transition: 'all 0.3s ease',
  };

  const buttonStyle = {
    padding: '12px 24px',
    backgroundColor: isDark ? '#555' : '#ddd',
    color: isDark ? '#fff' : '#000',
    border: 'none',
    borderRadius: '8px',
    fontSize: '16px',
    cursor: 'pointer',
  };

  return (
    <div style={containerStyle}>
      <h1>{isDark ? 'Dark Mode' : 'Light Mode'}</h1>
      <button style={buttonStyle} onClick={toggleTheme}>
        Toggle Theme
      </button>
    </div>
  );
};

export default ThemeToggle;
