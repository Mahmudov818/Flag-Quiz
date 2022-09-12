package uz.mahmudovdev.flagquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView result;
    int rightAnswer = MainActivity.rightAnswers;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initUI();
        result.setText("Congratulations your result: "+rightAnswer);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,QuestionActivity.class));
        finish();
        MainActivity.rightAnswers=0;
    }

    private void initUI() {
        result = findViewById(R.id.result);
    }
}