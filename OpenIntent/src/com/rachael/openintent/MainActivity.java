package com.rachael.openintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;



public class MainActivity extends Activity {

	private SeekBar volumeSeekBar; 
	private AudioManager audiomanager; 
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        setContentView(R.layout.activity_main);
        
        setVolumeControlStream(AudioManager.STREAM_MUSIC); 
        initControls(); 
        
        
        // this button opens google hangouts app
        // this is to be replaced with arduino input -  button to call the hangout  
        Button Hangouts = (Button) this.findViewById(R.id.hangouts); // create button 
        
        
        Hangouts.setOnClickListener(new View.OnClickListener()
     
        
        {
        	@Override
        	public void onClick (View v)
        	{
        		// open browser with google
        		// Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/"));
        		// startActivity(intent); 
        		
        		//action = android.intent.action.View, data = content://plus.google.com/hangouts
        	//	Intent sky = new Intent("android.intent.action.VIEW", Uri.parse("https://talkgadget.google.com/hangouts/extras/talk.google.com/myhangout"));
        		Intent sky = new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/hangouts/_/72cpjj252brgi4hhtqn4j68a48?hl=en"));
        		startActivity(sky);
        		
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
    
   


    private void initControls() {
		// TODO Auto-generated method stub
		try {
			volumeSeekBar = (SeekBar) findViewById(R.id.seekBar1);
			audiomanager =  (AudioManager) getSystemService(Context.AUDIO_SERVICE);
			volumeSeekBar.setMax(audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
			volumeSeekBar.setProgress(audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC)); 
			volumeSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

				@Override
				public void onProgressChanged(SeekBar seekbar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekbar) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekbar) {
					// TODO Auto-generated method stub
				
				}
			});
		}
			
		catch (Exception e) {
			
		}
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /* public class SeekBarVolume extends Activity implements OnSeekBarChangeListener { 
    	 SeekBar sb;
    	MediaPlayer mp; 
    	AudioManager am; 
    	
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.activity_main);
    		sb = (SeekBar) findViewById(R.id.seekBar1);

    		am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    		int maxV = am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
    		int curV = am.getStreamVolume(AudioManager.STREAM_SYSTEM); 
    		sb.setMax(maxV);
    		sb.setProgress(curV);
    		
    		sb.setOnSeekBarChangeListener(this); 
    	
    	}
    	
    	@Override
    	protected void onPause() {
    		super.onPause();
    		mp.release(); 
    	}

		@Override
		public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
			// TODO Auto-generated method stub
			am.setStreamVolume(AudioManager.STREAM_SYSTEM, progress, 0);
			
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		} */
    }
    

