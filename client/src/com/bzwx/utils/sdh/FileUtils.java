package com.bzwx.utils.sdh;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URLEncoder;

import android.os.Environment;
import android.util.Log;

public class FileUtils {
	private String SDPATH;

	public String getSDPATH() {
		return SDPATH;
	}

	public FileUtils() {
		// /SDCARD
		SDPATH = Environment.getExternalStorageDirectory() + "/";
	}

	public String readFile(String path) throws FileNotFoundException {
		FileInputStream fin = new FileInputStream(path);
		String cfg = null;
		try {
			int leng = fin.available();
			// Log.d("leng", ""+leng);
			byte buffer[] = new byte[leng];
			fin.read(buffer);
			cfg = new String(buffer);
			// Log.d("File", cfg);
			return cfg;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public File creatSDFile(String fileName) throws IOException {
		File file = new File(SDPATH + fileName);
		file.createNewFile();
		return file;
	}

	public File creatSDDir(String dirName) {
		File dir = new File(SDPATH + dirName);
		dir.mkdir();
		return dir;
	}

	public long getSdFileSize(String fileName, String path) {
		// Log.d("gongjuu", SDPATH+fileName);
		File file = new File(SDPATH + path + fileName);
		long filesize = file.length();
		// Log.d("gongjuu ++", ""+filesize);
		return filesize;
	}

	public boolean isFileExist(String fileName) throws IOException {
		File file = new File(SDPATH + fileName);
		return file.exists();
	}

	public File write2SDFromInput(String path, String fileName,
			InputStream input) {
		File file = null;
		OutputStream output = null;
		int readnum = 0;
		try {
			creatSDDir(path);
			file = creatSDFile(path + fileName);
			output = new FileOutputStream(file);
			// byte buffer [] = new byte[1];
			// while((input.read(buffer)) != -1){
			// output.write(buffer);
			// }
			byte buffer[] = new byte[4 * 1024];
			while ((readnum = input.read(buffer)) != -1) {
				output.write(buffer, 0, readnum);
				output.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	// public File write2SDFromInput(String path, String fileName,
	// MeetingInfo mi) {
	// File file = null;
	// OutputStream output = null;
	// int readnum = 0;
	// try {
	// creatSDDir(path);
	// file = creatSDFile(path + fileName);
	// output = new FileOutputStream(file);
	// MeetingStatus.saveToxml(mi, output);
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// output.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// return file;
	// }
	public File continueSDFromInput(String path, String fileName,
			InputStream input) {
		File file = null;
		// OutputStream output = null;
		// int readnum = 0;
		try {
			creatSDDir(path);
			file = creatSDFile(path + fileName);
			Log.d("sd", SDPATH + path + fileName);
			RandomAccessFile oSavedFile = new RandomAccessFile(SDPATH + path
					+ fileName, "rw");
			long nPos = file.length();
			// 瀹氫綅鏂囦欢鎸囬拡鍒�nPos 浣嶇疆
			if (nPos != 0)
				nPos--;
			oSavedFile.seek(nPos);
			byte[] b = new byte[1024];
			int nRead;
			// 浠庤緭鍏ユ祦涓鍏ュ瓧鑺傛祦锛岀劧鍚庡啓鍒版枃浠朵腑
			while ((nRead = input.read(b, 0, 1024)) > 0) {
				oSavedFile.write(b, 0, nRead);
				// ((FileOutputStream) oSavedFile).write(b,0,nRead);
			}
			// output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// output.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	/**
	 * 鍒犻櫎鏂囦欢
	 * 
	 * @param filePathAndName
	 *            String 鏂囦欢璺緞鍙婂悕绉�濡俢:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * 鍒犻櫎鏂囦欢澶�
	 * 
	 * @param filePathAndName
	 *            String 鏂囦欢澶硅矾寰勫強鍚嶇О 濡俢:/fqf
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 鍒犻櫎瀹岄噷闈㈡墍鏈夊唴瀹�
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 鍒犻櫎绌烘枃浠跺す

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * 鍒犻櫎鏂囦欢澶归噷闈㈢殑鎵�湁鏂囦欢
	 * 
	 * @param path
	 *            String 鏂囦欢澶硅矾寰�濡�c:/fqf
	 */
	public void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 鍏堝垹闄ゆ枃浠跺す閲岄潰鐨勬枃浠�
				delFolder(path + "/" + tempList[i]);// 鍐嶅垹闄ょ┖鏂囦欢澶�
			}
		}
	}

}