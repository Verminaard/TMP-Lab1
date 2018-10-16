package com.android.revan.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (EditText) findViewById(R.id.inputText);
        Button myButton = (Button) findViewById(R.id.confrimButton);

        myButton.setOnClickListener(onClickListener);
        myText.setOnClickListener(onClickListener);
    }

private final View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confrimButton:
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                String myString = myText.getText().toString();
                intent.putExtra("myText", myString);
                startActivity(intent);
                break;
        }

    }
};

}
