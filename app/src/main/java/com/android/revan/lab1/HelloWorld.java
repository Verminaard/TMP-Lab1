package com.android.revan.lab1;

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.android.revan.lab1.R;

public class HelloWorld extends Activity {
    EditText editText;
    Integer firstValue;
    Integer secondValue;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        editText = (EditText)findViewById(R.id.editText1);
    }
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }*/

    public void buttonClick(View view){
        Button button = (Button) view;
        switch (button.getText().toString()) {
            case "C":
                firstValue = null;
                secondValue = null;
                operation = null;
                editText.setText("");
                break;
            case "<-":
                int length = editText.length();
                if (operation == null)
                {
                    if (length > 0) {
                        editText.setText(editText.getText().subSequence(0, length - 1));
                    }
                }
                else
                {
                    if(secondValue != null) {
                        secondValue = secondValue / 10;
                        editText.setText(editText.getText().subSequence(0, length - 1));
                    }
                    else {
                        operation = null;
                        editText.setText(editText.getText().subSequence(0, length - 1));
                    }
                }
                break;
            case "+":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="+";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "-":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="-";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "*":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="*";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "/":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="/";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "=":
                switch (operation) {
                    case "+":
                        editText.setText(String.valueOf((firstValue+secondValue)));
                        break;
                    case "-":
                        editText.setText(String.valueOf((firstValue-secondValue)));
                        break;
                    case "*":
                        editText.setText(String.valueOf((firstValue*secondValue)));
                        break;
                    case "/":
                        if (secondValue != 0) {
                            editText.setText(String.valueOf((firstValue / secondValue)));
                        } else {
                            editText.setText("");
                        }
                        break;
                    default:
                        break;
                }
                firstValue = null;
                secondValue = null;
                operation = null;
                break;
            default:
                if(operation != null){
                    if(secondValue!=null)
                        secondValue =
                                Integer.valueOf((String.valueOf(secondValue)+button.getText().toString()));
                    else
                        secondValue =
                                Integer.valueOf(button.getText().toString());
                }
        editText.setText(editText.getText().toString()+button.getText());
        break;
        }
    }
}

