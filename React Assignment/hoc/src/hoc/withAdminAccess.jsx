import React from 'react';
import { useUser } from '../context/UserContext';

const withAdminAccess = (WrappedComponent) => {
  return function AdminProtectedComponent(props) {
    const { user } = useUser();

    if (user.role === 'admin') {
      return <WrappedComponent {...props} />;
    } else {
      return <h2>Access Denied: Admins Only</h2>;
    }
  };
};

export default withAdminAccess;
