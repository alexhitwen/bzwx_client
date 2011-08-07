package com.bzwx.net;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 网络连接类 com.bzwx.net.http.NetConnecter
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-8-5
 */
public class NetConnecter {

	private static String sessionId = null;

	// HTTP请求资源
	public static InputStream sendPOSTRequest(String path,
			Map<String, String> params, String encoding) throws Exception {
		StringBuilder entity = new StringBuilder();
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				entity.append(entry.getKey()).append("=");
				entity.append(URLEncoder.encode(entry.getValue(), encoding))
						.append("&");
			}
			entity.deleteCharAt(entity.length() - 1);
		}
		byte[] entitydata = entity.toString().getBytes();
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);// 允许对外输出数据
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length",
				String.valueOf(entitydata.length));
		OutputStream outStream = conn.getOutputStream();
		outStream.write(entitydata);
		if (conn.getResponseCode() == 200) { // 正确响应，返回数据
			InputStream inStream = conn.getInputStream();
			sessionId = conn.getHeaderField("Set-Cookie");
			System.out.println("sessionId :  " + sessionId);
			return inStream;

		}
		return null;
	}

	// 流读取方法
	public static byte[] read(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

}
