package edu.feicui.app.phone.db;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import edu.feicui.app.phone.util.LogUtil;
import edu.feicui.app.phone.entity.TelclassInfo;
import edu.feicui.app.phone.entity.TelnumberInfo;


public class DBRead {
    public static File telFile;//定义中转文件

    static {
        new File("data/data/edu.feicui.app.phone/").mkdirs();//创建文件目录
        telFile = new File("data/data/edu.feicui.app.phone/", "commonnum.db");//创建文件
        LogUtil.d("DBRead", "telFile dir path: " + "data/data/edu.feicui.app.phone/");
    }

    public static boolean isExistsTeldbFile() {
        File localFile = telFile;
        return (localFile.exists()) && (localFile.length() > 0L);
    }
    //数据传递时用一个参数以实现准确性
    public static ArrayList<TelclassInfo> readTeldbClasslist(Activity activity) {
        ArrayList localArrayList = new ArrayList();
        SQLiteDatabase localSQLiteDatabase =activity.openOrCreateDatabase("commonnum.db",
                Context.MODE_PRIVATE,null);

        try {
            AssetsDBManager.copyAssetsFileToFile(activity.getApplicationContext(),
                    "db/commonnum.db",new File(localSQLiteDatabase.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //打开数据库连接
        Cursor localCursor = localSQLiteDatabase.rawQuery("select * from classlist", null);
        //通过数据库查询（电话分类）
        LogUtil.d("DBRead", "read teldb classlist size: " + localCursor.getCount());
        if (localCursor.moveToFirst()) {
            do {
                localArrayList.add(new TelclassInfo(localCursor.getString(
                        localCursor.getColumnIndex("name")),
                        localCursor.getInt(localCursor.getColumnIndex("idx"))));
            } while (localCursor.moveToNext());
        }
        localCursor.close();
        localSQLiteDatabase.close();
        LogUtil.d("DBRead", "read teldb classlist end [list size]: " + localArrayList.size());
        return localArrayList;
    }

    /**
     * 查询具体号码
     *
     * @param paramInt 传入的下标
     * @return具体号码
     */
    public static ArrayList<TelnumberInfo> readTeldbTable(int paramInt) {
        SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(telFile, null);
        ArrayList localArrayList = new ArrayList();
        String str = "select * from table" + paramInt;
        Cursor localCursor = localSQLiteDatabase.rawQuery(str, null);
        LogUtil.d("DBRead", "read teldb number table size: " + localCursor.getCount());
        if (localCursor.moveToFirst()) {
            do {
                localArrayList.add(new TelnumberInfo(localCursor.getString(
                        localCursor.getColumnIndex("name")), localCursor.getString(
                        localCursor.getColumnIndex("number"))));
            } while (localCursor.moveToNext());
        }
        localCursor.close();
        localSQLiteDatabase.close();
        LogUtil.d("DBRead", "read teldb number table end [list size]: " + localArrayList.size());
        return localArrayList;
    }
}
