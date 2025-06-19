import React, { useState } from 'react';
import NavItem from './NavItem';
import './NavBar.css';

const NavBar = () => {
  const [activeTab, setActiveTab] = useState('Home');

  const navItems = ['Home', 'About', 'Services', 'Contact'];

  return (
    <nav className="navbar">
      <ul className="nav-list">
        {navItems.map((item) => (
          <NavItem
            key={item}
            label={item}
            isActive={activeTab === item}
            onClick={setActiveTab}
          />
        ))}
      </ul>
    </nav>
  );
};

export default NavBar;
