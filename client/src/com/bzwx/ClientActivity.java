package com.bzwx;

import android.app.Activity;
import android.os.Bundle;

/**
 * 欢迎主页面 com.bzwx.ClientActivity
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-8-5
 */
public class ClientActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		login();
	}

	private void login() {
		
	}
	
	
}