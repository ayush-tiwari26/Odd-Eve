package com.example.odd_eve;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score=0;
    public void showScore(boolean flag)
    {
        TextView txt = findViewById(R.id.status);
        txt.setTextColor(Color.parseColor("#FF000000"));
        if (flag)
            txt.setText("Your Total Score : "+score);
        else {
            txt.setTextColor(Color.parseColor("#EA1313"));
            txt.setText("OUT !! Your Total Score : " + score);
            //Leaderboard ob=new Leaderboard(score);
            score=0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playerTapped(View view) {
        int run=Integer.parseInt(view.getTag().toString()); // Getting the score user selected
        Log.d("User Selected+run","");
        Random rand=new Random();
        int random=7;
        while(random==7 || random==8 || random==9){
            random=rand.nextInt(10)+1;
        }  // Generted a random score in last 4 lines

        // Now time to display the selected and randomized scores
        ImageView imgUser=(ImageView)findViewById(R.id.img_user_move);

        switch(run) //User score displayed
        {
            case 0:{ imgUser.setImageResource(R.drawable.dot);
            break;}
            case 1:{ imgUser.setImageResource(R.drawable.one);
                break;}
            case 2:{ imgUser.setImageResource(R.drawable.two);
                break;}
            case 3:{ imgUser.setImageResource(R.drawable.three);
                break;}
            case 4:{ imgUser.setImageResource(R.drawable.four);
                break;}
            case 5:{ imgUser.setImageResource(R.drawable.five);
                break;}
            case 6:{ imgUser.setImageResource(R.drawable.six);
                break;}
            case 10:{ imgUser.setImageResource(R.drawable.ten);
                break;}
        }

        imgUser=(ImageView)findViewById(R.id.img_computer_move);

        switch(random) //Random score displayed
        {
            case 0:{ imgUser.setImageResource(R.drawable.dot);
                break;}
            case 1:{ imgUser.setImageResource(R.drawable.one);
                break;}
            case 2:{ imgUser.setImageResource(R.drawable.two);
                break;}
            case 3:{ imgUser.setImageResource(R.drawable.three);
                break;}
            case 4:{ imgUser.setImageResource(R.drawable.four);
                break;}
            case 5:{ imgUser.setImageResource(R.drawable.five);
                break;}
            case 6:{ imgUser.setImageResource(R.drawable.six);
                break;}
            case 10:{ imgUser.setImageResource(R.drawable.ten);
                break;}
        }

        if (run!=random)
        {
            score=score+run;
            showScore(true);
        }
        else
        {
            showScore(false);
        }
    }
}