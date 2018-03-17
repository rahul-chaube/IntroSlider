package escan.com.introslider;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Android7 on 3/17/2018.
 */

public class PrefManager {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    // shared Preferenced mode

    int PRIVATE_MODE=0;

    private static final String PREF_NAME="IntroSlider";
    private static final String IS_FIRST_TIME_LAUNCH="IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this.context = context;
        preferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=preferences.edit();
    }
    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,isFirstTime);
        editor.commit();
    }
    public boolean isFirstTimeLaunch()
    {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH,true);
    }
}