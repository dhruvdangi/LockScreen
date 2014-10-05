package com.dhruv.lockscreen;
//Import all the required libraries
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;

public class LockScreenService extends Service {
	BroadcastReceiver mReceiver;//Declare a BroadcastReceiver
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	public static class lockScreenReceiver extends BroadcastReceiver{
		
		@Override
		public void onReceive(Context context, Intent intent) 
		{
			// TODO Auto-generated method stub			
	        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) 
	        {
	        	// Start lockScreen when the Screen is turned off
	        	MainActivity.startScreen=true;
	        	Intent intent1 = new Intent(context,com.dhruv.lockscreen.MainActivity.class);
	        	intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	context.startActivity(intent1);
	        }
	    }
	}
	@Override
	public void onStart(Intent intent, int startId) {
	
		SharedPreferences password = getApplicationContext().getSharedPreferences ("start", Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = password.edit();
		 editor.putInt("s",1);
		 editor.commit();	}


@Override
public void onCreate() {
	//Register the Receiver when the Service is created
     IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
     filter.addAction(Intent.ACTION_SCREEN_OFF);
     mReceiver = new lockScreenReceiver();
     registerReceiver(mReceiver, filter);
	 super.onCreate();
	 

}

//Unregister the service when onDestroy  is called
@Override
public void onDestroy() {
	unregisterReceiver(mReceiver);
	super.onDestroy();
}
}