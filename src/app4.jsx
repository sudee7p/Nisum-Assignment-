import React from 'react';
import UserProfile from './UserProfile';
import Notifications from './Notifications';

function App() {
  const notifications = [
    { message: 'New message received', date: '2025-06-18', timestamp: '10:30 AM', state: 'Unread' },
    { message: 'Password changed successfully', date: '2025-06-17', timestamp: '02:45 PM', state: 'Read' },
  ];

  return (
    <div>
      <UserProfile
        name="Sudeep Kumar"
        email="sudeep@example.com"
        avatarUrl=""
        bio="BTech CSE student passionate about data and AI."
      />

      <Notifications notifications={notifications} />
    </div>
  );
}

export default App;
