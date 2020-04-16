package com.example.my_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0,button1,button2,button3,button4,button5,button6,button7,
            button8,button9,buttonadd,buttonsub,buttonmulty,buttondiv,buttonC,buttonequal
            ,buttondeci,buttonback,buttonsign;
    TextView display,output;
    int s=0;
    private double val1 = Double.NaN;
    private double val2;
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MULTIPLY = '*';
    private static final char DIV = '/';
    private static final char PER = '%';
    private char CURRENT_ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0=(Button)findViewById(R.id.num0);
        button1=(Button)findViewById(R.id.num1);
        button2=(Button)findViewById(R.id.num2);
        button3=(Button)findViewById(R.id.num3);
        button4=(Button)findViewById(R.id.num4);
        button5=(Button)findViewById(R.id.num5);
        button6=(Button)findViewById(R.id.num6);
        button7=(Button)findViewById(R.id.num7);
        button8=(Button)findViewById(R.id.num8);
        button9=(Button)findViewById(R.id.num9);
        buttonadd=(Button)findViewById(R.id.addition);
        buttonsub=(Button)findViewById(R.id.subtraction);
        buttonmulty=(Button)findViewById(R.id.multiplication);
        buttondiv=(Button)findViewById(R.id.division);
        buttonC=(Button)findViewById(R.id.clear);
        buttonequal=(Button)findViewById(R.id.equal);
        buttondeci=(Button)findViewById(R.id.decimal);
        buttonback=(Button)findViewById(R.id.back);
        buttonsign=(Button)findViewById(R.id.adder_sub);
        display=(TextView)findViewById(R.id.data);
        output=(TextView)findViewById(R.id.output);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+"9");
            }
        });

        buttondeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString()+".");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                display.setText(null);
                output.setText(null);

            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cal();
                CURRENT_ACTION=ADD;
                output.setText(String.valueOf(val1));
                display.setText(null);
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cal();
                CURRENT_ACTION=SUB;
                output.setText(String.valueOf(val1));
                display.setText(null);
            }
        });

        buttonmulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cal();
                CURRENT_ACTION = MULTIPLY;
                output.setText(String.valueOf(val1));
                display.setText(null);
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cal();
                CURRENT_ACTION=DIV;
                output.setText(String.valueOf(val1));
                display.setText(null);
            }
        });

        buttonsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s==0){
                    display.setText("-" + display.getText().toString());
                    s=1;
                }
                else
                {
                    display.setText(display.getText().toString());
                    s=0;
                }
            }
        });


        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText()!= null) {
                    Cal();
                    output.setText(String.valueOf(val1));
                    display.setText(null);
                    CURRENT_ACTION = '0';
                }
                else{
                    output.setText(null);
                }
            }
        });

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().length() > 0){
                    CharSequence name = display.getText().toString();
                    display.setText(name.subSequence(0, name.length()-1));
                }

            }
        });

    }
    private void Cal() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(display.getText().toString());

            if(CURRENT_ACTION == ADD)
                val1 = val1 + val2;
            else if(CURRENT_ACTION == SUB)
                val1 = val1 - val2;
            else if(CURRENT_ACTION == MULTIPLY)
                val1 = val1 * val2;
            else if(CURRENT_ACTION == DIV)
                val1 = val1 / val2;
            else if(CURRENT_ACTION == PER)
                val1= val1 / 100;
        }
        else {
            val1 = Double.parseDouble(display.getText().toString());
        }
    }
}
