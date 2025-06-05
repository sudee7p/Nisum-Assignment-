import { addTodo, getAllTodos } from './todo.js';
import { renderTodos } from './utils.js';

document.addEventListener('DOMContentLoaded', () => {
  const input = document.getElementById('todoInput');
  const addBtn = document.getElementById('addBtn');
  const list = document.getElementById('todoList');

  addBtn.addEventListener('click', () => {
    const task = input.value.trim();
    if (task) {
      addTodo(task);
      input.value = '';
      renderTodos(getAllTodos(), list);
    }
  });

  renderTodos(getAllTodos(), list); 
});
