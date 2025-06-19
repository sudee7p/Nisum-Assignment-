import React from 'react';

const TodoList = ({ todos }) => {
  return (
    <div style={containerStyle}>
      <h2>Todo List</h2>
      <ul style={listStyle}>
        {todos.map((todo, index) => (
          <li key={index} style={itemStyle}>{todo}</li>
        ))}
      </ul>
    </div>
  );
};

// Default props
TodoList.defaultProps = {
  todos: ['Sample Task 1', 'Sample Task 2', 'Sample Task 3']
};

// Simple inline styles
const containerStyle = {
  padding: '20px',
  fontFamily: 'Arial',
};

const listStyle = {
  listStyleType: 'disc',
  paddingLeft: '20px',
};

const itemStyle = {
  marginBottom: '8px',
};

export default TodoList;
