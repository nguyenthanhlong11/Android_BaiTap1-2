package com.example.thanhlong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[],data2[];
    int image[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[],int img[] ){
        data1=s1;
        data2=s2;
        context=ct;
        image=img;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.activity_list,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytextView1.setText(data1[position]);
        holder.mytextView2.setText(data2[position]);
        holder.myimage.setImageResource(image[position]);

    }
    @Override
    public int getItemCount() {
        return 5;
    }
    public class MyViewHolder  extends RecyclerView.ViewHolder {
        TextView mytextView1,mytextView2;
        ImageView myimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mytextView1 = itemView.findViewById(R.id.name);
            mytextView2 = itemView.findViewById(R.id.price);
            myimage = itemView.findViewById(R.id.imageView2);
        }
    }
}
