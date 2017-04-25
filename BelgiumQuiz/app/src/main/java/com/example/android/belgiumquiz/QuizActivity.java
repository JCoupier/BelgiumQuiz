package com.example.android.belgiumquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    int score = 0;
    boolean isCorrect_q_one = false;
    boolean isCorrect_q_two = false;
    String statueName = "Statue";
    boolean isCorrect_q_three = false;
    boolean checked_french_q_four = false;
    boolean checked_dutch_q_four = false;
    boolean checked_german_q_four = false;
    boolean checked_english_q_four = false;
    boolean checked_italian_q_four = false;
    boolean checked_spanish_q_four = false;
    boolean isCorrect_q_four = false;
    String junkFoodName = "Junk Food";
    boolean isCorrect_q_five = false;
    int quantity = 1;
    String numberOfTrappistBeer = "1";
    boolean isCorrect_q_six = false;
    boolean checked_albert_two_q_seven = false;
    boolean checked_baudouin_q_seven = false;
    boolean checked_leopold_first_q_seven = false;
    boolean checked_philippe_q_seven = false;
    boolean checked_elisabeth_q_seven = false;
    boolean checked_leopold_third_q_seven = false;
    boolean isCorrect_q_seven = false;
    boolean isCorrect_q_eight = false;
    boolean isCorrect_q_nine = false;
    boolean checked_marilyn_monroe_q_ten = false;
    boolean checked_audrey_hepburn_q_ten = false;
    boolean checked_judy_garland_q_ten = false;
    boolean checked_jully_andrews_q_ten = false;
    boolean isCorrect_q_ten = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void onRadioButtonClicked(View view) {
        // Find id of the correct answer for question one
        // Is the correct button for question one now checked?
        isCorrect_q_one = ((RadioButton) findViewById(R.id.radio_belgium_flag)).isChecked();

        // Find id of the correct answer for question two
        // Is the correct button for question two now checked?
        isCorrect_q_two = ((RadioButton) findViewById(R.id.radio_atomium)).isChecked();

        // Find id of the correct answer for question eight
        // Is the correct button for the question eight now checked?
        isCorrect_q_eight = ((RadioButton) findViewById(R.id.radio_1830)).isChecked();

        // Find id of the correct answer for question nine
        // Is the correct button for the question nine now checked?
        isCorrect_q_nine = ((RadioButton) findViewById(R.id.radio_south_north)).isChecked();
    }

    public void onCheckBoxClicked (View view) {
        // Find id of the correct answer checkboxes in question four
        // Is the correct checkboxes for the question four now checked?
        checked_french_q_four = ((CheckBox) findViewById(R.id.checkbox_french)).isChecked();
        checked_dutch_q_four = ((CheckBox) findViewById(R.id.checkbox_dutch)).isChecked();
        checked_german_q_four = ((CheckBox) findViewById(R.id.checkbox_german)).isChecked();
        checked_english_q_four = ((CheckBox) findViewById(R.id.checkbox_english)).isChecked();
        checked_italian_q_four = ((CheckBox) findViewById(R.id.checkbox_italian)).isChecked();
        checked_spanish_q_four = ((CheckBox) findViewById(R.id.checkbox_spanish)).isChecked();
        // Is the answer correct?
        if (checked_french_q_four && checked_dutch_q_four && checked_german_q_four && !checked_english_q_four && !checked_italian_q_four && !checked_spanish_q_four) {
            isCorrect_q_four = true;
        } else {
            isCorrect_q_four = false;
        }

        // Find id of the correct answer checkboxes in question seven
        // Is the correct checkboxes for the question seven now checked?
        checked_albert_two_q_seven = ((CheckBox) findViewById(R.id.checkbox_albert_two)).isChecked();
        checked_baudouin_q_seven = ((CheckBox) findViewById(R.id.checkbox_baudoin)).isChecked();
        checked_leopold_first_q_seven = ((CheckBox) findViewById(R.id.checkbox_leopold_first)).isChecked();
        checked_philippe_q_seven = ((CheckBox) findViewById(R.id.checkbox_philippe)).isChecked();
        checked_elisabeth_q_seven = ((CheckBox) findViewById(R.id.checkbox_elisabeth)).isChecked();
        checked_leopold_third_q_seven = ((CheckBox) findViewById(R.id.checkbox_leopold_third)).isChecked();
        // Is the answer correct?
        if (checked_elisabeth_q_seven && !checked_albert_two_q_seven && !checked_baudouin_q_seven && !checked_leopold_first_q_seven && !checked_philippe_q_seven && !checked_leopold_third_q_seven) {
            isCorrect_q_seven = true;
        } else {
            isCorrect_q_seven = false;
        }

        // Find id of the correct answer checkboxes in question ten
        // Is the correct checkboxes for the question ten now checked?
        checked_marilyn_monroe_q_ten = ((CheckBox) findViewById(R.id.checkbox_marilyn_monroe)).isChecked();
        checked_audrey_hepburn_q_ten = ((CheckBox) findViewById(R.id.checkbox_audrey_hepburn)).isChecked();
        checked_judy_garland_q_ten = ((CheckBox) findViewById(R.id.checkbox_judy_garland)).isChecked();
        checked_jully_andrews_q_ten = ((CheckBox) findViewById(R.id.checkbox_jully_andrews)).isChecked();
        if (checked_audrey_hepburn_q_ten && !checked_marilyn_monroe_q_ten && !checked_judy_garland_q_ten && !checked_jully_andrews_q_ten) {
            isCorrect_q_ten = true;
        } else {
            isCorrect_q_ten = false;
        }
    }

    public void increment(View view) {
        if (quantity == 11){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 11 Trappist beer", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 Trappist beer", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void submitClicked (View view) {
        // Retrieve the string text of the question three and store it
        statueName = ((TextView) findViewById(R.id.question_three_answer)).getText().toString();
        // Retrieve the string text of the question five and store it
        junkFoodName = ((TextView) findViewById(R.id.question_five_answer)).getText().toString();
        // Retrieve the string text (number) of the question six and store it
        numberOfTrappistBeer = ((TextView) findViewById(R.id.quantity_text_view)).getText().toString();

        if (isCorrect_q_one){
            score += 1;
        }
        if (isCorrect_q_two){
            score += 1;
        }
        if (statueName.equals("Manneken Pis")){
            isCorrect_q_three = true;
            score += 1;
        }
        if (isCorrect_q_four){
            score += 1;
        }
        if (junkFoodName.equals("French Fries")){
            isCorrect_q_five = true;
            score += 1;
        }
        if (numberOfTrappistBeer.equals("6")){
            isCorrect_q_six = true;
            score += 1;
        }
        if (isCorrect_q_seven){
            score += 1;
        }
        if (isCorrect_q_eight){
            score += 1;
        }
        if (isCorrect_q_nine){
            score += 1;
        }
        if (isCorrect_q_ten){
            score += 1;
        }

        // Make the toast to display the score of the player
        Toast.makeText(this, "You get " + score + " points!", Toast.LENGTH_LONG).show();

        // Pass answers of questions to the ResultsActivity
        Intent resultsActivity = new Intent(QuizActivity.this, com.example.android.belgiumquiz.ResultsActivity.class);
        resultsActivity.putExtra("Answer 1", isCorrect_q_one);
        resultsActivity.putExtra("Answer 2", isCorrect_q_two);
        resultsActivity.putExtra("Answer 3", isCorrect_q_three);
        resultsActivity.putExtra("Answer 4", isCorrect_q_four);
        resultsActivity.putExtra("Answer 5", isCorrect_q_five);
        resultsActivity.putExtra("Answer 6", isCorrect_q_six);
        resultsActivity.putExtra("Answer 7", isCorrect_q_seven);
        resultsActivity.putExtra("Answer 8", isCorrect_q_eight);
        resultsActivity.putExtra("Answer 9", isCorrect_q_nine);
        resultsActivity.putExtra("Answer 10", isCorrect_q_ten);
        if (resultsActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(resultsActivity);
        }
    }
}
