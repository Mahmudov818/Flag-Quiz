package uz.mahmudovdev.flagquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Animation scaleAnimation;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initUi();
        loadAnimation();
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, QuestionActivity.class);
            startActivity(intent);
            finish();
        }, 2300);

    }

    private void loadAnimation() {
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        imageView.startAnimation(scaleAnimation);

    }

    private void initUi() {
        imageView = findViewById(R.id.imageWorld);
        textView = findViewById(R.id.text);
    }
}