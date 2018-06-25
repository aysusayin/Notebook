package aysusayin.com.mynotebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class New_Note_Activity extends AppCompatActivity {

    private EditText noteEdt;
    private EditText titleEdt;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__note_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);

        noteEdt = (EditText) findViewById(R.id.multi_editText2);
        titleEdt = (EditText) findViewById(R.id.title_editText);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            Toast.makeText(this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
            finish();
        }



        ((Button)findViewById(R.id.save_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note note = new Note();
                note.setNote(noteEdt.getText().toString());
                note.setTitle(titleEdt.getText().toString().trim());
                note.setUser(user.getEmail());
                String date = DateFormat.getDateTimeInstance().format(new Date());
                note.setDate(date);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users").child(user.getUid());
                String key = myRef.push().getKey();
                myRef.child(key).setValue(note);


                startActivity(new Intent(New_Note_Activity.this, NotesActivity.class));
                finish();

            }
        });

    }

}
