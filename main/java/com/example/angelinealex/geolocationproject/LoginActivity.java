package com.example.angelinealex.geolocationproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * This is Activity is launched first when the app starts
 * Allows the registered users to login
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private EditText Username1;
    private EditText password1;
    private TextView textView2;
    private TextView textView;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabaseReference;


    /**
     *
     * Gets invoked with the launch of LoginActivity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");



        progressDialog = new ProgressDialog(this);
        login = (Button) findViewById(R.id.login);
        Username1= (EditText) findViewById(R.id.Username1);
        password1 = (EditText) findViewById(R.id.password1);
        textView2=(TextView) findViewById(R.id.textView2);
        textView=(TextView) findViewById(R.id.textView);
        login.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView.setOnClickListener(this);

    }

    /**
     * Verifies the inputs given by the user
     */
    private void userLogin(){

        String email= Username1.getText().toString().trim();
        String password =password1.getText().toString().trim();

        if(TextUtils.isEmpty((CharSequence) email))
        {
            //email is empty
            Toast.makeText(this,"Enter your email",Toast.LENGTH_SHORT).show();
            // stop the function
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            //passwrod is empty
            //email is empty
            Toast.makeText(this,"Enter your Password",Toast.LENGTH_SHORT).show();
            return;

        }
        progressDialog.setMessage("Processing to Login....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    //mRootRef.child("Users").child(mCurrentUserId).addValueEventListener(new ValueEventListener()

                   /* mDatabaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            UsersClass usersClass = dataSnapshot.getValue(UsersClass.class);
                            if(usersClass.getUserId()==""){
                                usersClass.setUserId(firebaseAuth.getCurrentUser().getUid());
                               // mDatabaseReference.child("Users").child(firebaseAuth.getCurrentUser().getUid())
                                     //   .child("userId").setValue(firebaseAuth.getCurrentUser().getUid());
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });*/




                        //firebaseAuth.getCurrentUser().getUid();

                    startActivity(new Intent(LoginActivity.this, UserListActivity.class));
                    finish();



                } else {
                    Toast.makeText(LoginActivity.this, "UnSuccessful Login Credentials... Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }


    @Override
    public void onClick(View view) {

        if(view == login){
            userLogin();

        }

        if(view==textView2)
        {
            startActivity(new Intent(this, MainActivity.class));
        }

        if(view==textView)
        {
            startActivity(new Intent(this, ForgotActivity.class));
        }
    }



}
