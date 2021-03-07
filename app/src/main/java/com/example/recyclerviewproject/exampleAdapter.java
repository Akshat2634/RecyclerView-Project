package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class exampleAdapter extends RecyclerView.Adapter<exampleAdapter.exampleViewHolder> {
   private ArrayList<exampleitem> mExampleList;
   private OnItemClickListner mListner;

   public interface OnItemClickListner{
       void onItemClick(int position) ;
       void onDeleteClick (int position);
   }
   public void setOnItemClickListner(OnItemClickListner listner){
       mListner = listner ;
   }
    public static class exampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2 ;
        public ImageView mDeleteImage ;
        public exampleViewHolder(@NonNull View itemView , final OnItemClickListner listner) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mDeleteImage = itemView.findViewById(R.id.image_delete);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                if (listner != null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listner.onItemClick(position);
                    }
                }
                }
            });
            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listner.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
    public exampleAdapter (ArrayList<exampleitem> exampleList){
     mExampleList = exampleList ;
    }
    @NonNull
    @Override
    public exampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false) ;
        exampleViewHolder evh = new exampleViewHolder(v , mListner);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull exampleViewHolder holder, int position) {
        exampleitem currentItem = mExampleList.get(position) ;
        holder.mImageView.setImageResource(currentItem.getmImagereasource());
        holder.mTextView1.setText(currentItem.getmText1());
        holder.mTextView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
