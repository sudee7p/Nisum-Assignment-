import { createContext, useState, useContext } from 'react';

const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({
    id: null,
    name: '',
    role: '',
    isLoggedIn: false,
  });

  const loginAsAdmin = () => {
    setUser({
      id: 1,
      name: 'Admin User',
      role: 'admin',
      isLoggedIn: true,
    });
  };

  const loginAsUser = () => {
    setUser({
      id: 2,
      name: 'Regular User',
      role: 'user',
      isLoggedIn: true,
    });
  };

  const logout = () => {
    setUser({
      id: null,
      name: '',
      role: '',
      isLoggedIn: false,
    });
  };

  return (
    <UserContext.Provider value={{ user, loginAsAdmin, loginAsUser, logout }}>
      {children}
    </UserContext.Provider>
  );
};

export const useUser = () => useContext(UserContext);
