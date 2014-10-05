package com.dhruv.lockscreen;
//Import all the required libraries
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ChangePassword extends Activity {
	private AdView adView;   //Declare variable for ads

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Define the XML file for the UI. 
		setContentView(R.layout.activity_changepassword);
		// Look up the AdView as a resource and load a request for advertisement
	    AdView adView = (AdView)this.findViewById(R.id.passtop);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);
	    
	}
	

	public void changepass(View v) throws IOException
	{	
		//Initialize variables for input of Old and New password
		EditText opass,npass;
		opass=(EditText) findViewById(R.id.opass);
		npass=(EditText) findViewById(R.id.npass);
		//If there is no entry in any of the Required Fields display an error message
		if(opass.getText().toString().matches("")||npass.getText().toString().matches(""))
		{
			Toast.makeText(this.getBaseContext(),"Required Field Missing", 
	                Toast.LENGTH_SHORT).show();
		}
		else
		{	//If old password is correct, change the password and display a message
			SharedPreferences password = getSharedPreferences ("pass", Context.MODE_PRIVATE);
			if(Integer.parseInt(opass.getText().toString())==(password.getInt("password",0)))
			{
				SharedPreferences.Editor editor = password.edit();
				editor.putInt("password",Integer.parseInt(npass.getText().toString()));
				editor.commit();
				opass.setText("");
				npass.setText("");
				Toast.makeText(this.getBaseContext(),"Password Changed",Toast.LENGTH_SHORT).show();
			 
			}
			else
			{	//If old Password is not correct, display error message
				 opass.setText("");
				 npass.setText("");
				 Toast.makeText(this.getBaseContext(),"Incorrect Password",Toast.LENGTH_SHORT).show();

			}
		}
	}
	 @Override
	  public void onResume() 
	 {	//Resume ad after the activity has been resumed
	    super.onResume();
	    if (adView != null) 
	    {
	      adView.resume();
	    }
	 }

	  @Override
	  public void onPause() 
	  {	//Pause the ad when the activity is paused
	    if (adView != null) 
	    {
	      adView.pause();
	    }
	    super.onPause();
	  }

	  @Override
	  public void onDestroy() 
	  {
	    // Destroy the AdView.
	    if (adView != null) 
	    {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }
}