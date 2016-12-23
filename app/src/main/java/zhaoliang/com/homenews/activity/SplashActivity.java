package zhaoliang.com.homenews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import zhaoliang.com.homenews.R;

public class SplashActivity extends Activity implements Animation.AnimationListener {

    private RelativeLayout splash;
    private AlphaAnimation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        splash = (RelativeLayout) findViewById(R.id.activity_splash);
        alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setAnimationListener(this);
        splash.startAnimation(alphaAnimation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
