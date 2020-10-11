package com.student.crimnalalert.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.crimnalalert.R;
import com.student.crimnalalert.firRegisterAdapter;

import java.util.ArrayList;
import java.util.List;

public class Navbar_FIR extends Fragment {

   private View v;
//  private LinearLayoutManager linearLayoutManager;

List<String> titles;
List<Integer> images;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.activity_navbar__f_i_r,container,false);
        RecyclerView recyclerView=v.findViewById(R.id.firRegister_id);

        titles=new ArrayList<>();
        images=new ArrayList<>();

        titles.add("missing-person-report");
        titles.add("missing-person-search");
        titles.add("missing-children-search");
        titles.add("FIR LODGE");
        titles.add("Lost&found");

        images.add(R.drawable.missing_person);
        images.add(R.drawable.missing_person_search);
        images.add(R.drawable.missing_children_search);
        images.add(R.drawable.complain_lodge);
        images.add(R.drawable.lost_found);



//        linearLayoutManager=new LinearLayoutManager(v.getContext(),RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);

        firRegisterAdapter  obj=new firRegisterAdapter(images,titles,v.getContext());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(v.getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(obj);

        return v;
    }
}