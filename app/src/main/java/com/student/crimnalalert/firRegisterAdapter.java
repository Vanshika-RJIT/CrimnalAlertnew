package com.student.crimnalalert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.student.crimnalalert.Fragment.Navbar_FIR;

import java.util.List;

public class firRegisterAdapter  extends RecyclerView.Adapter<firRegisterAdapter.ViewHolder>{
//    List<Integer> images;
//    List<String> title;
//    LayoutInflater inflater;
//
//    public firRegisterAdapter(List<Integer> images, List<String> title, Context ctx) {
//        this.images = images;
//        this.title = title;
//        this.inflater = LayoutInflater.from(ctx);
//    }

    @NonNull
    @Override
    public firRegisterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fir_register_adapter,parent,false);
    //View view=inflater.inflate(R.layout.activity_fir_register_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull firRegisterAdapter.ViewHolder holder, int position) {
//    holder.textView.setText(title.get(position));
//    holder.imageView.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.imageid);
            textView=itemView.findViewById(R.id.textid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"cliked"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
