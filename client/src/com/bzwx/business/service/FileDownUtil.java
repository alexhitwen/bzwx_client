package com.bzwx.business.service;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

//import litsoft.utils.FileUtils;
//import litsoft.utils.MyHttp;
//import litsoft.utils.ParserXML;
//
//import sdhlogic.bean.LoginInfo;
//import sdhlogic.bean.MeetingInfo;
//import sdhlogic.bean.MeetingStatus;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class FileDownUtil {
	// // http://192.168.1.100:8080/sysdemo/status.action
	// public static String serverip = "192.168.1.100";
	// public String port = "8080";
	// public MyHttp httpDownloader = new MyHttp();
	//
	// // 联网读取是否有新文件
	// public MeetingStatus getState()
	// {
	// MeetingStatus ms = null;
	// try
	// {
	// URL url = new URL("http://" + serverip + ":" + port
	// + "/sysdemo/status.action");
	// Log.d("url", "---------------------------" + url.toString());
	// InputStream is = httpDownloader.getInputStreamFromUrl(url.toString());
	// ms = MeetingBeanUtil.getMeetingStatus(is);
	// }
	// catch (Exception e)
	// {
	// Log.d("error", "------------------------------" + e);
	// }
	// return ms;
	// }
	//
	// // 获取某一次会议的所有文件信息
	// public MeetingInfo getMeetingInfo(int meetingID)
	// {
	// MeetingInfo ms = null;
	// try
	// {
	// URL url = new URL("http://" + serverip + ":" + port
	// + "/sysdemo/mtinfo.action?mtId=" + meetingID);
	// HttpURLConnection hc = (HttpURLConnection) url.openConnection();
	// if (hc.getResponseCode() == 200)
	// {
	// InputStream is = hc.getInputStream();
	// ms = MeetingBeanUtil.getMeetingInfo(is);
	// }
	// }
	// catch (Exception e)
	// {
	// Log.d("error", "------------------------------" + e);
	// }
	// return ms;
	// }
	//
	// // 下载某一次会议的某个文件
	// public void downFile(String meetname, ArrayList<URL> fileurl,
	// ArrayList<String> allfname)
	// {
	// /**
	// * 循环下载文件
	// */
	// for (int j = 0; j < fileurl.size(); j++)
	// {
	// String urlStr = fileurl.get(j).toString();//
	// "http://192.168.7.104/litsoft";
	// String path = "LitsoftMeeting/" + URLEncoder.encode(meetname) + "/";
	// String fileName = allfname.get(j);
	// // SD鍗′笂鏂囦欢鍚�
	// fileName = URLEncoder.encode(fileName);
	// Log.d("path", "-----------------" + path + "," + fileName);
	//
	// httpDownloader.downFile(urlStr, path, fileName);
	// }
	//
	// }
	//
	// // 保存文件到SD卡
	// public static void saveFileToSD(MeetingInfo mi)
	// {
	// try
	// {
	// String path = "LitsoftMeeting/" + URLEncoder.encode(mi.name) + "/";
	// FileUtils fileUtils = new FileUtils();
	// byte[] dat = null;
	//
	// File resultFile = fileUtils.write2SDFromInput(path, "conf.xml", mi);
	// }
	// catch (Exception e)
	// {
	// Log.d("debug save xml", "err----------" + e);
	// }
	//
	// }
}
