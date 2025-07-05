import React from 'react';
import { ThemeProvider } from './context/ThemeContext';
import Header from './components/Header';
import Content from './components/Content';

const App = () => {
  return (
    <ThemeProvider>
      <Header />
      <Content />
    </ThemeProvider>
  );
};

export default App;
