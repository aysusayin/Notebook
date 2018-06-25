package aysusayin.com.mynotebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText passEdt;
    private EditText passEdt2;
    private EditText emailEdt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);





        emailEdt = (EditText) findViewById(R.id.mail_editText);
        passEdt = (EditText) findViewById(R.id.editText6) ;
        passEdt2 = (EditText) findViewById(R.id.second_password_editText);

        ((Button)findViewById(R.id.signUpButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEdt.getText().toString().trim();
                String password =  passEdt.getText().toString().trim();
                String passwordagain = passEdt2.getText().toString().trim();
                if(validate(email,password,passwordagain)){
                    register(email,password);
                }else{
                    Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }



    private void register(String email, String password){
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("-------INFO--------", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();
                        }
                        // ...
                    }
                });
    }
    private boolean validate(String email, String password1, String password2){
        boolean status = true;

        if(!password1.equals(password2)) return false;
        if(!email.contains("@")) return false;
        if(password1.length()<6)return false;

        return status;
    }


}
