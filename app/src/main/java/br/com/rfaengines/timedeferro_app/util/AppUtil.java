package br.com.rfaengines.timedeferro_app.util;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public class AppUtil extends AppCompatActivity {

    public String getRes(@StringRes int id){
        String strRes = getResources().getString(id);
        return strRes;
    }

}
