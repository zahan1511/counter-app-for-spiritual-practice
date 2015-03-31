package com.example.tasbih;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Normal_Tasbih extends Activity implements OnClickListener {

	Button counter;
	int total;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        //initialization
        total=0;
       counter=(Button) findViewById(R.id.counter);
       counter.setOnClickListener(this);
       counter.setText(""+total+"");
       counter.setTextSize(100);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		total++;
		if(total>10000000)
			total=0;
		counter.setText(""+total+"");
		if(total<=10000)
		counter.setTextSize(100);
		else
			counter.setTextSize(50);
	}

	

 
    
}
