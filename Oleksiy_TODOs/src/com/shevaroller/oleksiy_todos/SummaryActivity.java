package com.shevaroller.oleksiy_todos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SummaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int checkedTodos = 0;
		int uncheckedTodos = 0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
    	Toast.makeText(this, "TODOs Summary", Toast.LENGTH_SHORT).show();
    	
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			checkedTodos = extras.getInt("CHECKED_TODOS");
			uncheckedTodos = extras.getInt("UNCHECKED_TODOS");
		}
		TextView textViewforChecked = (TextView)findViewById(R.id.todos_checked_value);
		textViewforChecked.setText(String.valueOf(checkedTodos));
		
		TextView textViewforUnchecked = (TextView)findViewById(R.id.todos_unchecked_value);
		textViewforUnchecked.setText(String.valueOf(uncheckedTodos));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
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
