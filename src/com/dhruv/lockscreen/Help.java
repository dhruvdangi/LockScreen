package com.dhruv.lockscreen;
//Import all the required libraries
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.app.Activity;
import android.os.Bundle;

public class Help extends Activity 
{
	private AdView adView;  //Declare variable for ads
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Define the XML file for the UI. 
		setContentView(R.layout.activity_help);
		// Look up the AdView as a resource and load a request.
	    AdView adView = (AdView)this.findViewById(R.id.helptop);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);
	}

	@Override
	  public void onResume() {
	    super.onResume();
	  //Resume ad after the activity has been resumed
	    if (adView != null) {
	      adView.resume();
	    }
	  }

	  @Override
	  public void onPause() 
	  {	 
		super.onPause();
		//Pause the ad when the activity is paused
	    if (adView != null) 
	    {
	      adView.pause();
	    }
	  }

	  // Called before the activity is destroyed.
	  @Override
	  public void onDestroy() 
	  {	
		super.onDestroy();
	    // Destroy the AdView.
	    if (adView != null) 
	    {
	      adView.destroy();
	    }
	    
	  }
}
