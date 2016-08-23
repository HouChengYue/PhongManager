package edu.feicui.app.phone.main;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.adapter.RubbishFileAdapter;
import edu.feicui.app.phone.base.BaseActivity;
import edu.feicui.app.phone.biz.DbClearPathManager;
import edu.feicui.app.phone.biz.FileManager;
import edu.feicui.app.phone.entity.RubbishFileInfo;
import edu.feicui.app.phone.util.CommonUtil;
import edu.feicui.app.phone.util.LogUtil;

/**
 * 垃圾清理
 */
public class ClearActivity extends BaseActivity {

    private ProgressBar pb_loading;//加载图标
    private ListView lv_rubbishListview;
    private RubbishFileAdapter rubbishFileAdapter;//垃圾清理适配器
    private TextView tv_totalsize;
    private Button bt_key;//一键清理按钮
    private CheckBox checkBox;//复选框
    private ArrayList<RubbishFileInfo> rubbishFileInfos = null;
    private long totalSize = 0; // 用来保存总大小的变量
    private CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // 将运行中应用程序列表全选
            List<RubbishFileInfo> rubbishFileInfos = rubbishFileAdapter.getDataList();
            for (RubbishFileInfo r : rubbishFileInfos) {
                r.setClear(isChecked);//设置为选中
            }
            // 更新适配器
            rubbishFileAdapter.notifyDataSetChanged();
            LogUtil.d("一", "全选……………………………………………………被单击");
        }
    };
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left:
                    finish();
                    break;
                case R.id.btn_clearrubbish:
                    LogUtil.d("一键清理", "一键清理………………………………………………被单击");
                    List<RubbishFileInfo> rubbishFileInfos = rubbishFileAdapter.getDataList();
                    for (RubbishFileInfo r : rubbishFileInfos) {
                        if (r.isClear()) {
                            String filepath = r.getFilepath();
                            File f = new File(filepath);
                            Delet(f);

                        }
                    }
                    //刷新列表
                    try {
                        asyncLoaddata();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    checkBox.setChecked(false);
                    break;

//                    cb_all// 清理选中的进程
//                    List<RuningAppInfo> appInfos = runingAppAdapter.getDataList();
//                    for (RuningAppInfo appInfo : appInfos) {
//                        if (appInfo.isClear()) {
//                            String packageName = appInfo.getPackageName();
//                            AppInfoManager.getAppInfoManager(getApplicationContext()).killProcesses(packageName);
//                        }
//                    }
//                    // 重新加载刷新数据
//                    loadData();
//                    cb_checkClearAll.setChecked(false);
            }
        }
    };

    //删除文件的方法
    public static void Delet(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File f[] = file.listFiles();
            if (f == null || f.length == 0) {
                file.delete();
            }
            for (File fi : f) {
                Delet(fi);
            }
            file.delete();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);

        // 初始化ActionBar @see super class ActionBarActivity
        String title = getResources().getString(R.string.sdclean);
        initActionBar(title, R.drawable.btn_homeasup_default, -1, clickListener);
        //
        tv_totalsize = (TextView) findViewById(R.id.tv_filesize);
        pb_loading = (ProgressBar) findViewById(R.id.progressBar);
        lv_rubbishListview = (ListView) findViewById(R.id.listivewRubbish);

        rubbishFileAdapter = new RubbishFileAdapter(this);
        lv_rubbishListview.setAdapter(rubbishFileAdapter);

        checkBox = (CheckBox) findViewById(R.id.cb_all);
        checkBox.setOnCheckedChangeListener(changeListener);
        bt_key = (Button) findViewById(R.id.btn_clearrubbish);
        bt_key.setOnClickListener(clickListener);
        //刷新列表
        try {
            asyncLoaddata();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void myHandleMessage(Message msg) {
        // TODO Auto-generated method stub
        if (msg.what == 1) {
            long size = (Long) msg.obj;
            totalSize += size;
            tv_totalsize.setText(CommonUtil.getFileSize(totalSize));
        }
        if (msg.what == 2) {
            @SuppressWarnings("unchecked")
            ArrayList<RubbishFileInfo> rubbishFileInfos = (ArrayList<RubbishFileInfo>) msg.obj;
            pb_loading.setVisibility(View.INVISIBLE);
            lv_rubbishListview.setVisibility(View.VISIBLE);
            rubbishFileAdapter = new RubbishFileAdapter(ClearActivity.this);
            lv_rubbishListview.setAdapter(rubbishFileAdapter);
            rubbishFileAdapter.setDataToAdapter(rubbishFileInfos);
            rubbishFileAdapter.notifyDataSetChanged();
        }
    }

    private void asyncLoaddata() throws IOException {
        InputStream path = getResources().getAssets().open("db/clearpath.db");
        DbClearPathManager.readUpdateDB(path);
        final ArrayList<RubbishFileInfo> FileInfos = DbClearPathManager.getPhoneRubbishfile(getApplicationContext());
        totalSize = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (RubbishFileInfo rubbishFileInfo : FileInfos) {
                    File file = new File(rubbishFileInfo.getFilepath());
                    long size = FileManager.getFileSize(file);
                    rubbishFileInfo.setSize(size);
                    // 更新全部大小
                    Message msg = mainHandler.obtainMessage();
                    msg.what = 1;
                    msg.obj = size;
                    mainHandler.sendMessage(msg);
                }
                // 全部加载完毕 更新UI
                Message msg = mainHandler.obtainMessage();
                msg.what = 2;
                msg.obj = FileInfos;
                mainHandler.sendMessage(msg);
            }
        }).start();
    }
}