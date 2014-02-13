package com.rachael.openintent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyServices extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// this service will run until we stop it 
		Toast.makeText(this,"Service started", Toast.LENGTH_LONG).show();
		return START_STICKY; 
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Toast.makeText(this,"Service stopped", Toast.LENGTH_LONG).show();
	}
}
