package com.example.surfaceviewexample;


 
import com.example.surfaceviewexample.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	MySurfaceView myview   ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 myview = (MySurfaceView)  findViewById(R.id.s1View);
	}
	private MySurfaceView findViewById(Class<id> class1) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//  super.onKeyDown(keyCode, event);
		    
			   myview.xpos = 50;
			   myview.ypos = 100;
		  return true;
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
