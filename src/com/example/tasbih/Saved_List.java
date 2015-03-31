package com.example.tasbih;


import java.util.List;








import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Saved_List extends ListActivity{

	List<String> data;
	String forposition[];
	Hotornot info,infoo;
	String check;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		//initialization
		
		check="no";
		
		try{
			info=new Hotornot(this);
			info.open();
			data=info.getvalue();
			info.close();
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, final long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String[] namesArr = data.toArray(new String[data.size()]);
		final String pos=namesArr[position];
		
try{
  			
  			long del=id;
  		    infoo=new Hotornot(this);
  			infoo.open();
  			
  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}
		
		
            final Intent resume = new Intent(this, New_Dua1.class); 
            resume.putExtra("arg", pos);
                
            AlertDialog.Builder builder = new AlertDialog.Builder(Saved_List.this);
		    builder.setTitle("Please Choose Your Option");
		    builder.setItems(new CharSequence[]
		            {"     RESUME", "     DELETE"},
		            new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int which) {
		                    // The 'which' argument contains the index position
		                    // of the selected item
		                    switch (which) {
		                        case 0:
		                            
		                        	startActivity(resume);
		                        	
		                            break;
		                        case 1:
		                        	try{
		                        		infoo.delete(pos);
			                  			infoo.close();
			                  			Toast.makeText(Saved_List.this, "Deleted Successfully", 0).show();
			                  			startActivity(getIntent());
			             
		                        	}catch(Exception e){
		                        		e.printStackTrace();
		                        	}
		                        	
		                        	
		                            
		                            break;
		                      
		                    }
		                }
		            });
		    builder.create().show();
		
		
		
		
		
		

	 
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
