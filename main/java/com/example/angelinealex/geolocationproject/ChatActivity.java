package com.example.angelinealex.geolocationproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Chat activity.
 * Creates and stores messages
 */
public class ChatActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private DatabaseReference mRootRef;
    //private DatabaseReference mDatabaseReference;
    private String passedUserId;// = "Kon2GJ3BNRa5XvL32a8Xfmjz1Y43";
    private String mCurrentUserId;
    private Button sendButton;
    private EditText chatMessage;
    private RecyclerView mMessages_list;
    private final List<MessageClass> messageList = new ArrayList<>();
    private LinearLayoutManager mLinearLayout;
    private MessageAdapter mMessageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mAuth = FirebaseAuth.getInstance();
        //mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Chat");
        mRootRef = FirebaseDatabase.getInstance().getReference();
        mCurrentUserId = mAuth.getCurrentUser().getUid();
        sendButton = (Button) findViewById(R.id.send_button);
        chatMessage = (EditText) findViewById(R.id.meaasge_editText);

        mMessageAdapter = new MessageAdapter(messageList);
        passedUserId = getIntent().getStringExtra("user_id");
        mMessages_list = (RecyclerView) findViewById(R.id.messages_list);

        mLinearLayout = new LinearLayoutManager(this);
        mMessages_list.setHasFixedSize(true);
        mMessages_list.setLayoutManager(mLinearLayout);

        mMessages_list.setAdapter(mMessageAdapter);

        loadMessage();


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendMessage();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
    /**
     * Loads the messages from firebase into individual chats
     *
     */
    private void loadMessage() {

        mRootRef.child("messages").child(mCurrentUserId).child(passedUserId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MessageClass messageClass = dataSnapshot.getValue(MessageClass.class);
                messageList.add(messageClass);
                mMessageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Stores the messages into firebase database
     *
     */
    private void sendMessage(){
        String message = chatMessage.getText().toString();

        if(!TextUtils.isEmpty(message)){

            String current_user_ref = "messages/" + mCurrentUserId +"/" + passedUserId;
            String chat_user_ref = "messages/" + passedUserId +"/" + mCurrentUserId;

            DatabaseReference user_message_push = mRootRef.child("messages")
                    .child(mCurrentUserId).child(passedUserId).push();

            String push_id = user_message_push.getKey();

            Map messageMap = new HashMap();
            messageMap.put("message", message);
            messageMap.put("seen", false);
            messageMap.put("type", "text");
            messageMap.put("time", ServerValue.TIMESTAMP);
            messageMap.put("from", mCurrentUserId);


            Map messageUserMap = new HashMap();
            messageUserMap.put(current_user_ref + "/" + push_id, messageMap);
            messageUserMap.put(chat_user_ref + "/" + push_id, messageMap);

            chatMessage.setText("");

            mRootRef.updateChildren(messageUserMap, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if(databaseError!=null){
                        Log.d("CHAT_LOG", databaseError.getMessage().toString());
                    }
                }
            });

        }

    }
}
