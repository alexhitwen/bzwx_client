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

public class MyHttp
{
  private URL url = null;

  public String download(String urlStr)
  {
    StringBuffer sb = new StringBuffer();
    String line = null;
    BufferedReader buffer = null;
    try
    {
      url = new URL(urlStr);
      HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

      buffer = new BufferedReader(new InputStreamReader(
          urlConn.getInputStream()));
      while ((line = buffer.readLine()) != null)
      {
        sb.append(line);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        buffer.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }

  /**
   * return -1:error 0:success 1:cun zai
   */
  public int downFile(String urlStr, String path, String fileName)
  {
    InputStream inputStream = null;
    int stat = 0;
    String fname = "";
    fname = fileName;
    FileUtils fileUtils = new FileUtils();
    Log.d("zmkeyi cunzai", path + fname);
    try
    {
      if (fileUtils.isFileExist(path + (fname)))
      {
//        long fl = getFileSize(urlStr + "/" + (fname));
        long fl = getFileSize(urlStr);
        long sdl = fileUtils.getSdFileSize((fname),path);
        Log.d("File Size", "" + sdl + "    " + fl);
        if (sdl < fl)
        {
          stat = 1;
//          inputStream = getInputStream(urlStr + "/" + fileName, sdl);
          inputStream = getInputStream(urlStr + "/" + fileName, sdl);
          /**
           * 王迪远测试注释，不能删除
           */
//          File f1 = 
            fileUtils.continueSDFromInput(path, fileName, inputStream);
          // byte b[] = new byte[100];
          // inputStream.read(b);
          // String sss = new String(b);
          // Log.d("ce shi", sss);
        }

        // return 1;
      }
      else
      {
        stat = 1;
        Log.d("urlStr", urlStr);

//        inputStream = getInputStreamFromUrl(urlStr + "/" + fileName);
        inputStream = getInputStreamFromUrl(urlStr);
        File resultFile = fileUtils.write2SDFromInput(path, fileName,
            inputStream);

        if (resultFile == null)
        {
          return -1;
        }
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
      return -1;
    }
    finally
    {
      try
      {
        if (stat == 1)
          inputStream.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    return 0;
  }

  public InputStream getInputStream(String urlStr, long sdl)
      throws MalformedURLException, IOException
  {
    url = new URL(urlStr);
    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
    Log.d("           ", "daoma");
    urlConn.setRequestProperty("User-Agent", "NetFox");
    if (sdl != 0)
      sdl--;
    String pos = "bytes=" + sdl + "-";
    urlConn.setRequestProperty("RANGE", pos);
    InputStream inputStream = urlConn.getInputStream();
    Log.d("           ", "daoma2");
    return inputStream;
  }

  /**
   * 鏍规嵁url瀛楃涓插緱鍒拌緭鍏ユ祦
   * 
   * @param urlStr
   * @return
   * @throws MalformedURLException
   * @throws IOException
   *           2147483647 62292883
   */
  public InputStream getInputStreamFromUrl(String urlStr)
      throws MalformedURLException, IOException
  {
    // long nFileLength;
    url = new URL(urlStr);
    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

    InputStream inputStream = urlConn.getInputStream();
    return inputStream;
  }

  public long getFileSize(String urlStr) throws MalformedURLException,
      IOException
  {
    long nFileLength = 0;
    url = new URL(urlStr);
    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
    /**
     * 王迪远测试注释，不能删除
     */
//    int responseCode = 
      urlConn.getResponseCode();
    String sHeader;

    for (int i = 1;; i++)
    {
      sHeader = urlConn.getHeaderFieldKey(i);
      if (sHeader != null)
      {
        if (sHeader.equals("Content-Length"))
        {
          nFileLength = Long.parseLong(urlConn.getHeaderField(sHeader));
          break;
        }
      }
      else
        break;
    }
    urlConn.disconnect();
    return nFileLength;
  }

  public List<String> getFileName(String urlStr)
  {
    String lrc = this.download(urlStr);
    List<String> filelist = new ArrayList<String>();
    int idend;
    int id;
    id = lrc.indexOf("Parent Directory") + "Parent Directory".length();
    while (true)
    {
      id = lrc.indexOf("href=\"", id);
      if (-1 == id)
        break;
      // id = lrc.indexOf("\"> ", id);
      // id += "\"> ".length();
      // idend = lrc.indexOf("</a><", id+1);
      id += "href=\"".length();
      idend = lrc.indexOf("\"> ", id + 1);
      String filename = new String();
      filename = lrc.substring(id, idend);
      id = idend;
      filelist.add(filename);
    }
    return filelist;
  }

  public List<String> getFilename(String urlStr)
  {
    String lrc = this.download(urlStr);
    List<String> filelist = new ArrayList<String>();
    int idend;
    int id;
    id = lrc.indexOf("Parent Directory") + "Parent Directory".length();
    while (true)
    {
      id = lrc.indexOf("href=\"", id);
      if (-1 == id)
        break;
      id = lrc.indexOf("\"> ", id);
      id += "\"> ".length();
      idend = lrc.indexOf("</a><", id + 1);
      // id += "href=\"".length();
      // idend = lrc.indexOf("\"> ", id + 1);
      String filename = new String();
      filename = lrc.substring(id, idend);
      id = idend;
      filelist.add(filename);
    }
    return filelist;
  }

}
