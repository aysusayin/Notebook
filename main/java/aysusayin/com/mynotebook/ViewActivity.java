package aysusayin.com.mynotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    private TextView titleTV, dateTV, contentTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        titleTV = (TextView) findViewById(R.id.titleTextView);
        dateTV = (TextView) findViewById(R.id.textViewDate);
        contentTV = (TextView) findViewById(R.id.textViewContent);

        Intent intent = getIntent();
        String noteTitle = intent.getStringExtra("note_name").toString();
        String noteContent = intent.getStringExtra("note_content").toString();
        String noteDate = intent.getStringExtra("note_date").toString();

        titleTV.setText(noteTitle);
        dateTV.setText(noteDate);
        contentTV.setText(noteContent);
    }
}
