package com.student.crimnalalert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NavbarFirAdapter extends RecyclerView.Adapter<NavbarFirAdapter.ViewHolder> {

    Integer images[]={R.drawable.missing_person,R.drawable.missing_person_search,
            R.drawable.missing_children_search,R.drawable.complain_lodge,R.drawable.lost_found};
    String title[]={"missing-person-report","missing-person-search","missing-children-search","FIR LODGE","Lost&found"};

    @NonNull
    @Override
    public NavbarFirAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.navbarfiradapter,parent,false);
        //View view=inflater.inflate(R.layout.activity_fir_register_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavbarFirAdapter.ViewHolder holder, int position) {
        holder.textView.setText(title[position]);
       holder.imageView.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageid);
            textView = itemView.findViewById(R.id.textid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "cliked" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
