package edu.feicui.app.phone.main;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.adapter.TellistAdapter;
import edu.feicui.app.phone.base.BaseActivity;
import edu.feicui.app.phone.db.DBRead;


public class TellistActivity
        extends BaseActivity
        implements AdapterView.OnItemClickListener
{
    private TellistAdapter adapter;
    private int idx = 0;
    private ListView listView;

    private void showCallDialog(String paramString1, final String paramString2)
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("警告");
        localBuilder.setMessage("是否开始拨打" + paramString1 + "电话 ? \n\nTEL：" + paramString2);
        localBuilder.setNegativeButton("取消", null);
        localBuilder.setPositiveButton("拨号", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
                Intent localIntent = new Intent("android.intent.action.CALL");
                localIntent.setData(Uri.parse("tel://" + paramString2));
                TellistActivity.this.startActivity(localIntent);
            }
        });
        localBuilder.show();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_tellist);
        this.idx = getIntent().getIntExtra("idx", -1);
        this.listView = ((ListView)findViewById(R.id.listview));
        this.adapter = new TellistAdapter(this);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
        showCallDialog(this.adapter.getItem(paramInt).name, this.adapter.getItem(paramInt).number);
    }

    protected void onResume()
    {
        super.onResume();
        this.adapter.addDataToAdapter(DBRead.readTeldbTable(this.idx));
        this.adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, TelmsgActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
