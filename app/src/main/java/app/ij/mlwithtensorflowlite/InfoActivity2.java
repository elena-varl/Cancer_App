package app.ij.mlwithtensorflowlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class InfoActivity2 extends AppCompatActivity {
    Button back, main;

    TextView inf,className;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
        back = findViewById(R.id.button);
        main = findViewById(R.id.button2);
        String rec="test";



        inf = findViewById(R.id.inf);
        className = findViewById(R.id.className);


       String classify = getIntent().getStringExtra("CLASS");
       String prob = getIntent().getStringExtra("PROB");




        className.append(classify);
        className.append("\n");
        className.append("Вероятность"+":"+prob+"%");
        //inf.append("\n");
        String filename ="";
        switch (classify) {
            case "Актинический кератоз":
                filename = "ac.txt";
                break;
            case "Базалиома":
                filename = "bcc.txt";
                inf.setTextColor(Color.RED);


                break;
            case  "Доброкачественный кератоз":
                filename = "bkl.txt";
                break;
            case  "Дерматофиброма":
                filename = "df.txt";
                break;
            case "Меланома":
                filename = "mel.txt";
                break;
            case "Меланоцитарный невус":
                filename = "nv.txt";
                break;
            case "Сосудистые повреждения":
                filename = "vsl.txt";
                break;
            default:
                break;
        }
        rec = readFromAsset(filename);
        inf.append(rec);
        inf.setMovementMethod(new ScrollingMovementMethod());

    }
    public void goBack(View view)
    {
        Intent mainIntent = new Intent(InfoActivity2.this, MainActivity.class);
        startActivity(mainIntent);
    }
    public void goMain(View view)
    {
        Intent mainIntent = new Intent(InfoActivity2.this, MainActivity.class);
        startActivity(mainIntent);
    }
    public String readFromAsset(String filename) {
        String string = "";

        try {
            InputStream inputStream = getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            string = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }


}