package com.shevaroller.oleksiy_todos;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ManageActiveActivity extends Activity {
    public ArrayList<String> items;
    public ArrayAdapter<String> itemAdapter;
    public ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.active_todos);
    	Toast.makeText(this, "Active TODOs Manager", Toast.LENGTH_SHORT).show();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    items = new ArrayList<String>(Arrays.asList(extras.getString("items").split(",")));
		}
		
	    itemAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,items);
        listView = (ListView) findViewById(R.id.activeTodosListView);
        listView.setAdapter(itemAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //Toast.makeText(this, itemsArr.get(0)+"\n Item2:"+itemsArr.get(1), Toast.LENGTH_LONG).show();
        
        listView.isLongClickable();
        listView.setOnItemLongClickListener(longClickListener);
        
	}
		
	public OnItemLongClickListener longClickListener = new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {			
			PopupMenu popup = new PopupMenu(ManageActiveActivity.this, view);   
            popup.getMenuInflater().inflate(R.menu.active_popup_menu, popup.getMenu());
            popup.show();
			return false;
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_active, menu);
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
}
