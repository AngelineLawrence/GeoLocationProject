package com.example.angelinealex.geolocationproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


/**
 * The type User list activity.
 */
public class UserListActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;
    private DatabaseReference mRootRef;
    //private TextView textView;
    private RecyclerView mUserList;

    private String mCurrentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);


        mUserList = (RecyclerView) findViewById(R.id.RecyclerView_userList);
        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(this));
        mAuth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference();

        //if(mAuth.getCurrentUser()!=null)
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        mCurrentUserId = mAuth.getCurrentUser().getUid();

    }





    protected void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter<UsersClass,UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UsersClass, UsersViewHolder>(
                UsersClass.class,
                R.layout.individual_users,
                UsersViewHolder.class,
                mDatabaseReference

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder usersViewHolder, final UsersClass model, int position) {
                usersViewHolder.setName(model.getName());
                final String list_user_id = getRef(position).getKey();
                //final String userid = mDatabaseReference.child("Users").child(model.getName()).getKey();

                //set on click action for textview
                usersViewHolder.userNameView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent goToChatActivity = new Intent(UserListActivity.this, ChatActivity.class);
                        goToChatActivity.putExtra("user_id",list_user_id);
                        startActivity(goToChatActivity);
                    }
                });

            }

        };

        mUserList.setAdapter(firebaseRecyclerAdapter);
    }

    /**
     * The type Users view holder.
     */
    public static class UsersViewHolder extends RecyclerView.ViewHolder{

        /**
         * The M view.
         */
        View mView;
        /**
         * The User name view.
         */
        public TextView userNameView;

        /**
         * Instantiates a new Users view holder.
         *
         * @param itemView the item view
         */
        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            userNameView = (TextView) mView.findViewById(R.id.username_TextView);
        }

        /**
         * Set name.
         *
         * @param name the name
         */
        public void setName(String name){
            TextView userNameView = (TextView) mView.findViewById(R.id.username_TextView);
            userNameView.setText(name);
        }

    }

}
