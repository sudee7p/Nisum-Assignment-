import React from 'react';
import { useTheme } from './themeContent';

export default function ThemeToggle() {
  const { theme, toggleTheme } = useTheme();

  return (
    <button onClick={toggleTheme} style={{ marginTop: '10px' }}>
      Switch to {theme === 'light' ? '🌙 Dark' : '☀️ Light'} Mode
    </button>
  );
}
