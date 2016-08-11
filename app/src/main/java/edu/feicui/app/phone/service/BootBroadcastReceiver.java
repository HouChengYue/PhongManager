package edu.feicui.app.phone.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import edu.feicui.app.phone.main.LogoActivity;

/**
 * 实现开机启动(广播接收器)
 * Created by HCY on 2016/7/11.
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    static Context con;
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences boot = context.getSharedPreferences("boot", Context.MODE_PRIVATE);
        String action_boot = boot.getString("sta", "");
        if (intent.getAction().equals(action_boot)) {
            Intent StartIntent = new Intent(context, LogoActivity.class);//接收到广播后，跳转到HomeActivity
            StartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(StartIntent);
        }
    }

    /**
     * ToggleButton 的状态
     * @param context
     * @return ToggleButton的状态boolean
     */
    public static boolean isOpenboot(Context context) {
        con = context;
        //实例化SharedPreferences对象
        SharedPreferences boot = context.getSharedPreferences("boot", Context.MODE_PRIVATE);
//        //实例化SharedPreferences。Editor
//        SharedPreferences.Editor editor=boot.edit();
//        //用putString的方法保存数据
//        editor.putString("open","android.intent.action.BOOT_COMPLETED");
//        editor.putString("close","");
//        //提交当前数据
//        editor.commit();
        return boot.getBoolean("open", true);
    }

    public static void setOpenboot(Context context, boolean open) {
        con = context;
        SharedPreferences boot = context.getSharedPreferences("boot", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = boot.edit();
        editor.putBoolean("open", open);
        editor.putString("sta", "");
        editor.commit();
    }

    public static void On() {
        SharedPreferences boot = con.getSharedPreferences("boot", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = boot.edit();
        editor.putString("sta", "android.intent.action.BOOT_COMPLETED");
        editor.commit();
    }

    public static void Off() {
        SharedPreferences boot = con.getSharedPreferences("boot", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = boot.edit();
        editor.putString("sta", "");
        editor.commit();
    }
}

