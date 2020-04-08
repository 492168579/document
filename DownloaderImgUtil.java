package com.rms.ypzw.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloaderImgUtil {

	private static String imgPath = "C:\\Users\\Alex\\Pictures\\shuzi\\";
	private static String imgURL = "http://39.107.238.105/image/";

	public static void main(String[] args) {
		try {
			List<String> imgs = readFileByLines(
					"C:\\znyp\\web\\powergrid\\powergrid-service\\src\\main\\resources\\img.txt");
			for (String imgName : imgs) {
				byte[] imgByte = getImageFromNetByUrl(imgURL + imgName);
				writeImageToDisk(imgByte, imgName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> readFileByLines(String fileName) throws Exception {
		File file = new File(fileName);
		BufferedReader reader = null;
		List<String> imgs = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
				imgs.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return imgs;
	}

	public static void writeImageToDisk(byte[] img, String fileName) {
		try {
			File file = new File(imgPath + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] getImageFromNetByUrl(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();// 通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);// 得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
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