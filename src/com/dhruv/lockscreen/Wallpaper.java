package com.dhruv.lockscreen;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
//yo this works
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Wallpaper extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Define the XML file for the UI. 
		setContentView(R.layout.activity_wall);
		// Look up the AdView as a resource and load a request.
		AdView adView = (AdView)this.findViewById(R.id.walltop);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);
	 //load all the images
	 ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
     ImageLoader.getInstance().init(config);
     ImageLoader imageLoader = ImageLoader.getInstance();
     String imageUri = "drawable://" + R.drawable.bg_img1;
     ImageView imageView = (ImageView) findViewById(R.id.imageButton1);
     imageLoader.displayImage(imageUri,imageView);
     imageUri = "drawable://" + R.drawable.bg_img2;
     imageView = (ImageView) findViewById(R.id.imageButton2);
     imageLoader.displayImage(imageUri,imageView);
     imageUri = "drawable://" + R.drawable.bg_img3;
     imageView = (ImageView) findViewById(R.id.imageButton3);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img4;
     imageView = (ImageView) findViewById(R.id.imageButton4);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img5;
     imageView = (ImageView) findViewById(R.id.imageButton5);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img6;
     imageView = (ImageView) findViewById(R.id.imageButton6);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img7;
     imageView = (ImageView) findViewById(R.id.imageButton7);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img8;
     imageView = (ImageView) findViewById(R.id.imageButton8);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img9;
     imageView = (ImageView) findViewById(R.id.imageButton9);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img10;
     imageView = (ImageView) findViewById(R.id.imageButton10);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img11;
     imageView = (ImageView) findViewById(R.id.imageButton11);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img12;
     imageView = (ImageView) findViewById(R.id.imageButton12);
     imageLoader.displayImage(imageUri,imageView);
     imageLoader.displayImage(imageUri,imageView); imageUri = "drawable://" + R.drawable.bg_img13;
     imageView = (ImageView) findViewById(R.id.imageButton13);
     imageLoader.displayImage(imageUri,imageView);
     
     
	}
	//Functions to set the desired image as wallpaper for the LockScreen and show a message
	public void ib1(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img1);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib2(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img2);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib3(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img3);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib4(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img4);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib5(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img5);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib6(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img6);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib7(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img7);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib8(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img8);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib9(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img9);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib10(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img10);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib11(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img11);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib12(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img12);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}
	public void ib13(View v){
		SharedPreferences wallpaper = getSharedPreferences ("bg_img", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = wallpaper.edit();
		 editor.putInt("wallpaper",R.drawable.bg_img13);
		 editor.commit();
		 Toast.makeText(this.getBaseContext(),"Wallpaper Changed",Toast.LENGTH_SHORT).show();
	}


	
}