package com.example.android.belgiumquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Get the answers of every questions passed by the QuizActivity
        Bundle bundle = getIntent().getExtras();
        boolean answer_q_one = bundle.getBoolean("Answer 1");
        boolean answer_q_two = bundle.getBoolean("Answer 2");
        boolean answer_q_three = bundle.getBoolean("Answer 3");
        boolean answer_q_four = bundle.getBoolean("Answer 4");
        boolean answer_q_five = bundle.getBoolean("Answer 5");
        boolean answer_q_six = bundle.getBoolean("Answer 6");
        boolean answer_q_seven = bundle.getBoolean("Answer 7");
        boolean answer_q_eight = bundle.getBoolean("Answer 8");
        boolean answer_q_nine = bundle.getBoolean("Answer 9");
        boolean answer_q_ten = bundle.getBoolean("Answer 10");

        // Display the player answer with the explanation text
        displayAnswer(answer_q_one, R.id.answer_q_one, R.string.answer_q_one);
        displayAnswer(answer_q_two, R.id.answer_q_two, R.string.answer_q_two);
        displayAnswer(answer_q_three, R.id.answer_q_three, R.string.answer_q_three);
        displayAnswer(answer_q_four, R.id.answer_q_four, R.string.answer_q_four);
        displayAnswer(answer_q_five, R.id.answer_q_five, R.string.answer_q_five);
        displayAnswer(answer_q_six, R.id.answer_q_six, R.string.answer_q_six);
        displayAnswer(answer_q_seven, R.id.answer_q_seven, R.string.answer_q_seven);
        displayAnswer(answer_q_eight, R.id.answer_q_eight, R.string.answer_q_eight);
        displayAnswer(answer_q_nine, R.id.answer_q_nine, R.string.answer_q_nine);
        displayAnswer(answer_q_ten, R.id.answer_q_ten, R.string.answer_q_ten);
    }

    /**
     * Display if the player answer correctly or not to the question
     * @param answer the input answer passed by the QuizActivity
     * @param viewId the id of the explanation TextView
     * @param explanationId the id of the string resource for the explanation text
     */
    private void displayAnswer(boolean answer, int viewId, int explanationId) {
        TextView answerTextView = (TextView) findViewById(viewId);
        if (answer){
            answerTextView.setText("Your answer was correct." + "\n" + getString(explanationId));
        } else {
            answerTextView.setText("Your answer was incorrect." + "\n" + getString(explanationId));
        }
    }

    // Simple intent to reboot the quiz
    // As it will call a new MainActivity, no need to reset any variable of the QuizActivity
    public void retry (View view){
        Intent mainActivity = new Intent(ResultsActivity.this, com.example.android.belgiumquiz.MainActivity.class);
        if (mainActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(mainActivity);
        }
    }
}
