let todoItems = new Map();
let idCounter = 0;

export class Todo {
  constructor(task) {
    this.id = ++idCounter;
    this.task = task;
    this.completed = false;
  }

  toggleComplete = () => {
    this.completed = !this.completed;
  };
}

export const addTodo = (task = 'Untitled Task') => {
  const todo = new Todo(task);
  todoItems.set(todo.id, todo);
  return todo;
};

export const getAllTodos = () => [...todoItems.values()];
