package edu.feicui.app.phone.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtil {

	/**
	 * 浠庤緭鍏ユ祦涓幏鍙栨暟锟?	 * 
	 * @param inStream
	 *            杈撳叆锟?	 * @return
	 * @throws Exception
	 */
	public static byte[] readStreamToByte(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

	/**
	 * 浠庤緭鍏ユ祦涓幏鍙栨暟锟?	 * 
	 * @param inStream
	 *            杈撳叆锟?	 * @return
	 * @throws Exception
	 */
	public static String readStreamToString(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toString();
	}

	/**
	 * 灏嗚緭鍏ユ祦杞寲鎴愭煇瀛楃缂栫爜鐨凷tring
	 * 
	 * @param inStream
	 *            杈撳叆锟?	 * @param encoding
	 *            缂栫爜
	 * @return
	 * @throws Exception
	 */
	public static String readStreamToString(InputStream inStream, String encoding) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return new String(outStream.toByteArray(), encoding);
	}

}
