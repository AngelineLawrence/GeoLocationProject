package com.example.angelinealex.geolocationproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Helps users to register their information and create an account with Swrl app
 */
public class MainActivity extends AppCompatActivity  implements View.OnClickListener {


    private Button Register;
    private EditText reg_email;
    private EditText reg_password;
    private TextView link_to_login;
    private EditText fullname;
    private DatabaseReference databaseReference;
    private EditText editTextfullname,editTextAddress, editTextActivity,editTextPhonenumber,editTextDepartment;
    private Button buttonSave;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(this);
        Register = (Button) findViewById(R.id.Register);
        reg_email= (EditText) findViewById(R.id.reg_email);
        reg_password = (EditText) findViewById(R.id.reg_password);
        link_to_login=(TextView) findViewById(R.id.link_to_login);
        fullname = (EditText) findViewById(R.id.fullname);

        //if(firebaseAuth.getCurrentUser()!=null){

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        //}



        editTextAddress= (EditText) findViewById(R.id.address);
        editTextPhonenumber = (EditText) findViewById(R.id.phonenumber);
        editTextActivity= (EditText) findViewById(R.id.activity1);
        editTextDepartment= (EditText) findViewById(R.id.department);


        Register.setOnClickListener(this);
        link_to_login.setOnClickListener(this);;

    }
    /**
     * Gets user information from input fields and creates a class for the user
     * The class is persisted into the database
    */
    private void registerUser()
    {
        String email= reg_email.getText().toString().trim();
        String password =reg_password.getText().toString().trim();
        String name = fullname.getText().toString().trim();
        String address= editTextAddress.getText().toString().trim();
        String activity=editTextActivity.getText().toString().trim();
        String phonenumber=editTextPhonenumber.getText().toString().trim();
        String department=editTextDepartment.getText().toString().trim();
        double latitude=0;
        double longitude=0;


        if(TextUtils.isEmpty(email))
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
        if(TextUtils.isEmpty(name))
        {
            //password is empty
            //email is empty
            Toast.makeText(this,"Enter your FullName",Toast.LENGTH_SHORT).show();
            return;

        }


      /*  UsersClass user = new UsersClass(userId);
        FirebaseUser user = firebaseAuth.getCurrentUser().getUid();
        if(UsersClass.getUserId()==null){
            databaseReference.child(user.getUid()).setValue(usersClass);
        }*/




        FirebaseUser user= firebaseAuth.getCurrentUser();
        UsersClass usersClass =new UsersClass(name,address,activity,phonenumber,department,email,latitude, longitude);


        assert user != null;
        databaseReference.child(user.getUid()).setValue(usersClass);
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();


        progressDialog.setMessage("Registering User....");
        progressDialog.show();
        Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // User is successfully registered
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();


                } else {
                    Toast.makeText(MainActivity.this, "UnSuccessful Registration.... Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }


    @Override
    public void onClick(View view) {

        if (view == Register) {
            registerUser();

        }
        if (view == link_to_login) {
            startActivity(new Intent(this, LoginActivity.class));
        }

    }

}