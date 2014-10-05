package com.dhruv.lockscreen;
//Import all the required libraries
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
	//Initialization of Required Variables
	static TextView[] tvArray = new TextView[9];
	static boolean startScreen=true;
	TextView help;
	EditText et;
	static String pass;
	String ps;
	int passcounter=0;
	boolean currentFocus;
	boolean isPaused;
	Handler collapseNotificationHandler;
	public static int p=0;
	public static int x;
	//Do nothing when the "Back" button is pressed
	@Override
	public void onBackPressed() {
	}
	//onCreate function is called when activity is being run and has not been in the memory before
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences password = getSharedPreferences ("start", Context.MODE_PRIVATE);
		x=password.getInt("s",1);
		//Check if LockScreen really needs to be started.
		if(startScreen==true)
	{
		//Define the XML file for the UI. 
        setContentView(R.layout.activity_main);
        //Initialize all variables
		Initialise();
		//Generate random numbers and set them in the UI
		Random();		
		//Calculate the password that needs to be input
		makepassword();
		//Set Background Image
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		Drawable wall=getResources().getDrawable(wallpaper.getInt("wallpaper",R.drawable.bg_img6));
		LinearLayout layout =(LinearLayout)findViewById(R.id.main_layout);
		layout.setBackground(wall);
		//Set Date
		setDate();
		//Check the number that has been input
		TextWatcher passchk = new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				}
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub	
				}
			@Override
			public void afterTextChanged(Editable s) 
			{
				// TODO Auto-generated method stub
				String a=et.getText().toString();
				//Finish activity if the password is correct
				if(a.equals(pass))	{
					startScreen=false;
					passcounter=0;
					finish();
				}
				//If the length of password is equal to the saved password but is incorrect, vibrate device and clear the text field
				else
				{
					if(a.length()==pass.length())
					{
						et.setText("");
						passcounter++;
						Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
						v.vibrate(200);
						
					}
				}
			}				
		};
			et.addTextChangedListener(passchk);
	}
		else
	{		//If the home button is pressed but the LockScreen does not need to be started, then open the desired Launcher
			PackageManager pm = getPackageManager();
		    Intent i = new Intent("android.intent.action.MAIN");
		    i.addCategory("android.intent.category.HOME");
		    List<ResolveInfo> lst = pm.queryIntentActivities(i, 0);
		    if (lst != null) {
		       for (ResolveInfo resolveInfo : lst) {
		           try {
		           Intent home = new Intent("android.intent.action.MAIN");
		           home.addCategory("android.intent.category.HOME");
		           home.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
		           startActivity(home);
		           break;
		           } catch (Throwable t) {
		               t.printStackTrace();
		           }
		       }
		    }
		    finish();
	}
		}
	
		//Initialize all Variables	
		public void Initialise(){
		tvArray[0]=(TextView) findViewById(R.id.t1);
		tvArray[1]=(TextView) findViewById(R.id.t2);
		tvArray[2]=(TextView) findViewById(R.id.t3);
		tvArray[3]=(TextView) findViewById(R.id.t4);
		tvArray[4]=(TextView) findViewById(R.id.t5);
		tvArray[5]=(TextView) findViewById(R.id.t6);
		tvArray[6]=(TextView) findViewById(R.id.t7);
		tvArray[7]=(TextView) findViewById(R.id.t8);
		tvArray[8]=(TextView) findViewById(R.id.t9);
	  	et=(EditText) findViewById(R.id.input);
	  	et.setTransformationMethod(new PasswordTransformationMethod());
		}
		
		private void Random()
		{
			Random rand = new Random();
			int randnum;
			for(int i=0;i<9;i++)
			{
				randnum= rand.nextInt(9);
				tvArray[i].setText(""+randnum);
			}
		}
		
		private void makepassword()
		{
			SharedPreferences password = getSharedPreferences ("pass", Context.MODE_PRIVATE);
			p=password.getInt("password", 1234);
			SharedPreferences.Editor editor = password.edit();
			 editor.putInt("password",p);
			 editor.commit();
			ps=""+p;
			for(int i=0;i<(ps.length());i++){
				if(i==0){		
					pass=tvArray[Character.getNumericValue(ps.charAt(0))-1].getText().toString();
				}
				else if(i>0){
					pass=pass+tvArray[Character.getNumericValue(ps.charAt(i))-1].getText().toString();
				}
			}			
		}
		@Override
		public void onWindowFocusChanged(boolean hasFocus) {

		    currentFocus = hasFocus;

		    if (!hasFocus) {

		        // Method that handles loss of window focus
		        collapseNow();
		    }
		}
		@Override
		protected void onPause() {
		    super.onPause();

		    // Activity's been paused      
		    isPaused = true; 
		}

		@Override
		protected void onResume() {
		    super.onResume();

		    // Activity's been resumed
		    isPaused = false;
		}
		public void collapseNow() {

		    // Initialize 'collapseNotificationHandler'
		    if (collapseNotificationHandler == null) {
		        collapseNotificationHandler = new Handler();
		    }

		    // If window focus has been lost & LockScreen is not in a paused state,
		    // it steals the focus from current activity's window, but does not
		    // 'pause' the activity
		    // because showing of notification panel is not allowed.
		    if (!currentFocus && !isPaused) {

		        // Post a Runnable with some delay - currently set to 300 ms
		        collapseNotificationHandler.postDelayed(new Runnable() {

		            @Override
		            public void run() {

		                // Use reflection to trigger a method from 'StatusBarManager'                

		                Object statusBarService = getSystemService("statusbar");
		                Class<?> statusBarManager = null;

		                try {
		                    statusBarManager = Class.forName("android.app.StatusBarManager");
		                } catch (ClassNotFoundException e) {
		                    e.printStackTrace();
		                }

		                Method collapseStatusBar = null;

		                try {

		                    // Prior to API 17, the method to call is 'collapse()'
		                    // API 17 onwards, the method to call is `collapsePanels()`

		                    if (Build.VERSION.SDK_INT > 16) {
		                        collapseStatusBar = statusBarManager.getMethod("collapsePanels");
		                    } else {
		                        collapseStatusBar = statusBarManager.getMethod("collapse");
		                    }
		                } catch (NoSuchMethodException e) {
		                    e.printStackTrace();
		                }

		                collapseStatusBar.setAccessible(true);

		                try {
		                    collapseStatusBar.invoke(statusBarService);
		                } catch (IllegalArgumentException e) {
		                    e.printStackTrace();
		                } catch (IllegalAccessException e) {
		                    e.printStackTrace();
		                } catch (InvocationTargetException e) {
		                    e.printStackTrace();
		                }

		                // Check if the window focus has been returned.

		                // If it hasn't been returned, post this Runnable again
		                // Currently, the delay is 100 ms.
		                if (!currentFocus && !isPaused) {
		                    collapseNotificationHandler.postDelayed(this, 100L);
		                }

		            }
		        }, 300L);
		    }   
		}
		public void changeflag(Context c){
			SharedPreferences password = getSharedPreferences ("start", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = password.edit();
			 editor.putInt("s",1);
			 editor.commit();
		}
		
		public void setDate(){
			TextView date=(TextView) findViewById(R.id.date);
			Calendar calendar = Calendar.getInstance();
			int thisMonth = calendar.get(Calendar.MONTH);
			int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
			switch(thisMonth){
			case 0:date.setText(""+(thisDay)+" Jan");break;
			case 1:date.setText(""+(thisDay)+" Feb");break;
			case 2:date.setText(""+(thisDay)+" Mar");break;
			case 3:date.setText(""+(thisDay)+" Apr");break;
			case 4:date.setText(""+(thisDay)+" May");break;
			case 5:date.setText(""+(thisDay)+" Jun");break;
			case 6:date.setText(""+(thisDay)+" Jul");break;
			case 7:date.setText(""+(thisDay)+" Aug");break;
			case 8:date.setText(""+(thisDay)+" Sep");break;
			case 9:date.setText(""+(thisDay)+" Oct");break;
			case 10:date.setText(""+(thisDay)+" Nov");break;
			case 11:date.setText(""+(thisDay)+" Dec");break;

			}
		}
	}
