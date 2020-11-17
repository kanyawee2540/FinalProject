package com.example.finalproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlayPage extends AppCompatActivity {
    private String[] labels;
    private String answer;
    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_page);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
        Random rand = new Random();
        int index = rand.nextInt(images.length - 0) + 0;
        imageView.setImageResource(images[rand.nextInt(images.length)]);
        TextView text = (TextView) findViewById(R.id.textView);
        Resources res = getResources();
        labels = res.getStringArray(R.array.syllble_list);
        if (index == 0 || index == 1 || index == 2) {
            text.setText(labels[2]);
        } else if (index == 3) {
            text.setText(labels[3]);
        }
        final EditText input = (EditText) findViewById(R.id.answerText);
        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    answer = input.getText().toString();
                    TextView txt = (TextView) findViewById(R.id.textView2);
//                    Toast.makeText(PlayPage.this, input.getText(), Toast.LENGTH_SHORT).show();
                    if (answer.equals("ถูก")) {
                        txt.setText("ถูกต้องนะค้าบ");
                        Toast.makeText(PlayPage.this, "ถูกต้องนะค้าบ", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });
        TextView txt = (TextView) findViewById(R.id.textView2);
//        if(answer.equals("ถูก")){
//            txt.setText("ถูกต้องนะค้าบ");
////            Toast.makeText(PlayPage.this, "ถูกต้องนะค้าบ", Toast.LENGTH_SHORT).show();
//        }

    }
}
