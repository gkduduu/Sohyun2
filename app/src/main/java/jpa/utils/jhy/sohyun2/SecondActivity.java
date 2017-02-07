package jpa.utils.jhy.sohyun2;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import jpa.utils.jhy.sohyun2.utils.DBHelper;
import jpa.utils.jhy.sohyun2.utils.SH;
import jpa.utils.jhy.sohyun2.utils.SPManager;

@EActivity(R.layout.activity_second)
public class SecondActivity extends Activity {

    public static Context context;

    @ViewById
    TextView SEC_TV_EXIST;

    @AfterViews
    void onFirst() {
        context = this;
        DBHelper.isExistUserId(SPManager.getString(this, SH.SP_LOGIN_ID));
    }

    public void initView(boolean isExist) {
        if(isExist) {
            //계정 존재
            SEC_TV_EXIST.setText("기존 사용자 : " + SPManager.getString(this,SH.SP_USER_NAME) + "님");
        }else {
            //계정 존재하지않음
            SEC_TV_EXIST.setText("처음 사용자 : " + SPManager.getString(this,SH.SP_USER_NAME) + "님");
            DBHelper.insertUserInfo(SPManager.getString(this,SH.SP_LOGIN_ID));
        }
    }

}
