package edu.feicui.app.phone.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * 
 * @author yuanc
 */
public class ToastUtil {

	private static Toast toast = null;

	public static void show(Context context, String text, int duration) {
		if (toast == null) {
			toast = Toast.makeText(context, text, duration);
		}
		toast.setText(text);
		toast.setDuration(duration);
		toast.show();
	}
}