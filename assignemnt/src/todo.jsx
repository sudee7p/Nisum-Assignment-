import React, { useReducer, useState } from 'react';

// Define actions
const ACTIONS = {
  ADD_TODO: 'add-todo',
  DELETE_TODO: 'delete-todo',
  TOGGLE_TODO: 'toggle-todo',
};

// Reducer function
function reducer(todos, action) {
  switch (action.type) {
    case ACTIONS.ADD_TODO:
      return [
        ...todos,
        {
          id: Date.now(),
          text: action.payload,
          completed: false,
        },
      ];
    case ACTIONS.DELETE_TODO:
      return todos.filter(todo => todo.id !== action.payload);
    case ACTIONS.TOGGLE_TODO:
      return todos.map(todo =>
        todo.id === action.payload
          ? { ...todo, completed: !todo.completed }
          : todo
      );
    default:
      return todos;
  }
}

export default function TodoApp() {
  const [todos, dispatch] = useReducer(reducer, []);
  const [text, setText] = useState('');

  const completedCount = todos.filter(todo => todo.completed).length;
  const pendingCount = todos.length - completedCount;

  const handleAdd = () => {
    if (text.trim()) {
      dispatch({ type: ACTIONS.ADD_TODO, payload: text });
      setText('');
    }
  };

  return (
    <div style={{ padding: '20px', maxWidth: '500px', margin: 'auto' }}>
      <h2>📝 Todo List</h2>
      <input
        value={text}
        onChange={e => setText(e.target.value)}
        placeholder="Enter a task..."
      />
      <button onClick={handleAdd}>Add</button>

      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            <span
              style={{
                textDecoration: todo.completed ? 'line-through' : 'none',
                cursor: 'pointer',
              }}
              onClick={() =>
                dispatch({ type: ACTIONS.TOGGLE_TODO, payload: todo.id })
              }
            >
              {todo.text}
            </span>
            <button
              onClick={() =>
                dispatch({ type: ACTIONS.DELETE_TODO, payload: todo.id })
              }
              style={{ marginLeft: '10px' }}
            >
              ❌
            </button>
          </li>
        ))}
      </ul>

      <div>
        ✅ Completed: {completedCount} | ⏳ Pending: {pendingCount}
      </div>
    </div>
  );
}
