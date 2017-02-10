package com.example.a.a23_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView selectedTextView, workingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedTextView = (TextView) findViewById(R.id.selectedTextView);
        workingTextView = (TextView) findViewById(R.id.workingTextView);


        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                String working = workingTextView.getText().toString();
                String text = btn.getText().toString();
                if(working.equals("0")){
                    workingTextView.setText(text);
                }else{
                    workingTextView.append(text);
                }
            }
        };

        TableLayout tableLayout = (TableLayout) findViewById(R.id.activity_main);
        int num = 1;
        for(int i=2; i<tableLayout.getChildCount()-1; i++){
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            for(int k=0; k<tableRow.getChildCount(); k++){
                Button button = (Button) tableRow.getChildAt(k);
                button.setText(""+num);
                button.setOnClickListener(numberListener);
                num += 1;
            }
        }

//        enterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String value = workingTextView.getText().toString();
//                selectedTextView.setText(value);
//                workingTextView.setText("0");
//            }
//        });

    }
}









