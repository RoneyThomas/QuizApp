package me.roney.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup quiz1 = (RadioGroup) findViewById(R.id.quiz_1);
                CheckBox quiz2A = (CheckBox) findViewById(R.id.quiz_2_a_choice);
                CheckBox quiz2B = (CheckBox) findViewById(R.id.quiz_2_b_choice);
                CheckBox quiz2C = (CheckBox) findViewById(R.id.quiz_2_c_choice);
                RadioGroup quiz3 = (RadioGroup) findViewById(R.id.quiz_3);
                CheckBox quiz4A = (CheckBox) findViewById(R.id.quiz_4_a_choice);
                CheckBox quiz4B = (CheckBox) findViewById(R.id.quiz_4_b_choice);
                CheckBox quiz4C = (CheckBox) findViewById(R.id.quiz_4_c_choice);
                CheckBox quiz4D = (CheckBox) findViewById(R.id.quiz_4_d_choice);
                EditText quiz5 = (EditText) findViewById(R.id.quiz_5_edit_text);

                int score = 0;

                int quiz1Choice = quiz1.getCheckedRadioButtonId();
                boolean quiz2AChoice = quiz2A.isChecked();
                boolean quiz2BChoice = quiz2B.isChecked();
                boolean quiz2CChoice = quiz2C.isChecked();
                int quiz3Choice = quiz3.getCheckedRadioButtonId();
                boolean quiz4AChoice = quiz4A.isChecked();
                boolean quiz4BChoice = quiz4B.isChecked();
                boolean quiz4CChoice = quiz4C.isChecked();
                boolean quiz4DChoice = quiz4D.isChecked();
                String quiz5Choice = quiz5.getText().toString().trim().toLowerCase();

                if (quiz1Choice == R.id.quiz_1_a_choice) {
                    score++;
                }
                if (quiz2AChoice == true && quiz2BChoice == true && quiz2CChoice == false) {
                    score++;
                }
                if (quiz3Choice == R.id.quiz_3_b_choice) {
                    score++;
                }
                if (quiz4AChoice == true && quiz4BChoice == true && quiz4CChoice == true && quiz4DChoice == false) {
                    score++;
                }

                if (quiz5Choice.equals(getString(R.string.quiz_5_ans))) {
                    score++;
                }
                if (score > 0) {
                    Toast.makeText(MainActivity.this, getString(R.string.positive_feedback, score), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.negative_feedback), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
