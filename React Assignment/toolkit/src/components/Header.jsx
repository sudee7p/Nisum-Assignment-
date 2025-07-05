import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login, logout } from '../store/userSlice';
import Cart from './Cart';

const Header = () => {
  const dispatch = useDispatch();
  const { isLoggedIn, user } = useSelector((state) => state.user);

  return (
    <header style={{ padding: 10, backgroundColor: '#f4f4f4' }}>
      {isLoggedIn ? (
        <div>
          <p>Hello, {user.name}</p>
          <button onClick={() => dispatch(logout())}>Logout</button>
        </div>
      ) : (
        <button onClick={() => dispatch(login({ name: 'John', email: 'john@example.com' }))}>
          Login
        </button>
      )}
      <Cart />
    </header>
  );
};

export default Header;
