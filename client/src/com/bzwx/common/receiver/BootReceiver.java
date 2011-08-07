package com.bzwx.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
//		MeetDbUtil.openDb(context);		//监听到开机广播，打开数据库	
//		Map<String, String> sysMap = MeetDbUtil.getSysMap(); // 取得系统设置
//		if ("true".equals(sysMap.get(MeetDb.IS_AUTO_LOGIN))) {
//			Intent service = new Intent(context, SystemService.class);
//			context.startService(service); // 启动监听服务
//		}
		
		
	}
}
