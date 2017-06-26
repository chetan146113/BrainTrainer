package com.example.chetan.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class secondactivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1,t2,t3,t4,t5,t6,t7;
    int correctlocation;
    int incorrectresult;
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        t1= (TextView) findViewById(R.id.textView5);
        t2= (TextView) findViewById(R.id.textView6);
        t3= (TextView) findViewById(R.id.textView7);
        t4= (TextView) findViewById(R.id.textView1);
        t5= (TextView) findViewById(R.id.textView2);
        t6= (TextView) findViewById(R.id.textView3);
        t7= (TextView) findViewById(R.id.textView4);

         Result();

    }

    public int randomNumber(int n)
    {

          return (int) (Math.random()*n+1);
    }

    public void Result()
    {
        arrayList.clear();
        int first= randomNumber(20);
        int second=randomNumber(20);
        int operator=randomNumber(3);
        correctlocation= randomNumber(4);
        t1.setText(""+first);
        t3.setText(""+second);
        Toast.makeText(this,""+operator,Toast.LENGTH_SHORT).show();

        switch (operator)

        {
            case 1:
                t2.setText("+");
                for (int i = 1; i < 5; i++) {
                    if (correctlocation == i) {
                        arrayList.add(first + second);
                    } else {
                        incorrectresult = randomNumber(80);
                        while (incorrectresult == (first + second)) {
                            incorrectresult = randomNumber(80);
                        }

                        arrayList.add(incorrectresult);
                    }

                }
                break;

            case 2:
                t2.setText("-");
                for (int i = 1; i < 5; i++) {
                    if (correctlocation == i) {
                        arrayList.add(first - second);
                    } else {
                        incorrectresult = randomNumber(80);
                        while (incorrectresult == (first - second)) {
                            incorrectresult = randomNumber(80);
                        }

                        arrayList.add(incorrectresult);
                    }

                }

                break;
            case 3:
                t2.setText("*");
                for (int i = 1; i < 5; i++) {
                    if (correctlocation == i) {
                        arrayList.add(first * second);
                    } else {
                        incorrectresult = randomNumber(20);
                        while (incorrectresult == (first * second)) {
                            incorrectresult = randomNumber(20);
                        }

                        arrayList.add(incorrectresult);
                    }

                }

                break;
            case 4:
                Toast.makeText(secondactivity.this, "/", Toast.LENGTH_SHORT).show();
                break;

        }


        t4.setText(String.valueOf(arrayList.get(0)));
        t5.setText(String.valueOf(arrayList.get(1)));
        t6.setText(String.valueOf(arrayList.get(2)));
        t7.setText(String.valueOf(arrayList.get(3)));

        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
           if(Integer.parseInt(v.getTag().toString())==correctlocation)
           {
               Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
           }

           else
               if(Integer.parseInt(v.getTag().toString())!=correctlocation){
               Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
           }
Result();
    }
}
