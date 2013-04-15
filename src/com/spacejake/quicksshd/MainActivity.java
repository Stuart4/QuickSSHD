package com.spacejake.quicksshd;

import android.app.Activity;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.spacejake.quicksshd.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(this, "This software is pre-alpha", Toast.LENGTH_LONG).show();
		TextView textIP;
		textIP = (TextView)findViewById(R.id.textView1);
		textIP.setText("Your IP Address is: " + getIP());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void listen (View view) {
		
		ToggleButton toggle;
		EditText userBox, passBox, portBox;
		ProgressBar progress;
		
		progress = (ProgressBar)findViewById(R.id.progressBar1);
		toggle = (ToggleButton)findViewById(R.id.toggleButton1);
		userBox = (EditText)findViewById(R.id.userField);
		passBox = (EditText)findViewById(R.id.passwordField);
		portBox = (EditText)findViewById(R.id.portField);		
		
		if (userBox.getText().toString().matches("")) {
			Toast.makeText(this, "Please enter a valid username", Toast.LENGTH_SHORT).show();
			toggle.setChecked(false);
			return;
		}else if (passBox.getText().toString().matches("")){
			Toast.makeText(this, "Please enter a valid password", Toast.LENGTH_SHORT).show();
			toggle.setChecked(false);
			return;
		}else if (portBox.getText().toString().matches("")){
			Toast.makeText(this, "Please enter a valid port", Toast.LENGTH_SHORT).show();
			toggle.setChecked(false);
			return;	
		}
		
		
		
		if (toggle.isChecked()) {
		progress.setIndeterminate(true);
		String username, password;
		int port;
		username = userBox.getText().toString();
		password = passBox.getText().toString();
		port = Integer.parseInt(portBox.getText().toString());
		}
		
		else {
			progress.setIndeterminate(false);
			
		}
		
		
	}
	
public String getIP () {
	String Address = null;
	WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
	WifiInfo wifiInfo = wifiManager.getConnectionInfo();
	int ipAddress = wifiInfo.getIpAddress();
	Address = String.format("%d.%d.%d.%d", 
			(ipAddress & 0xff), 
			(ipAddress >> 8 & 0xff), 
			(ipAddress >> 16 & 0xff),
			(ipAddress >> 24 & 0xff));
	return Address;
}
	}

