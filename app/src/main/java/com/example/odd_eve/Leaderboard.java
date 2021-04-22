package com.example.odd_eve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Leaderboard extends AppCompatActivity {
    long mScore;
    TextView mLeader;

    public Leaderboard(int score) {
        mScore=score;
    }
    void printScore(View view) throws IOException
    {
        FileOutputStream fos= new FileOutputStream("Leaderboard.txt");
        byte b[]=(Long.toString(mScore)+".").getBytes();
        fos.write(b);
    }
    void displayScores(View view) throws IOException {
        mLeader= findViewById(R.id.leader);
        FileInputStream fis=openFileInput("Leaderboard.txt");
        BufferedReader bf=new BufferedReader(new InputStreamReader(fis));
        mLeader.setText(bf.readLine());
    }
}
