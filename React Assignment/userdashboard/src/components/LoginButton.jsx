import React from 'react';
import { useUser } from '../context/UserContext';

const LoginButton = () => {
  const { loginAsAdmin, loginAsUser } = useUser();

  return (
    <div>
      <h2>Please Log In</h2>
      <button onClick={loginAsAdmin}>Login as Admin</button>
      <button onClick={loginAsUser}>Login as User</button>
    </div>
  );
};

export default LoginButton;
