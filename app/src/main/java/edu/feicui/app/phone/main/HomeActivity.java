package edu.feicui.app.phone.main;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.base.BaseActivity;
import edu.feicui.app.phone.biz.AppInfoManager;
import edu.feicui.app.phone.biz.MemoryManager;
import edu.feicui.app.phone.util.ToastUtil;
import edu.feicui.app.phone.view.ClearArcView;

/**
 * 0
 * 主页面
 *
 * @author dell
 */
public class HomeActivity extends BaseActivity {

    private View view_homeclear; // 一键清理圆
    private View view_homeclear_text; // 一键清理文本
    private long curTime = 0L;
    private long preTime = 0L;
    private TextView view_homeclear_score;// 一键清理
    private ClearArcView view_homeclear_arc;//圆饼
    private boolean isRuning = false;//是否正在清理
    private int state;
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_homeclear:
                case R.id.tv_homeclear_text:
                    // 清理所有正在运行程序
                    AppInfoManager.getAppInfoManager(HomeActivity.this).killALLProcesses();
                    // 重新初始控件数据
                    initHomeClearData();
                    break;
                case R.id.iv_left:
                    startActivity(AboutActivity.class, R.anim.in_left, R.anim.out_right);
                    break;
                case R.id.iv_right:
                    startActivity(SettingActivity.class, R.anim.in_right, R.anim.out_left);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // 初始化ActionBar @see super class ActionBarActivity
        String title = getResources().getString(R.string.app_name);
        initActionBar(title, R.drawable.ic_launcher, R.drawable.ic_child_configs, clickListener);
        // 初始化清理控件
        initHomeClear();
        // 初始化Clear数据
        initHomeClearData();
    }

    /**
     * 初始化一键清理
     */
    private void initHomeClear() {
        view_homeclear = findViewById(R.id.iv_homeclear);
        view_homeclear_text = findViewById(R.id.tv_homeclear_text);
        view_homeclear_score = (TextView) findViewById(R.id.tv_score);
        view_homeclear_arc = (ClearArcView) findViewById(R.id.homeclear_arc);
        view_homeclear.setOnClickListener(clickListener);
        view_homeclear_text.setOnClickListener(clickListener);
    }

    @Override
    protected void myHandleMessage(Message msg) {
        int u = msg.arg1;
        view_homeclear_score.setText(u + "");

    }

    private void initHomeClearData() {
//         获取到全部运行内存
        float totalRam = MemoryManager.getPhoneTotalRamMemory();
//         获取到空闲运行内存
        float freeRam = MemoryManager.getPhoneFreeRamMemory(getApplicationContext());
//         获取到已使用运行内存
        float usedRam = totalRam - freeRam;
//         计算出已使用运行内存比例
        float usedP = usedRam / totalRam;
        final int used100 = (int) (usedP * 100); // 计算出已使用运行内存百分比
        int angle = (int) (usedP * 360); // 计算出已使用运行内存角度
//        view_homeclear_score.setText(used100 + "");

        view_homeclear_arc.setAngleWithAnim(angle, view_homeclear_score);
    }

    /**
     * @see android:onClick=hitHomeitem
     */
    public void hitHomeitem(View view) {
        int viewID = view.getId();
        switch (viewID) {

            case R.id.ll_rocket:
                startActivity(SpeedupActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_filemgr:
                startActivity(FilemgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_softmgr:
                startActivity(SoftmgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_telmgr:
                startActivity(TelmsgActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_phonemgr:
                startActivity(PhonemgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_sdclean:
                startActivity(ClearActivity.class, R.anim.in_down, R.anim.out_up);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            this.curTime = System.currentTimeMillis();
            if (this.curTime - this.preTime <= 800L) {
                finish();
            }
            ToastUtil.show(getApplicationContext(), "再接一次退出", 0);
            this.preTime = this.curTime;
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }
}
