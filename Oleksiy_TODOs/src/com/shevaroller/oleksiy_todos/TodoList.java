package com.shevaroller.oleksiy_todos;

import java.util.ArrayList;
import java.util.Collection;

public class TodoList {

	protected ArrayList<Item> todoList;
	
	public TodoList(ArrayList<Item> items) {
		todoList = items;
	}

	public Collection<Item> getTodoList() {
		return todoList;
	}
	
	public void addItem(Item newItem) {
		todoList.add(newItem);
	}
	
	public void removeItem(Item item) {
		todoList.remove(item);
	}
}
