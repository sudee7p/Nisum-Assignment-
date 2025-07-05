import { createContext, useContext, useState } from 'react';

const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({ name: '', role: '' });

  const loginAsAdmin = () => setUser({ name: 'Admin User', role: 'admin' });
  const loginAsUser = () => setUser({ name: 'Regular User', role: 'user' });

  return (
    <UserContext.Provider value={{ user, loginAsAdmin, loginAsUser }}>
      {children}
    </UserContext.Provider>
  );
};

export const useUser = () => useContext(UserContext);
