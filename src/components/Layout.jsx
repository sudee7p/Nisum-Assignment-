import React from 'react';
import './Layout.css';

const Layout = ({ children }) => {
  return (
    <div className="layout-grid">
      <header className="layout-header">🌐 My Website</header>
      <main className="layout-content">{children}</main>
      <footer className="layout-footer">© 2025 My Website. All rights reserved.</footer>
    </div>
  );
};

export default Layout;
