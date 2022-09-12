package uz.mahmudovdev.flagquiz.data;

import android.content.Context;

public interface PreferenceSource {
    void getInstance(Context context);

    void setNumberQuestions(int numberQuestions);

    int getNumberQuestions();
}
