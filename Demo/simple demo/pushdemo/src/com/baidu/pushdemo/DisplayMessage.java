package com.baidu.pushdemo;

import com.baidu.android.pushservice.PushConstants;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;


/*
 * 当用户点击Notification后现显示该Activity
 * 
 */


public class DisplayMessage extends Activity {
	
	private TextView message_title;
	private TextView message_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_message);
		
		message_title = (TextView)findViewById(R.id.message_tile);
		message_content = (TextView)findViewById(R.id.message_content);
		
		//获取push消息的title和content
		Intent intent = getIntent();
        String title = intent.getStringExtra(PushConstants.EXTRA_NOTIFICATION_TITLE);
        String content = intent.getStringExtra(PushConstants.EXTRA_NOTIFICATION_CONTENT);
        
        message_title.setText(title);
        message_content.setText(content);
        
	}

}
