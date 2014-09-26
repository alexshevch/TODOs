/*  
TODOs Application - Android App for managing TODO items
  
Copyright (C) 2014 Oleksii Shevchenko oleksiy@ualberta.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.

 */

package com.shevaroller.oleksiy_todos;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
    public ArrayList<Item> items;
    public TodoList todoList;
    public ArrayAdapter<Item> itemAdapter;
    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        items = new ArrayList<Item>();
        todoList = new TodoList(items);
        itemAdapter = new ArrayAdapter<Item>(this,android.R.layout.simple_list_item_checked,items);
        listView = (ListView) findViewById(R.id.mainTodosListView);
        listView.setAdapter(itemAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setClickable(true);
        listView.setOnItemClickListener(myClickListener);

    }
    
    public OnItemClickListener myClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        	Toast.makeText(MainActivity.this, items.get((int) arg3)+" is done", Toast.LENGTH_SHORT).show();
		}
    	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void manageActiveTodos(MenuItem item) {
    	Toast.makeText(this, "Active TODOs Manager", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this, ManageActiveActivity.class);
    	//Intent i = new Intent(getApplicationContext(), NewActivity.class);
    	String itemsString = items.toString().replace("[", "").replace("]", "");
    	intent.putExtra("items",itemsString);
    	startActivity(intent);
    }
    
    public void manageArchivedTodos(MenuItem item) {
    	Toast.makeText(this, "Archived TODOs Manager", Toast.LENGTH_SHORT).show();
    }
    
    
    public void addItemAction(View v) {
    	//TodoListController tlc = new TodoListController();
    	EditText textView = (EditText) findViewById(R.id.editTextTodo);
    	String newItemText = textView.getText().toString();
    	//tlc.addItem(new Item(newItemText));
    	Item newItem = new Item(newItemText);
    	items.add(newItem);
    	textView.setText("");
		itemAdapter.notifyDataSetChanged();
    	
        //Checking what items are checked
        for(int i=0;i<items.size();i++) {
            if (listView.isItemChecked(i)) {
            	//Toast.makeText(this, items.get(i)+" is checked", Toast.LENGTH_SHORT).show();
            }
        }
    	Toast.makeText(this, newItemText+" is added", Toast.LENGTH_SHORT).show();
    }
    
}
