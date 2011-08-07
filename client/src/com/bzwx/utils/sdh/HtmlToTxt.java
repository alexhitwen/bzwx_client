package com.bzwx.utils.sdh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

public class HtmlToTxt {
	public String HtmlToTextGb2312(String inputString) 
    { 
		Log.d("htt", "kaishi zhuanghuan");
              String htmlStr = inputString; //鍚玥tml鏍囩鐨勫瓧绗︿覆 
              String textStr =""; 
              Pattern p_script; 
              Matcher m_script; 
              Pattern p_style; 
              Matcher m_style; 
              Pattern p_html; 
              Matcher m_html;
              Pattern p_houhtml; 
              Matcher m_houhtml;
              Pattern p_spe; 
              Matcher m_spe;
              Pattern p_blank; 
              Matcher m_blank;
              Pattern p_table; 
              Matcher m_table;
              Pattern p_enter; 
              Matcher m_enter;
           
              try { 
               String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; 
               //瀹氫箟script鐨勬鍒欒〃杈惧紡.
               String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; 
               //瀹氫箟style鐨勬鍒欒〃杈惧紡. 
               String regEx_html = "<[^>]+>"; 
               //瀹氫箟HTML鏍囩鐨勬鍒欒〃杈惧紡 
               String regEx_houhtml = "/[^>]+>"; 
               //瀹氫箟HTML鏍囩鐨勬鍒欒〃杈惧紡 
               String regEx_spe="\\&[^;]+;";
               //瀹氫箟鐗规畩绗﹀彿鐨勬鍒欒〃杈惧紡
               String regEx_blank=" +";
               //瀹氫箟澶氫釜绌烘牸鐨勬鍒欒〃杈惧紡
               String regEx_table="\t+";
               //瀹氫箟澶氫釜鍒惰〃绗︾殑姝ｅ垯琛ㄨ揪寮�              
               String regEx_enter="\n+";
               //瀹氫箟澶氫釜鍥炶溅鐨勬鍒欒〃杈惧紡

               p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
               m_script = p_script.matcher(htmlStr); 
               htmlStr = m_script.replaceAll(""); //杩囨护script鏍囩

               p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
               m_style = p_style.matcher(htmlStr); 
               htmlStr = m_style.replaceAll(""); //杩囨护style鏍囩 
              
               p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
               m_html = p_html.matcher(htmlStr); 
               htmlStr = m_html.replaceAll(""); //杩囨护html鏍囩 
               
               p_houhtml = Pattern.compile(regEx_houhtml,Pattern.CASE_INSENSITIVE); 
               m_houhtml = p_houhtml.matcher(htmlStr); 
               htmlStr = m_houhtml.replaceAll(""); //杩囨护html鏍囩 
               
               p_spe = Pattern.compile(regEx_spe,Pattern.CASE_INSENSITIVE); 
               m_spe = p_spe.matcher(htmlStr); 
               htmlStr = m_spe.replaceAll(""); //杩囨护鐗规畩绗﹀彿 
               
               p_blank = Pattern.compile(regEx_blank,Pattern.CASE_INSENSITIVE); 
               m_blank = p_blank.matcher(htmlStr); 
               htmlStr = m_blank.replaceAll(" "); //杩囨护杩囧鐨勭┖鏍�               
               p_table = Pattern.compile(regEx_table,Pattern.CASE_INSENSITIVE); 
               m_table = p_table.matcher(htmlStr); 
               htmlStr = m_table.replaceAll(" "); //杩囨护杩囧鐨勫埗琛ㄧ
               
                   
               p_enter = Pattern.compile(regEx_enter,Pattern.CASE_INSENSITIVE); 
               m_enter = p_enter.matcher(htmlStr); 
               htmlStr = m_enter.replaceAll(" "); //杩囨护杩囧鐨勫埗琛ㄧ
               
               textStr = htmlStr; 
              
              }catch(Exception e) 
              { 
                    System.err.println("Html2Text: " + e.getMessage()); 
              } 
           
              return textStr;//杩斿洖鏂囨湰瀛楃涓�
    }
}
