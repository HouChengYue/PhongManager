package edu.feicui.app.phone.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.adapter.TelclassAdapter;
import edu.feicui.app.phone.base.BaseActivity;
import edu.feicui.app.phone.util.ToastUtil;
import edu.feicui.app.phone.db.AssetsDBManager;
import edu.feicui.app.phone.db.DBRead;
import edu.feicui.app.phone.entity.TelclassInfo;


public class TelmsgActivity
        extends BaseActivity
        implements AdapterView.OnItemClickListener
{
    private TelclassAdapter adapter;


    /**
     * 初始化数据库
     */
    private void initAppDBFile()
    {
        if (!DBRead.isExistsTeldbFile()) {}
        try
        {
            AssetsDBManager.copyAssetsFileToFile(
                    getApplicationContext(), "db/commonnum.db", DBRead.telFile);
            return;
        }
        catch (IOException localIOException)
        {
            ToastUtil.show(this, "初始通讯大全数据库文件异常", 0);
        }
    }

    /**
     * 适配listview 并设置监听
     * @param paramBundle
     */
    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_telmsg);

        ListView listView = ((ListView)findViewById(R.id.list_item));
        ArrayList<TelclassInfo> telclassInfos = DBRead.readTeldbClasslist(this);
        this.adapter=new TelclassAdapter(TelmsgActivity.this, telclassInfos);
            listView.setAdapter(this.adapter);
            listView.setOnItemClickListener(this);

        String title = getResources().getString(R.string.tel_title);
        initActionBar(title, R.drawable.btn_homeasup_default, -1, clickListener);
        // 初始化主按钮(开机启动，通知图标，消息推送,关于我们.....)

    }

    /**
     * 跳转实现方法
     * @param paramAdapterView
     * @param paramView
     * @param paramInt
     * @param paramLong
     */
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
        if (paramInt == 0)
        {
            Intent localIntent1 = new Intent();
            localIntent1.setAction("android.intent.action.DIAL");//本地拨号位置一
            startActivity(localIntent1);
            return;
        }
        TelclassInfo localTelclassInfo = this.adapter.getItem(paramInt);
        Intent localIntent2 = new Intent(this, TellistActivity.class);
        localIntent2.putExtra("idx", localTelclassInfo.idx);
        startActivity(localIntent2);
    }


    protected void onResume()
    {
        super.onResume();
        initAppDBFile();
        this.adapter.clearDataTOAdapter();//清楚适配器列表中的数据
        this.adapter.addDataToAdapter(new TelclassInfo("本地电话", 0));
        //t添加本地号码，并放在第一位置
        this.adapter.addDataToAdapter(DBRead.readTeldbClasslist(this));
        this.adapter.notifyDataSetChanged();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left:
                    startActivity(HomeActivity.class);
                    finish();
                    break;
            }
        }
    };

}
