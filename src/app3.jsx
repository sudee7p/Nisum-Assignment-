import React from 'react';
import TodoList from './TodoList';

function App() {
  const myTodos = [
    'Buy groceries',
    'Complete assignment',
    'Call a friend'
  ];

  return (
    <div>
      <TodoList todos={myTodos} />
      <hr />
      <TodoList /> 
    </div>
  );
}

export default App;
