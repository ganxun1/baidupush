package com.baidu.pushdemo;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


/*
 * MainActivity为pushdemo的主Activity，主要实现Push的初始化及bind工作
 * 
 */

public class MainActivity extends Activity {
	
	private Button ak_init;
	
	//开发者中心获取的API Key
	private static final String API_KEY = "RzsF4GsrWwrdM69DnjZ2XHLP";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ak_init = (Button)findViewById(R.id.ak_init);
		
		ak_init.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// startWork()完成Push服务的初始化，并且完成自动bind工作		
				PushManager.startWork(getApplicationContext(),PushConstants.LOGIN_TYPE_API_KEY, API_KEY);
			}
						
		});
	}

}
