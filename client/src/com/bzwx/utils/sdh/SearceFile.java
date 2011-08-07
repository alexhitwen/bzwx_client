package com.bzwx.utils.sdh;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class SearceFile 
{
	
	public List<String> myDir = new ArrayList<String>();
//	String filepath = new String();
	
	public SearceFile(String filepath)
	{
	File home = new File(filepath);
	
		if(( home.listFiles()).length > 0)
		{
//			for(File file : home.listFiles(new MyFilter()))
//			{
//				myDir.add(file.getName());
//			}
			for(File file : home.listFiles())
				{
					myDir.add(file.getName());
				}
		}
		
	}

}