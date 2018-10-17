package com.android.revan.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Bundle arguments = getIntent().getExtras();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Здравствуйте " + arguments.get("myText").toString() + " Вы хотите продолжать использовать приложение?");
        Button acceptButton = (Button) findViewById(R.id.yes);
        Button declinedButton = (Button) findViewById(R.id.no);

        acceptButton.setOnClickListener(onClickListener);
        declinedButton.setOnClickListener(onClickListener);
    }
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.yes:
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                    break;
                case R.id.no:
                    System.exit(0);
                    break;
            }
        }
    };
}
