package com.bzwx.common.receiver;

import java.util.Date;
import java.util.List;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//import com.lenovo.netmeeting.client.DisplayGirdViewActivity;
//import com.lenovo.netmeeting.client.NetUtil;
//import com.lenovo.netmeeting.client.db.MeetDbUtil;
//import com.lenovo.netmeeting.client.model.Meet;

/**
 * 收到广播以后，连接服务器，更新会议数据库 com.bzwx.common.receiver.ProcessAlarmReceiver
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-8-5
 */
public class ProcessAlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
	}
//
//	private Context context;
//	private NotificationManager myNotiManager;
//
//	@Override
//	public void onReceive(Context context, Intent intent) {
//
//		this.context = context;
//
//		// 检查数据库是否打开
//		MeetDbUtil.openDb(context);
//
//		myNotiManager = (NotificationManager) (context
//				.getSystemService(Context.NOTIFICATION_SERVICE));
//
//		// int count = MeetDbUtil.getCount();
//		// Toast.makeText(context, "=======  "+count + "  ======", 1).show();
//		System.out.println("ProcessAlarmReceiver  "
//				+ MeetDbUtil.sdf.format(new Date(System.currentTimeMillis())));
//
//		// 连接服务器，查看是否有更新 // 若有更新，则下载更新
//		if (isHaveNewMeet()) {
//			updateMeetMessages();
//			setNotiType(com.lenovo.netmeeting.client.R.drawable.busy, "会议通知");
//		}
//	}
//
//	private List<String> meetidList;
//
//	protected void updateMeetMessages() {
//		System.out.println(meetidList);
//		for (String meetid : meetidList) {
//			Meet newMeet = NetUtil.getMeetById(meetid);
//			MeetDbUtil.addMeet(newMeet);
//		}
//
//		// MeetDbUtil.closeDb(); //关闭数据库 关闭数据库不是你干的事。
//	}
//
//	protected boolean isHaveNewMeet() {
//		// step1:在本地查找最近一条会议信息的时间 //第一次是null
//		Date localLastDate = MeetDbUtil.getLastPublishDate();
//		// 将这个时间发送至服务器，并接收返回的流数据
//		meetidList = NetUtil.getMeetIdsLast(localLastDate);
//
//		return meetidList == null ? false : true;
//	}
//
//	/* 发出Notification的method */
//	private void setNotiType(int iconId, String text) {
//		/*
//		 * 建立新的Intent，作为点选Notification留言条时， 会执行的Activity
//		 */
//		Intent notifyIntent = new Intent(context, DisplayGirdViewActivity.class);
//		notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		/* 建立PendingIntent作为设定递延执行的Activity */
//		PendingIntent appIntent = PendingIntent.getActivity(context, 0,
//				notifyIntent, 0);
//
//		/* 建立Notication，并设定相关参数 */
//		Notification myNoti = new Notification();
//		/* 设定statusbar显示的icon */
//		myNoti.icon = iconId;
//		/* 设定statusbar显示的文字讯息 */
//		myNoti.tickerText = text;
//		/* 设定notification发生时同时发出预设声音 */
//		myNoti.defaults = Notification.DEFAULT_SOUND;
//		// 点击通知以后，自动消除通知
//		myNoti.flags = Notification.FLAG_AUTO_CANCEL;
//		/* 设定Notification留言条的参数 */
//		myNoti.setLatestEventInfo(context, "有新会议通知，请注意查收！", text, appIntent);
//		/* 送出Notification */
//		myNotiManager.notify(0, myNoti);
//	}
}
