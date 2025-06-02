document.getElementById("add-btn").addEventListener("click", addTask);
document
  .getElementById("todo-input")
  .addEventListener("keypress", function (e) {
    if (e.key === "Enter") addTask();
  });

function addTask() {
  const input = document.getElementById("todo-input");
  const taskText = input.value.trim();
  if (!taskText) return;

  const li = document.createElement("li");
  const span = document.createElement("span");
  span.textContent = taskText;
  span.addEventListener("click", () => {
    li.classList.toggle("completed");
  });

  const deleteBtn = document.createElement("button");
  deleteBtn.textContent = "✖";
  deleteBtn.addEventListener("click", () => {
    li.remove();
  });

  li.appendChild(span);
  li.appendChild(deleteBtn);
  document.getElementById("todo-list").appendChild(li);
  input.value = "";
}
