package com.example.android.belgiumquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view){
        Intent quizActivity = new Intent(MainActivity.this, com.example.android.belgiumquiz.QuizActivity.class);
        if (quizActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(quizActivity);
        }
    }
}
