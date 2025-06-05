export const renderTodos = (todos, container) => {
  container.innerHTML = '';
  for (const { id, task, completed } of todos) {
    const li = document.createElement('li');
    li.textContent = `${task} ${completed ? '✅' : ''}`;
    li.style.cursor = 'pointer';
    li.addEventListener('click', () => {
      todos.find(t => t.id === id).toggleComplete();
      renderTodos(todos, container);
    });
    container.appendChild(li);
  }
};
