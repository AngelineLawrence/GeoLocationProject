package com.example.angelinealex.geolocationproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

/**
 * Created by AngelineAlex on 8/9/17.
 */


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<MessageClass> mMessageList;
    private FirebaseAuth mAuth;

    /**
     * Instantiates a new Message adapter.
     *
     * @param mMessageList the m message list
     */
    public MessageAdapter(List<MessageClass> mMessageList ){
        this.mMessageList = mMessageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_single_layout,parent, false);
        return new MessageViewHolder(v);
    }

    /**
     * The type Message view holder.
     */
    public class MessageViewHolder extends RecyclerView.ViewHolder{

        /**
         * The Message text.
         */
        public TextView messageText;


        /**
         * Instantiates a new Message view holder.
         *
         * @param view the view
         */
        public MessageViewHolder(View view){
            super(view);

            messageText = (TextView) view.findViewById(R.id.message_textview);

        }


    }

    @Override
    public void onBindViewHolder(MessageViewHolder viewHolder, int i){

        String current_user_id = mAuth.getInstance().getCurrentUser().getUid();

        MessageClass c= mMessageList.get(i);
        String from_user= c.getFrom();
        if(current_user_id.equals(from_user)){

            viewHolder.messageText.setBackgroundColor(Color.WHITE);
            viewHolder.messageText.setTextColor(Color.BLACK);

        }
        else{
            viewHolder.messageText.setBackgroundResource(R.drawable.message_background);
            viewHolder.messageText.setTextColor(Color.WHITE);
        }

        viewHolder.messageText.setText(c.getMessage());

    }

    @Override
    public int getItemCount(){
        return mMessageList.size();
    }

}
