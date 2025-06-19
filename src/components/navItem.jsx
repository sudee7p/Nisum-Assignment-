import React from 'react';

const NavItem = ({ label, isActive, onClick }) => {
  return (
    <li
      className={`nav-item ${isActive ? 'active' : ''}`}
      onClick={() => onClick(label)}
    >
      {label}
    </li>
  );
};

export default NavItem;
