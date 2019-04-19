package com.example.braingame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



     int n1 ;
    int n2 ;
    int correct =0;
    int tnq=0;
     Boolean change = true ;
     public void ans(View view) throws InterruptedException {
        Button b =(Button)view;
        String s = b.getText().toString();
         if(Integer.parseInt(s) == n1+n2){
             TextView score = findViewById(R.id.score);
             correct++;
             tnq++;
             String scre = correct+"/"+tnq;
             score.setText(scre);
             Toast.makeText(getApplicationContext() , "Correct!",Toast.LENGTH_LONG).show();


         }else{
             TextView score = findViewById(R.id.score);

             tnq++;
             String scre = correct+"/"+tnq;
             score.setText(scre);
             Toast.makeText(getApplicationContext() , "Incorrect!",Toast.LENGTH_LONG).show();

         }
     change=true;
     }
    public void go(View view){
        RelativeLayout relativeLayout = findViewById(R.id.relativelayout);
        relativeLayout.setVisibility(View.VISIBLE);
        Button bgo  = findViewById(R.id.bgo);
        bgo.setEnabled(false);
         start();
    }
    public void updateNumber(){
        int max =50;
        int min = 1;

        Random rn = new Random();
         int i = rn.nextInt()%50;
         if(i<0){
             i=-1*i;
         }
         n1 = min+i;
         i = rn.nextInt()%50;
        if(i<0){
            i=-1*i;
        }
        n2 = min+i;

    }
    public int getr(int max){

        int min = 1;
        int n = max-min+1;
        Random rn = new Random();
        int i = rn.nextInt()%n;
        int n3 = min+i;
        if(n3<0)
            n3=n3*-1;
        return n3;
     }
    public void updateView(){
        TextView q = findViewById(R.id.ques);
        String str = n1 +" + "+n2;
        q.setText(str);
         int count =1;
         int i = getr(4);
         Log.i("hooo0000000000ooo",Integer.toString(i));
         String ss ="";

         Button b1 = findViewById(R.id.b1);
        if(count==i){
          int aa=n1+n2;
          ss+=aa;
        }else{
            ss+=""+getr(100);
        }
        b1.setText(ss);
        count++;
        ss="";
        Button b2 = findViewById(R.id.b2);
        if(count==i){
            int aa=n1+n2;
            ss+=aa;
        }else{
            ss+=""+getr(100);
        }
        b2.setText(ss);
        count++;
        ss="";
        Button b3 = findViewById(R.id.b3);
        if(count==i){
            int aa=n1+n2;
            ss+=aa;
        }else{
            ss+=""+getr(100);
        }
        b3.setText(ss);
        count++;
        ss="";
        Button b4 = findViewById(R.id.b4);
        if(count==i){
            int aa=n1+n2;
            ss+=aa;
        }else{
            ss+=""+getr(100);
        }
        b4.setText(ss);

    }

    public void start(){
             new CountDownTimer(30000+100 , 1000){

                 @Override
                 public void onTick(long millisUntilFinished) {
                     TextView time = (TextView) findViewById(R.id.time);
                     time.setText(Integer.toString((int)millisUntilFinished/1000)+"s");
                     if(change){

                            updateNumber();
                            updateView();
                            change = false;

                     }
                 }

                 @Override
                 public void onFinish() {
                   change=false;
                   tnq=0;
                   correct=0;
                   n1=0;
                   n2=0;
                   updateView();

                     RelativeLayout relativeLayout = findViewById(R.id.relativelayout);
                     relativeLayout.setVisibility(View.INVISIBLE);
                     Button go = findViewById(R.id.bgo);
                     go.setVisibility(View.VISIBLE);
                     go.setEnabled(true);
                 }
             }.start();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = findViewById(R.id.relativelayout);
       relativeLayout.setVisibility(View.INVISIBLE);
    }

}
