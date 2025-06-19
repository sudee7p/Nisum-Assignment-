import React from 'react';
import UserProfile from './UserProfile';
import Notifications from './Notifications';

const Dashboard = () => {
  // Props for UserProfile
  const user = {
    name: 'Sudeep Kumar',
    email: 'sudeep@example.com',
    avatarUrl: '',
    bio: 'BTech CSE student passionate about data analysis and AI/ML.',
  };

  // Props for Notifications
  const notifications = [
    {
      message: 'Assignment submitted successfully',
      date: '2025-06-17',
      timestamp: '11:15 AM',
      state: 'Read',
    },
    {
      message: 'New project assigned by your mentor',
      date: '2025-06-18',
      timestamp: '9:30 AM',
      state: 'Unread',
    },
  ];

  return (
    <div>
      <h1 style={{ textAlign: 'center', marginTop: '20px' }}>Dashboard</h1>
      <UserProfile {...user} />
      <Notifications notifications={notifications} />
    </div>
  );
};

export default Dashboard;
