package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private QuizBank mQuestionLibrary = new QuizBank();
    private TextView mScoreView;   // Untuk menampilkan skor saat ini
    private TextView mQuestionView;  //menampilkan jawaban
    private Button mButtonChoice1; // jawaban 1
    private Button mButtonChoice2; // jawaban 2
    private Button mButtonChoice3; //jawaban 3
    private Button mButtonChoice4; //jawaban 4
    private Button mAbout;
    private AlertDialog.Builder alertDialog;
    private String mAnswer;  // untuk cek jawaban benar atau tidaknya
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents(); //untuk inisialisasi komponen
        updateQuestion(); //untuk update pertanyaan
        updateScore(mScore); //untuk update skor

    }
    //UNTUK HANDLE KLIK JAWABAN
    public void onClick(View view) {
        Button answer =(Button) view;
        //JIKA JAWABAN BENAR
        if (answer.getText() == mAnswer){
            mScore = mScore + 1;
            Toast.makeText(MainActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
        }else //JIKA JAWABAN SALAH
            Toast.makeText(MainActivity.this, "Salah!", Toast.LENGTH_SHORT).show();
        //PANGGIL
        updateScore(mScore);
        updateQuestion();
    }

    //UNTUK UPDATE SKOR
    private void updateScore(int point) {
        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength());
    }
    //METHOD UPDATE QUESTION
    private void updateQuestion() {
        if (mQuestionNumber<mQuestionLibrary.getLength()){
                mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
                mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
                mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
                mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
                mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
                mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
                mQuestionNumber++;
        }else {
                Toast.makeText(MainActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("score", mScore); // pass the current score to the second screen
                startActivity(intent);
        }
    }

    //method untuk init componen
    private void initComponents() {
        mScoreView = findViewById(R.id.tv_score);
        mQuestionView = findViewById(R.id.tv_question);

        mButtonChoice1 = findViewById(R.id.btn_answer1);
        mButtonChoice2 = findViewById(R.id.btn_answer2);
        mButtonChoice3 = findViewById(R.id.btn_answer3);
        mButtonChoice4 = findViewById(R.id.btn_answer4);
    }
}
