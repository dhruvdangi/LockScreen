package com.dhruv.lockscreen;
//Import all the required libraries
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.widget.Toast;

 
@SuppressWarnings("deprecation")
public class LockScreen extends PreferenceActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
		//Define the XML file for the UI. 
        addPreferencesFromResource(R.xml.settings);
		//Start the Help activity if the application is run for the first time.
        SharedPreferences h = getSharedPreferences ("help", Context.MODE_PRIVATE);
		boolean help=h.getBoolean("help", true);
		if(help==true)
		{
			SharedPreferences.Editor editor = h.edit();
			editor.putBoolean("help",false);
			editor.commit();
			Intent a = new Intent(this,Help.class);
			SharedPreferences password = getSharedPreferences ("pass", Context.MODE_PRIVATE);
			int p = password.getInt("password", 1234);
			SharedPreferences.Editor editor1 = password.edit();
			editor1.putInt("password",p);
			editor1.commit();
			startActivity(a);
		} 		
		//Enable/Disable Lockscreen when the Required
		this.findPreference("Enable/Disable").setOnPreferenceChangeListener(new OnPreferenceChangeListener() 
		{

			@Override
			public boolean onPreferenceChange(Preference preference,Object newValue) 
			{
				// TODO Auto-generated method stub
				if((Boolean) newValue==true)
				enable();
				else
				disable();
				return true;
			}
		        
		});
        
    }
    //Function to enable lockscreen
    public void enable()
    {
    		KeyguardManager keyguardManager = (KeyguardManager)getSystemService(Activity.KEYGUARD_SERVICE);
    		KeyguardLock lock = keyguardManager.newKeyguardLock(KEYGUARD_SERVICE);
    		lock.disableKeyguard();
    		startService(new Intent(this, LockScreenService.class));
    		Toast.makeText(this.getBaseContext(),"Enabled",Toast.LENGTH_SHORT).show();
    		Toast.makeText(this, "Please set LockScreen as default launcher", Toast.LENGTH_SHORT).show();
    }
    //Function to disable lockscreen
    public void disable()
    {	
    	stopService(new Intent(this, LockScreenService.class));
    	Toast.makeText(this.getBaseContext(),"Disabled",Toast.LENGTH_SHORT).show();
    	
    }
}
    
  