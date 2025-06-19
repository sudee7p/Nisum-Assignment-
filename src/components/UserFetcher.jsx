import React, { useEffect, useState } from 'react';

const UserFetcher = () => {
  const [users, setUsers] = useState([]);
  const [count, setCount] = useState(0);

  const fetchUsers = async (num) => {
    const response = await fetch(`https://randomuser.me/api/?results=${num}`);
    const data = await response.json();
    setUsers(data.results);
  };

  useEffect(() => {
      if (count > 0) {
        fetchUsers(count);
      }
  }, [count]);

  return (
    <div>
      <button onClick={() => setCount(prev => prev + 1)}>
        Show {count + 1} User{count + 1 === 1 ? '' : 's'}
      </button>

      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '1rem', marginTop: '1rem' }}>
        {users.map((user, index) => (
          <div key={index} style={{ border: '1px solid #ccc', padding: '1rem', borderRadius: '8px' }}>
            <h3>{user.name.first} {user.name.last}</h3>
            <img src={user.picture.medium} alt="User" />
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserFetcher;
