package jpa.utils.jhy.sohyun2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class LetterActivity extends Activity {

    ScrollView letter;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);

        letter = (ScrollView)findViewById(R.id.LETTER);
        text = (TextView)findViewById(R.id.TEXT);
        text.setText(getIntent().getStringExtra("msg"));
        letter.setY(2500);
    }

    @Override
    protected void onResume() {
        super.onResume();
        letter.animate().translationY(0).setDuration(500);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,0);
    }
}
