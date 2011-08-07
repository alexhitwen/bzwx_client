package com.bzwx.utils.sdh;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ParserXML
{
  String BOOKS_PATH = "/mnt/sdcard/LitsoftMeeting/xxx.xml";
  String URL_PATH = "/mnt/sdcard/voa/yyy.xml";

  public ParserXML()
  {

  }

  public List<String> ParseFileNameXML()
  {

    URL_PATH = "/mnt/sdcard/LitsoftMeeting/" + "/yyy.xml";
    File file = new File(URL_PATH);
    List<String> list = new ArrayList<String>();
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    try
    {
      db = dbf.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    Document doc = null;
    try
    {
      doc = db.parse(file);
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    Element root = doc.getDocumentElement();

    int num = root.getElementsByTagName("filename").getLength();

    for (int i = 0; i < num; i++)
    {
      Element f = (Element) root.getElementsByTagName("filename").item(i);
      
//      list.add(f.getFirstChild().getNodeValue());
      list.add(f.getAttribute("fname"));
    }
    return list;
  }
/**
 * 解析出yyy.xml中与会人员等信息
 * @param ID
 * @return
 */
  public List<String> ParseXML(String ID)
  {

    URL_PATH = "/mnt/sdcard/LitsoftMeeting/" + "/yyy.xml";
    File file = new File(URL_PATH);
    List<String> list = new ArrayList<String>();
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    try
    {
      db = dbf.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    Document doc = null;
    try
    {
      doc = db.parse(file);
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    Element root = doc.getDocumentElement();

    Element status = (Element) root.getElementsByTagName("mtID").item(0);
    list.add(status.getFirstChild().getNodeValue());

    Element status1 = (Element) root.getElementsByTagName("mtName").item(0);
    list.add(status1.getFirstChild().getNodeValue());

    Element status2 = (Element) root.getElementsByTagName("mtManger").item(0);
    list.add(status2.getFirstChild().getNodeValue());

    Element status22 = (Element) root.getElementsByTagName("mtPlace").item(0);
    list.add(status22.getFirstChild().getNodeValue());

    Element status3 = (Element) root.getElementsByTagName("mtPeoples").item(0);
    list.add(status3.getFirstChild().getNodeValue());

    int num = root.getElementsByTagName("file").getLength();

    for (int i = 0; i < num; i++)
    {
      Element f = (Element) root.getElementsByTagName("file").item(i);

      list.add(f.getFirstChild().getNodeValue());
    }
    return list;
  }

  public List<String> domParseXML()
  {
    File file = new File(BOOKS_PATH);
    List<String> list = new ArrayList<String>();
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    try
    {
      db = dbf.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    Document doc = null;
    try
    {
      doc = db.parse(file);
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    Element root = doc.getDocumentElement();
    Element status = (Element) root.getElementsByTagName("newmeeting").item(0);

    list.add(status.getFirstChild().getNodeValue());
    int num = root.getElementsByTagName("meetingID").getLength();
    for (int i = 0; i < num; i++)
    {
      Element meetingID = (Element) root.getElementsByTagName("meetingID")
          .item(i);

      list.add(meetingID.getFirstChild().getNodeValue());
    }
    return list;
  }

}
