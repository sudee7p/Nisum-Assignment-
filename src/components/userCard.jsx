import React from 'react';
import './UserCard.css';

const UserProfile = ({ name, email, avatarUrl, bio }) => {
  return (
    <div className="user-card">
      <img
        src={avatarUrl || 'https://via.placeholder.com/100'}
        alt="Avatar"
        className="avatar"
      />
      <div className="user-info">
        <h2>{name}</h2>
        <p><strong>Email:</strong> {email}</p>
        <p><strong>Bio:</strong> {bio}</p>
      </div>
    </div>
  );
};

// Default Props
UserProfile.defaultProps = {
  name: 'Anonymous',
  email: 'unknown@example.com',
  bio: 'No bio available.',
  avatarUrl: '',
};

export default UserProfile;
