package com.shevaroller.oleksiy_todos;

public class TodoListController {
	private static TodoList todoList = null;
	static public TodoList getTodoList() {
		if (todoList == null) {
			todoList = new TodoList();
		}
		return todoList;
	}
	
	public void addItem(Item item) {
		getTodoList().addItem(item);
	}
}
