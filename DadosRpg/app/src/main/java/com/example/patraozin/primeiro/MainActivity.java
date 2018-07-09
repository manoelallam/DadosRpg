package com.example.patraozin.primeiro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button d100;
    Button d20;
    Button d12;
    Button d10;
    Button d8;
    Button d6;
    Button d4;
    Button dn;
    Button digt7;
    Button digt6;
    Button digt5;
    Button digt4;
    Button digt3;
    Button digt2;
    Button digt1;
    Button digt0;
    Button digtNeg;
    Button digtPlus;
    Button btClr;
    Button btRoll;
    Button btFav;
    TextView rollDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d100 = (Button) findViewById(R.id.d100);
        d20 = (Button) findViewById(R.id.d20);
        d12 = (Button) findViewById(R.id.d12);
        d10 = (Button) findViewById(R.id.d10);
        d8 = (Button) findViewById(R.id.d8);
        d6 = (Button) findViewById(R.id.d6);
        d4 = (Button) findViewById(R.id.d4);
        dn = (Button) findViewById(R.id.dn);
        rollDisplay = (TextView) findViewById(R.id.rollDisplay);
        btClr = (Button) findViewById(R.id.btClr);
        btRoll = (Button) findViewById(R.id.btRoll) ;


        d100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d100.getText()));
            }
        });

        d20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d20.getText()));
            }
        });

        d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d12.getText()));
            }
        });

        d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d10.getText()));
            }
        });

        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d8.getText()));
            }
        });

        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d6.getText()));
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.append(String.format("%s ", d4.getText()));
            }
        });

        btRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = rollDisplay.getText().toString();

                String[] dice = PegarTela(value);
                dice = Aleatorio(dice);
                int soma = Total(dice);

                rollDisplay.setText(String.format(Arrays.toString(dice)));
                rollDisplay.append(String.format(" = %d ", soma));

            }
        });

        btClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDisplay.setText(String.format(""));
            }
        });

    }

    // #########        FUNÇÕES     ##############

    public String[] PegarTela(String string){
        String dice[];
       
        dice = string.split(" ");
        for (int i=0;i<dice.length;i++) {
            dice[i] = dice[i].replaceAll("[^0-9]", "");

        }

        return dice;
    }

    public String[] Aleatorio(String[] dice){
        Random numb= new Random();
        for(int i=0; i<dice.length;i++){
            dice[i] = String.valueOf(numb.nextInt(Integer.parseInt(dice[i]))+1);
        }
        return dice;
    }

    public int Total(String[] num){
        int soma = 0;
        Random numb= new Random();
        for(int i=0; i<num.length;i++){
            num[i] = String.valueOf(numb.nextInt(Integer.parseInt(num[i]))+1);
            soma = soma + Integer.parseInt(num[i]);
        }
        return soma;
    }

}
