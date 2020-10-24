package com.student.crimnalalert;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.student.crimnalalert.NCR_REGISTER.LostArticle;
import com.student.crimnalalert.NCR_REGISTER.MissPersonReport;
import com.student.crimnalalert.NCR_REGISTER.MissingChildrenReport;

//public class NavbarNcrAdapter {
//}

public class NavbarNcrAdapter extends RecyclerView.Adapter<NavbarNcrAdapter.ViewHolder> {
    private  View view;

    Integer images[]={R.drawable.nav_missing_person,R.drawable.nav_missing_person_search,
            R.drawable.nav_missingchildrensearch,R.drawable.nav_complain_lodge,R.drawable.nav_lost_found,R.drawable.nav_wanted};
    String title[]={"missing person report","missing person search","missing children search","FIR LODGE","Lost&found","wanted"};

    @NonNull
    @Override
    public NavbarNcrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.navbarncradapter,parent,false);
        //View view=inflater.inflate(R.layout.activity_fir_register_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavbarNcrAdapter.ViewHolder holder, int position) {
        holder.textView.setText(title[position]);
        holder.imageView.setImageResource(images[position]);

       if( holder.getAdapterPosition()==0) {
           Intent intent = new Intent(view.getContext(), MissPersonReport.class);
           view.getContext().startActivity(intent);
       }else if( holder.getAdapterPosition()==3){
           Intent intent1 = new Intent(view.getContext(), MissingChildrenReport.class);
           view.getContext().startActivity(intent1);
       }
       else if( holder.getAdapterPosition()==4){
           Intent intent1 = new Intent(view.getContext(), LostArticle.class);
           view.getContext().startActivity(intent1);
       }



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
