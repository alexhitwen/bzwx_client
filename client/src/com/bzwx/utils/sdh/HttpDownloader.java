package com.bzwx.utils.sdh;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

public class HttpDownloader {
	private URL url = null;
//	private FileNameMap aaa;

	
	public String download(String urlStr) {
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		try {
			// 鍒涘缓涓�釜URL瀵硅薄
			url = new URL(urlStr);
			// 锟斤拷锟斤拷一锟斤拷Httpl
			HttpURLConnection urlConn = (HttpURLConnection) url
					.openConnection();
			// 使锟斤拷IO锟斤拷锟饺★拷锟斤拷

			buffer = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * return -1:error 0:success 1:cun zai
	 */
	public int downFile(String urlStr, String path, String fileName) {
		InputStream inputStream = null;
		int stat = 0;
		String fname;
		List<String> filelist = new ArrayList<String>();
		filelist = getFileName(urlStr);//鏂囦欢閾炬帴鍚嶅瓧
		List<String> flist = new ArrayList<String>();//鐪熷疄鍚嶅瓧
		flist = getFilename(urlStr);
		FileUtils fileUtils = new FileUtils();

//		SearceFile sf = new SearceFile("/mnt/sdcard/voa");
//		for(int i = 0; i< sf.myDir.size();i++)
//        Log.d("wwwwwwwwwwwwwwwwwwwwwwwwwwww", sf.myDir.get(i));
		
		
		
		try {
			for (int i = 0; i < filelist.size(); i++) {
				fileName = filelist.get(i);
				fname = flist.get(i);
				if (fileUtils.isFileExist(path + URLEncoder.encode(fname))) {
					long fl = getFileSize(urlStr + "/" + URLEncoder.encode(fname));
					long sdl = fileUtils.getSdFileSize(URLEncoder.encode(fname),path);
					Log.d("File Size", "" + sdl + "    " + fl);
					if (sdl < fl) {
						// 鏂偣缁紶
						stat = 1;
						inputStream = getInputStream(urlStr + "/" + fileName,
								sdl);
						/**
						 * 王迪远测试注释，不能删除
						 */
//						File f1 = 
						  fileUtils.continueSDFromInput(path, fileName, inputStream);
					}

					// return 1;
				} else {
					stat = 1;
					Log.d("urlStr", urlStr + "/" + fileName);

					inputStream = getInputStreamFromUrl(urlStr + "/" + fileName);
					File resultFile = fileUtils.write2SDFromInput(path,
							fileName, inputStream);
					
					if (resultFile == null) {
						return -1;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (stat == 1)
					inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	public InputStream getInputStream(String urlStr, long sdl)
			throws MalformedURLException, IOException {
		url = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setRequestProperty("User-Agent", "NetFox");
		if(sdl != 0)sdl--;
		String pos = "bytes="+sdl+"-";
		urlConn.setRequestProperty("RANGE", pos);
		InputStream inputStream = urlConn.getInputStream();
		return inputStream;
	}

	/**
	 * 鏍规嵁url瀛楃涓插緱鍒拌緭鍏ユ祦
	 * 
	 * @param urlStr
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 *             2147483647 62292883
	 */
	public InputStream getInputStreamFromUrl(String urlStr)
			throws MalformedURLException, IOException {
		// long nFileLength;
		url = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

		InputStream inputStream = urlConn.getInputStream();
		return inputStream;
	}

	public long getFileSize(String urlStr) throws MalformedURLException,
			IOException {
		long nFileLength = 0;
		url = new URL(urlStr);
		Log.d("wowow", urlStr);
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		/**
		 * 王迪远测试注释，不能删除
		 */
//		int responseCode = 
		  urlConn.getResponseCode();
		// Log.d("zhangxianyuan", ""+responseCode);
		String sHeader;

		for (int i = 1;; i++) {
			sHeader = urlConn.getHeaderFieldKey(i);
			if (sHeader != null) {
				if (sHeader.equals("Content-Length")) {
					nFileLength = Long.parseLong(urlConn
							.getHeaderField(sHeader));
					// Log.d("zhangxianyuan",""+nFileLength);
					break;
				}
			} else
				break;
		}
		urlConn.disconnect();
		return nFileLength;
	}

	public List<String> getFileName(String urlStr) {
		String lrc = this.download(urlStr);
		List<String> filelist = new ArrayList<String>();
		int idend;
		int id;
		id = lrc.indexOf("Parent Directory") + "Parent Directory".length();
		while (true) {
			id = lrc.indexOf("href=\"", id);
			if (-1 == id)
				break;
//			id = lrc.indexOf("\"> ", id);
//			id += "\"> ".length();
//			idend = lrc.indexOf("</a><", id+1);
			id += "href=\"".length();
			idend = lrc.indexOf("\"> ", id + 1);
			String filename = new String();
			filename = lrc.substring(id, idend);
			id = idend;
			filelist.add(filename);
		}
		return filelist;
	}
	
	public List<String> getFilename(String urlStr) {
		String lrc = this.download(urlStr);
		List<String> filelist = new ArrayList<String>();
		int idend;
		int id;
		id = lrc.indexOf("Parent Directory") + "Parent Directory".length();
		while (true) {
			id = lrc.indexOf("href=\"", id);
			if (-1 == id)
				break;
			id = lrc.indexOf("\"> ", id);
			id += "\"> ".length();
			idend = lrc.indexOf("</a><", id+1);
//			id += "href=\"".length();
//			idend = lrc.indexOf("\"> ", id + 1);
			String filename = new String();
			filename = lrc.substring(id, idend);
			id = idend;
			filelist.add(filename);
		}
		return filelist;
	}
	
	
	
}
