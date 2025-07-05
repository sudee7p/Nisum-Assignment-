import React from 'react';
import { useUser } from '../context/UserContext';
import ProductEdit from './ProductEdit';
import withAdminAccess from '../hoc/withAdminAccess';

const ProtectedProductEdit = withAdminAccess(ProductEdit);

const Dashboard = () => {
  const { loginAsAdmin, loginAsUser } = useUser();

  return (
    <div>
      <h1>Dashboard</h1>
      <button onClick={loginAsAdmin}>Login as Admin</button>
      <button onClick={loginAsUser}>Login as User</button>

      <hr />
      <ProtectedProductEdit />
    </div>
  );
};

export default Dashboard;
