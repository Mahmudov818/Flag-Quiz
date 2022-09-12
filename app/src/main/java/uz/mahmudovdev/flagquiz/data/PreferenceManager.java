package uz.mahmudovdev.flagquiz.data;

import android.content.Context;
import android.content.SharedPreferences;

import uz.mahmudovdev.flagquiz.utils.ConstantUtils;

public class PreferenceManager implements PreferenceSource {
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;


    @Override
    public void getInstance(Context context) {
        sharedPreferences = context.getSharedPreferences(ConstantUtils.PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void setNumberQuestions(int numberQuestions) {
        editor.putInt(ConstantUtils.PREF_NUMBER_QUESTIONS, numberQuestions).apply();
    }

    @Override
    public int getNumberQuestions() {
        return sharedPreferences.getInt(ConstantUtils.PREF_NUMBER_QUESTIONS, 0);
    }

}
