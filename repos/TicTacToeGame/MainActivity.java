package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0 = yellow
     int activeplayer = 0;
     int [] gamestate= {2,2,2,2,2,2,2,2,2};
     int [][] winnigposition = {{0,1,2},{3,4,5,},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
     public void dropin(View view ) {
         ImageView counter = (ImageView) view;
         int tagged = Integer.parseInt(counter.getTag().toString());
         if (gamestate[tagged] == 2) {
             gamestate[tagged] = activeplayer;

             counter.setTranslationY(-1000f);
             if (activeplayer == 0) {
                 counter.setImageResource(R.drawable.yellow);
                 activeplayer = 1;
             } else {
                 counter.setImageResource(R.drawable.red);
                 activeplayer = 0;
             }
             counter.animate().translationYBy(1000f).rotationBy(3600).setDuration(300);
                  for(int val : gamestate)
              System.out.println(val);
          for(int[] win : winnigposition){
              if(gamestate[win[0]]==gamestate[win[1]]&&gamestate[win[1]]==gamestate[win[2]]&&gamestate[win[0]]!=2){
                  TextView message = (TextView)findViewById(R.id.winmessage);
                  if( activeplayer ==1)
                  message.setText("Yellow has won!");
                  else
                      message.setText("Red has won!");
                  LinearLayout layout = (LinearLayout)findViewById(R.id.playagain);
                  layout.setVisibility(view.VISIBLE);


              }
          }
         }
     }

public void playagain(View view){
    LinearLayout layout = (LinearLayout)findViewById(R.id.playagain);
    layout.setVisibility(view.INVISIBLE);
     activeplayer = 0;
     for(int i= 0; i<9 ;i++)
     gamestate[i]=2;
     GridLayout grid = (GridLayout)findViewById(R.id.grid);


        ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setImageResource(0);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setImageResource(0);
        ImageView img3 = (ImageView) findViewById(R.id.img3);
        img3.setImageResource(0);
        ImageView img4 = (ImageView) findViewById(R.id.img4);
        img4.setImageResource(0);
        ImageView img5 = (ImageView) findViewById(R.id.img5);
        img5.setImageResource(0);
        ImageView img6 = (ImageView) findViewById(R.id.img6);
        img6.setImageResource(0);
        ImageView img7 = (ImageView) findViewById(R.id.img7);
        img7.setImageResource(0);
        ImageView img8 = (ImageView) findViewById(R.id.img8);
        img8.setImageResource(0);
    ImageView img9 = (ImageView) findViewById(R.id.img9);
    img9.setImageResource(0);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
