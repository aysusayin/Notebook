package aysusayin.com.mynotebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {
    private static final int REFRESH_DELAY = 2000;
    private PullToRefreshView mPullToRefreshView;
    private ListView listview;
    private ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this, New_Note_Activity.class));
            }
        });

        listview = (ListView) findViewById(R.id.list_view);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //tıklanan  nota git
                Intent intent = new Intent(NotesActivity.this,ViewActivity.class);
                Note n = notes.get(position);
                intent.putExtra("note_name",n.getTitle());
                intent.putExtra("note_date",n.getDate());
                intent.putExtra("note_content",n.getNote());
                startActivity(intent);
            }
        });

        refresh();
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                        mPullToRefreshView.setRefreshing(false);

                    }
                }, REFRESH_DELAY);
            }
        });


    }
    private void refresh(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(user.getUid());
        notes= new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapShot: dataSnapshot.getChildren()){
                    Note model = postSnapShot.getValue(Note.class);
                    notes.add(model);
                    Log.d("Note eklendi------", "onDataChange:  "+model.getTitle());
                }
                UserAdapter adapter = new UserAdapter(getApplicationContext(),notes);
                listview.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Log.d("ok", "onDataChange: ");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(NotesActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
