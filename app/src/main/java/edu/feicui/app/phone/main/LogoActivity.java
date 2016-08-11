package edu.feicui.app.phone.main;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.base.BaseActivity;


/**
 * 欢迎界面
 */
public class LogoActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
//  初始控件及动画
		ImageView img_logo = (ImageView) findViewById(R.id.iv_logo);
// logo  图像控件开始动画
		img_logo.setBackgroundResource(R.drawable.draw);
		AnimationDrawable animationDrawable = (AnimationDrawable) img_logo.getBackground();
		animationDrawable.setOneShot(true);//.setOneshot(true 播放一次动画) 帧动画默认是false循环播放
		animationDrawable.start();
		Animation animation= AnimationUtils.loadAnimation(this, R.anim.anim_logo);
		animation.setFillEnabled(true);
		img_logo.setAnimation(animation);
		animation.setAnimationListener(animationListener);
	}



	private Animation.AnimationListener animationListener = new Animation.AnimationListener(){
		// 动画开始
		@Override
		public void onAnimationStart(Animation animation) {}
		// 动画重复
		@Override
		public void onAnimationRepeat(Animation animation) {}
		// 动画结束
		@Override
		public void onAnimationEnd(Animation animation) {
			Intent intent = new Intent(LogoActivity.this,
					HomeActivity.class);
			startActivity(intent);
			finish();
		}
	};
}
