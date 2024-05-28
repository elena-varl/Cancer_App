package app.ij.mlwithtensorflowlite;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoadActivity extends AppCompatActivity {
    Button info;
    ImageView imageView;
    TextView result;
    int imageSize = 224;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        info = findViewById(R.id.button);


        result = findViewById(R.id.result);
        imageView = findViewById(R.id.imageView);


    }
    public void startNewActivity(View view)
    {
        Intent infoIntent = new Intent(this, InfoActivity2.class);
        startActivityForResult(infoIntent, 10);
    }

}
