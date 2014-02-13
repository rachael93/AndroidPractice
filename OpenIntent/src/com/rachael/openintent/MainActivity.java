package com.rachael.openintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // this button opens google hangouts app
        // this is to be replaced with arduino input -  button to call the hangout  
        Button Hangouts = (Button) this.findViewById(R.id.hangouts); // create button 
        Hangouts.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick (View v)
        	{
        		// open browser with google
        		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/"));
        		startActivity(intent); 
        		
        		// open skype - this doesn't work 
        		//String nickname = new String("rachael_johnston93");
        		// Intent sky = new Intent("android.intent.action.VIEW");
                // sky.setData(Uri.parse("skype:" + nickname));
                // startActivity(sky);

			}
		});
        
    
   
    
        
        Button Start = (Button) findViewById(R.id.start);
        Start.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				startService(new Intent(getBaseContext(), MyServices.class));
				
			}
		});
        
        Button Stop = (Button) findViewById(R.id.stop);
        Stop.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				stopService(new Intent(getBaseContext(), MyServices.class));
				
			}
		});
        
    }
   


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
}
