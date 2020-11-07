package com.student.crimnalalert.NCRfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.student.crimnalalert.R;

public class misspersonregister2  extends Fragment {

    private View v;
    private Button next;
    public misspersonregister2() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fir_miss_person_register2,container,false);
        next=v.findViewById(R.id.incidentnext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.ncrframe,new misspersonregister3());
                ft.commit();
            }
        });

        return v;
    }

}
