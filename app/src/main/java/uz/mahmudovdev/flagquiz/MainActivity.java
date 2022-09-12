package uz.mahmudovdev.flagquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uz.mahmudovdev.flagquiz.data.PreferenceManager;
import uz.mahmudovdev.flagquiz.model.QuestionModel;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView answer1, answer2, answer3, answer4, numQuestion;
    ArrayList<QuestionModel> questionsList = new ArrayList<>();
    int indexQuestion = 0;
    static int rightAnswers = 0;
    int numberQuestions;
    PreferenceManager preferenceManager;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceManager = new PreferenceManager();
        numberQuestions = preferenceManager.getNumberQuestions();
        initUI();
        loadQuestions();
        setUi(indexQuestion);
        numQuestion.setText((indexQuestion+1) + "/" + numberQuestions);
        answer1.setOnClickListener(view -> {
            if (answer1.getText() == questionsList.get(indexQuestion).getRealAnswer()) {
                rightAnswers++;
                setRightAnswerBackground(answer1);
            } else {
                setErrorAnswerBackground(answer1);
            }
            new Handler().postDelayed(() -> setUi(++indexQuestion), 200);
        });

        answer2.setOnClickListener(view -> {
            if (answer2.getText() == questionsList.get(indexQuestion).getRealAnswer()) {
                rightAnswers++;
                setRightAnswerBackground(answer2);
            } else {
                setErrorAnswerBackground(answer2);
            }
            new Handler().postDelayed(() -> setUi(++indexQuestion), 200);
        });

        answer3.setOnClickListener(view -> {
            if (answer3.getText() == questionsList.get(indexQuestion).getRealAnswer()) {
                rightAnswers++;
                setRightAnswerBackground(answer3);
            } else {
                setErrorAnswerBackground(answer3);
            }
            new Handler().postDelayed(() -> setUi(++indexQuestion), 200);
        });

        answer4.setOnClickListener(view -> {
            if (answer4.getText() == questionsList.get(indexQuestion).getRealAnswer()) {
                rightAnswers++;
                setRightAnswerBackground(answer4);
            } else {
                setErrorAnswerBackground(answer4);
            }
            new Handler().postDelayed(() -> setUi(++indexQuestion), 200);

        });

    }

    private void initUI() {
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        imageView = findViewById(R.id.imageFlag);
        numQuestion = findViewById(R.id.numberQues);
    }

    @SuppressLint("SetTextI18n")
    private void setUi(int indexQuestion) {
        if (indexQuestion < numberQuestions) {
            numQuestion.setText((indexQuestion+1) + "/" + numberQuestions);
            setDefaultBackground(answer1);
            setDefaultBackground(answer2);
            setDefaultBackground(answer3);
            setDefaultBackground(answer4);
            Glide.with(this).load(questionsList.get(indexQuestion).getQuestion()).into(imageView);
            answer1.setText(questionsList.get(indexQuestion).getAnswer1());
            answer2.setText(questionsList.get(indexQuestion).getAnswer2());
            answer3.setText(questionsList.get(indexQuestion).getAnswer3());
            answer4.setText(questionsList.get(indexQuestion).getAnswer4());
        } else {
            startActivity(new Intent(MainActivity.this, ResultActivity.class));
            finish();
        }
    }

    private void setDefaultBackground(TextView textView) {
        textView.setBackgroundColor(getResources().getColor(R.color.white));
        textView.setTextColor(getResources().getColor(R.color.black));
    }

    private void loadQuestions() {
        //1
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/uzbekistan1991.png",
                "Tajikistan",
                "Uzbekistan",
                "Kyrgyzstan",
                "Kazakhstan",
                "Uzbekistan"));
        // 2
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/turkmenistan2001.png",
                "Turkmenistan",
                "Kazakhstan",
                "Karakalpakstan",
                "Uzbekistan",
                "Turkmenistan"));
        //3
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/afghanistan2004.png",
                "Uzbekistan",
                "Tajikistan",
                "Kyrgyzstan",
                "Afghanistan",
                "Afghanistan"));
        //4
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/nepal1962.png",
                "Sri Lanka",
                "Maldives",
                "Nepal",
                "Macau",
                "Nepal"));
        //5
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/india1947.png",
                "Pakistan",
                "India",
                "Kyrgyzstan",
                "Bhutan",
                "India"));
        //6
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/ethiopia1996a.png",
                "Nigeria",
                "Madagascar",
                "Ethiopia",
                "Angola",
                "Ethiopia"));
        //7
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/cameroon1975.png",
                "Lesotho",
                "Guinea",
                "Nigeria",
                "Cameroon",
                "Cameroon"));
        //8
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/ghana1957.png",
                "Ghana",
                "Gabon",
                "Cameroon",
                "Côte d'Ivoire",
                "Ghana"));
        //9
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/southafrica1994.png",
                "Togo",
                "Cameroon",
                "Botswana",
                "South Africa",
                "South Africa"));
        //10
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/turkey1844.png",
                "Turkey",
                "Yemen",
                "Sudan",
                "Lebanon",
                "Turkey"));
        //11
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/morocco1915.png",
                "Yemen",
                "Morocco",
                "Turkey",
                "Algeria",
                "Morocco"));
        //12
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/uae1971.png",
                "United Arab Emirates",
                "Kuwait",
                "Yemen",
                "Morocco",
                "United Arab Emirates"));
        //13
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/russia1705.png",
                "Czechia",
                "Monaco",
                "Moldova",
                "Russia",
                "Russia"));
        //14
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/croatia1990.png",
                "Slovenia",
                "Croatia",
                "Serbia",
                "Czechia",
                "Croatia"));
        //15
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/ukraine1918.png",
                "Russia",
                "Turkey",
                "Ukraine",
                "Lithuania",
                "Ukraine"));
        //16
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/azerbaijan1990.png",
                "Hungary",
                "Azerbaijan",
                "Bulgaria",
                "Belarus",
                "Azerbaijan"));
        //17
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/belarus2012.png",
                "Belarus",
                "Georgia",
                "Serbia",
                "Bulgaria",
                "Belarus"));
        //18
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/portugal1910.png",
                "Wales",
                "Portugal",
                "Liechtenstein",
                "Northern Ireland",
                "Portugal"));
        //19
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/southkorea1949.png",
                "Thailand",
                "Malaysia",
                "North Korea",
                "South Korea",
                "South Korea"));
        //20
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/australia1908.png",
                "New Zealand",
                "Fiji",
                "Australia",
                "Tonga",
                "Portugal"));
        //21
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/japan1999.png",
                "Japan",
                "Philippines",
                "China",
                "North Korea",
                "Japan"));
        //22
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/unitedstates1960.png",
                "Grenada",
                "Puerto Rico",
                "United States",
                "Canada",
                "United States"));
        //23
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/unitedkingdom1801.png",
                "Wales",
                "England",
                "United Kingdom",
                "Northern Ireland",
                "United Kingdom"));
        //24
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/norway1821.png",
                "Finland",
                "Denmark",
                "England",
                "Norway",
                "Norway"));
        //25
        questionsList.add(new QuestionModel(
                "https://flaglog.com/img/argentina1818.png",
                "Honduras",
                "Argentina",
                "Uruguay ",
                "Paraguay",
                "Argentina"));

    }

    private void setRightAnswerBackground(TextView textView) {
        textView.setBackgroundColor(getResources().getColor(R.color.lightgreena400));
        textView.setTextColor(getResources().getColor(R.color.white));
    }

    private void setErrorAnswerBackground(TextView textView) {
        textView.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_error));
        textView.setTextColor(getResources().getColor(R.color.white));
    }
}