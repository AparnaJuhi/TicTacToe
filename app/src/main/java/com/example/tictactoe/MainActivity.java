package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    //0-O
    //1-x
    int activePlayer=0;

    //contains nine elements to represent all the nine cells
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //2- NULL

    boolean gameActive=true;
    int[][] win_pos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    TextView stat;

    public void gameReset()
    {
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        gameActive=true;
        stat.setText("O turn");
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);


    }
    public void tap(View view){
        if(!gameActive)
        {
            gameReset();
        }
        else
        {
            ImageView img=(ImageView) view;
            //get the tag in the int format
            int tappedImage=Integer.parseInt(img.getTag().toString());

            if(gameState[tappedImage]==2)
            {
                //img.setTranslationY(-1000f);
                gameState[tappedImage]=activePlayer;

                if(activePlayer==0)
                {
                    img.setImageResource(R.drawable.o);
                    stat.setText("X turn");
                    activePlayer=1;

                }
                else
                {
                    img.setImageResource(R.drawable.x);
                    stat.setText("O turn");
                    activePlayer=0;
                }

                //Translate Y back to its original pos
                //img.animate().translationYBy(1000f).setDuration(300);
            }

            for(int[] winningPos: win_pos)
            {
                if(gameState[winningPos[0]]!=2) {
                    if (gameState[winningPos[0]] == gameState[winningPos[1]] && gameState[winningPos[1]] == gameState[winningPos[2]]) {
                        if (gameState[winningPos[0]] == 0) {
                            stat.setText("O won");
                            Toast.makeText(this, "O won ", Toast.LENGTH_SHORT).show();
                        } else {
                            stat.setText("X won");
                            Toast.makeText(this, "X won ", Toast.LENGTH_SHORT).show();
                        }
                        gameActive = false;

                    }
                }
            }





        }









    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stat=findViewById(R.id.status);
    }
}