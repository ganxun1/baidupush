package com.baidu.pushdemo;

import com.baidu.android.pushservice.PushConstants;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


/**
 * Push消息处理
 */

public class PushMessageReceiver extends BroadcastReceiver {

	/**
	 * @param context
	 *            Context
	 * @param intent
	 *            接收消息的intent
	 */
	@Override
	public void onReceive(final Context context, Intent intent) {

		if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
			//获取Push消息内容
			String message = intent.getExtras().getString(
					PushConstants.EXTRA_PUSH_MESSAGE_STRING);
			
		} else if (intent.getAction().equals(PushConstants.ACTION_RECEIVE)) {
			
			//处理绑定等方法的返回数据
			//注:PushManager.startWork()的返回值通过PushConstants.METHOD_BIND得到
			
			//获取方法
			final String method = intent.getStringExtra(PushConstants.EXTRA_METHOD);
			
			//方法返回错误码,您需要恰当处理。比如，方法为bind时，若失败，需要重新bind,即重新调用startWork
			final int errorCode = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE,PushConstants.ERROR_SUCCESS);
			
			//返回内容
			final String content = new String(intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT));
			
			Toast.makeText(context,
					"method : " + method + "\n result: " + errorCode
							+ "\n content = " + content, Toast.LENGTH_SHORT).show();
				
		} else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
			//用户点击通知后的处理
			Intent aIntent = new Intent();
			aIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			aIntent.setClass(context, DisplayMessage.class);
			
			//Push信息的title
			String title = intent.getStringExtra(PushConstants.EXTRA_NOTIFICATION_TITLE);
			aIntent.putExtra(PushConstants.EXTRA_NOTIFICATION_TITLE, title);
			
			//Push信息的content
			String content = intent.getStringExtra(PushConstants.EXTRA_NOTIFICATION_CONTENT);
			aIntent.putExtra(PushConstants.EXTRA_NOTIFICATION_CONTENT, content);

			context.startActivity(aIntent);
		}
	}

}
