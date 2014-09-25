package com.shevaroller.oleksiy_todos;

public class Item {
	
	protected String itemText;
	protected boolean done;
	
	public Item(String itemText) {
		this.itemText = itemText;
	}
	
	public String getText() {
		return itemText;
	}
	
	public String toString() {
		return getText();
	}
	
	public boolean isDone() {
		return done;
	}
}
