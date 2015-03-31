package com.example.tasbih;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class New_Dua1 extends Activity implements OnClickListener, OnLongClickListener {

	EditText title;
	Button count;
	int total,value;
	String name;
	boolean diditwork=true;
	String passedArg;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdua);
        
        
        
       //initialization
        total=0;
        passedArg = getIntent().getExtras().getString("arg");
        Hotornot infio=new Hotornot(this);
		infio.open();
		name=infio.getname(passedArg);
		total=infio.gettotal(passedArg);
		infio.close();
       
       
       count=(Button) findViewById(R.id.count);
       title=(EditText) findViewById(R.id.title);
       count.setOnClickListener(this);
       count.setOnLongClickListener(this);
       title.setText(name);
       count.setText(""+total+"");
       count.setTextSize(100);
       
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			
			
			total++;
			if(total>10000000)
			total=0;
			count.setText(""+total+"");
			if(total<=10000)
			count.setTextSize(100);
			else
			count.setTextSize(50);
		
		
	}

	
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		name=title.getText().toString();
		value=total;
		String namee="";
		
		if(name.equals(namee))
		{
			final Dialog dp=new Dialog(this);
			dp.setTitle("Warning");
			TextView tv=new TextView(this);
			tv.setText("Plz Set The Title");
			dp.setContentView(tv);
			dp.show();
		}
		else{
		
		try{
		
		
		Hotornot entry=new Hotornot(New_Dua1.this);
		entry.open();
		entry.createEntry(name,value);
		entry.close();
		}catch(Exception e){
			diditwork=false;
		}finally{
			if(diditwork)
			{
				final Dialog d=new Dialog(this);
				d.setTitle("INFO");
				TextView tv=new TextView(this);
				tv.setText("Saving......");
				d.setContentView(tv);
				d.show();
				 final Timer t = new Timer();
	                t.schedule(new TimerTask() {
	                    public void run() {
	                        d.dismiss(); // when the task active then close the dialog
	                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
	                    }
	                }, 2000);
	                
	                Intent gomenu=new Intent("com.example.tasbih.MENU");
					startActivity(gomenu);   
			}
		}
		}
		return false;
	}

	
	

 
    
}
