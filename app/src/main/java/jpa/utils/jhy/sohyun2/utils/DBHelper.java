package jpa.utils.jhy.sohyun2.utils;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import jpa.utils.jhy.sohyun2.SecondActivity;
import jpa.utils.jhy.sohyun2.data.DataForUser;


/**
 * Created by hayoung on 2017. 2. 6..
 * gkduduu@naver.com
 * firebase realtime db기반
 */
public class DBHelper {

    private static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private static DatabaseReference databaseReference = firebaseDatabase.getReference();

    //해당 id가 등록 되었는지 여부 파악
    public static void isExistUserId(String id) {
        Query query = databaseReference.child("user").orderByChild("id").equalTo(id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    ((SecondActivity)SecondActivity.context).initView(true);
                }else {
                    ((SecondActivity)SecondActivity.context).initView(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("jhy","에러");
            }
        });
    }

    public static void insertUserInfo (String id) {
        DataForUser data = new DataForUser(id,"");
        databaseReference.push().child("user").setValue(data);
    }
}
