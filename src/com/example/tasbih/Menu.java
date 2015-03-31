package com.example.tasbih;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Menu extends ListActivity{
	
	
	String classes[]={"Normal_Tasbih","New_Dua","Saved_List"};

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_expandable_list_item_1,classes));
	}



	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String pos=classes[position];
		Class ourClass;
		try {
			ourClass = Class.forName("com.example.tasbih." + pos);
			Intent ourIntent=new Intent(Menu.this,ourClass);
			startActivity(ourIntent);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}



	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.cool_menu,menu);
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.about:
			final Dialog d=new Dialog(this);
			d.setTitle("About Us");
			TextView tv=new TextView(this);
			tv.setText("\n"
					+ "\n"
					+ " Developer Of This App is zahan safallwa. Any kind of suggestion will be accpected."
					+ " plz send ur suggestion to safallwa@gmail.com"
					+ "\n"
					+ "\n"
					+ "\n");
			d.setContentView(tv);
			d.show();
			break;
		case R.id.help:
			final Dialog dt=new Dialog(this);
			dt.setTitle("Help");
			dt.setContentView(R.layout.dialoghelp);
			dt.show();
			break;
		}
		return false;
	}


		
}
