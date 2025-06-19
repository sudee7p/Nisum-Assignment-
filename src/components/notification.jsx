import React from 'react';
import './Notifications.css';

const Notifications = ({ notifications }) => {
  return (
    <div className="notifications-container">
      <h2>Notifications</h2>
      <div className="notifications-grid">
        {notifications.map((note, index) => (
          <div key={index} className={`notification-card ${note.state.toLowerCase()}`}>
            <p>{note.message}</p>
            <small>{note.date} | {note.timestamp}</small>
            <span className="state">{note.state}</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Notifications;
