package com.lj.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;

/**
 * 数据文件操作类
 * 
 * @author James 2014-3-13 10:47:18
 * 
 */
public class FileUtil {
	
	private static Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * 写入文件
	 * @param filePath 文件路径及名称
	 * @param jsonStr 写入字符串
	 */
	public static void writeFile(String filePath,String jsonStr){
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
			dataOutputStream.writeUTF(jsonStr);
			dataOutputStream.flush();
			dataOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("writeFile ERROR!",e);
		}
	}
	
	/**
	 * 读取文件
	 * @param filePath 文件路径及名称
	 */
	public static String readFile(String filePath){
		try {
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath));
			String jsonStr = dataInputStream.readUTF();
			dataInputStream.close();
			return jsonStr;
		} catch (Exception e) {
			logger.error("readFile ERROR!",e);
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String path = "./Test01.dat";
		writeFile(path, "999");
		String data = readFile(path);
		System.out.println(data);
		
	}
}
