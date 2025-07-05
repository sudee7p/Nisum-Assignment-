import React from 'react';
import { useTheme } from '../context/ThemeContext';

const Content = () => {
  const { theme } = useTheme();

  const styles = {
    padding: '20px',
    minHeight: '200px',
    backgroundColor: theme === 'light' ? '#fff' : '#222',
    color: theme === 'light' ? '#000' : '#eee',
  };

  return (
    <main style={styles}>
      <p>This is a themed content area.</p>
      <p>The current theme is: <strong>{theme}</strong></p>
    </main>
  );
};

export default Content;
