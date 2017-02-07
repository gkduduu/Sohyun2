package jpa.utils.jhy.sohyun2.utils;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by hayoung on 2017. 2. 6..
 * gkduduu@naver.com
 * 공통메소드
 */

public class ToolBox {


    //파이어베이스(구글)로그아웃
    public static void logout(Context con) {
        SPManager.setString(con,SH.SP_LOGIN_ID,"");
        FirebaseAuth.getInstance().signOut();
    }

    //이름 null체크
    public static String nameNvl(String target) {
        if(null == target || target.equals("")) {
            return "사용자";
        }
        return target;
    }
}
