package uz.mahmudovdev.flagquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import uz.mahmudovdev.flagquiz.data.PreferenceManager;

public class QuestionActivity extends AppCompatActivity {
    TextView questionTen, questionFifteen, questionTwenty, questionTwentyFive;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        preferenceManager = new PreferenceManager();
        preferenceManager.getInstance(this);
        initUi();
        loadNumberQuestion();
    }

    private void loadNumberQuestion() {
        questionTen.setOnClickListener(view -> {
            preferenceManager.setNumberQuestions(10);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        questionFifteen.setOnClickListener(view -> {
            preferenceManager.setNumberQuestions(15);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        questionTwenty.setOnClickListener(view -> {
            preferenceManager.setNumberQuestions(20);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        questionTwentyFive.setOnClickListener(view -> {
            preferenceManager.setNumberQuestions(25);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void initUi() {
        questionTen = findViewById(R.id.question10);
        questionFifteen = findViewById(R.id.question15);
        questionTwenty = findViewById(R.id.question20);
        questionTwentyFive = findViewById(R.id.question25);
    }
}