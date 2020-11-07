package com.student.crimnalalert.NCRfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.student.crimnalalert.R;

import static java.lang.String.valueOf;

public class misspersonregister1  extends Fragment implements AdapterView.OnItemSelectedListener {

    private View v;
    private Button firstnext;
    public misspersonregister1() {
    }
    private EditText fullname,fathername,address,yearofbirth,weigth;
    private EditText agefrom,ageto,heightfromfeet,heightfrominch,heightfromcm, heighttofeet,heighttoinch,heighttocm;
    private Spinner relation,gender,complexion;

    private String Relation[]={"select none","Father","Mother","Sister","brother","Husband","Wife"};
    private String Complexion[]={"select none","Light Skin","Fair Skin","Medium Skin","Oliv Skin","Tanbrown Skin","Blackbrown Skin"};
    private String Gender[]={"select none","Male","Female","others"};

    private static String spinrelation;
    private float total_height;
    private float a= (float) 30.48,b= (float) 2.54;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fir_miss_person_register1,container,false);

        firstnext=v.findViewById(R.id.firstnext);

        fullname=v.findViewById(R.id.MDPreg1fullname);
        address=v.findViewById(R.id.MDPreg1address);
        yearofbirth=v.findViewById(R.id.MDPreg1yearofbirth);
        weigth=v.findViewById(R.id.MDPreg1weight);

        // private EditText agefrom,ageto,heightfromfeet,heightfrominch,heightfromcm, heighttofeet,heighttoinch,heighttocm;
        agefrom=v.findViewById(R.id.MDPreg1agefrom);
        ageto=v.findViewById(R.id.MDPreg1ageto);
        heightfromfeet=v.findViewById(R.id.MDPreg1heightfromfeet);
        heightfrominch=v.findViewById(R.id.MDPreg1heightfrominch);
        heightfromcm=v.findViewById(R.id.MDPreg1heightfromcm);
        heighttofeet=v.findViewById(R.id.MDPreg1heighttofeet);
        heighttoinch=v.findViewById(R.id.MDPreg1heighttoinch);
        heighttocm=v.findViewById(R.id.MDPreg1heighttocm);
        //assign spinner id
        relation=v.findViewById(R.id.spinnerrelation);
        gender=v.findViewById(R.id.spinnergender);
        complexion=v.findViewById(R.id.spinnercomplexion);

        relation.setOnItemSelectedListener(this);
        gender.setOnItemSelectedListener(this);
        complexion.setOnItemSelectedListener(this);

       ArrayAdapter relationadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,Relation);
        relationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relation.setAdapter(relationadapter);

      ArrayAdapter genderadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,Gender);
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderadapter);

       ArrayAdapter complexionadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,Complexion);
        complexionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        complexion.setAdapter(complexionadapter);


       String name= firstnext.getText().toString();
        String adress= address.getText().toString();
        String dob= yearofbirth.getText().toString();
        String weight= weigth.getText().toString();
      final   String heightfeet=heightfromfeet.getText().toString();

        fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        yearofbirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        weigth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        agefrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ageto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heightfromfeet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heightfrominch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heightfromcm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heighttofeet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heighttoinch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heighttocm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        firstnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalidation();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.ncrframe,new misspersonregister2());
                ft.commit();
            }
        });
        

        return v;
    }

       private void checkvalidation() {
           int heightfeet = 0;
           if(heightfeet== 5){
            Toast.makeText(getContext(),"hii",Toast.LENGTH_SHORT).show();
       }
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(fullname.getText())) {
            if(!TextUtils.isEmpty(address.getText())){
                if(!TextUtils.isEmpty(yearofbirth.getText())){
                    if(!TextUtils.isEmpty(weigth.getText())){

                        if(!TextUtils.isEmpty(agefrom.getText())){
                            if(!TextUtils.isEmpty(ageto.getText())){
                                if(!TextUtils.isEmpty(heightfromfeet.getText())){
                                    if(!TextUtils.isEmpty(heightfrominch.getText())){
                                        if(!TextUtils.isEmpty(heightfromcm.getText())){
                                            if(!TextUtils.isEmpty(heighttofeet.getText())){
                                                if(!TextUtils.isEmpty(heighttoinch.getText())){
                                                    if(!TextUtils.isEmpty(heighttocm.getText())){
                                                        if(!spinrelation.equalsIgnoreCase("select none")){
                                                            Toast.makeText(getContext(),spinrelation,Toast.LENGTH_SHORT).show();
                                                            firstnext.setEnabled(true);
                                                            firstnext.setTextColor(Color.rgb(255,255,255));
                                                        }
                                                        else{
                                                            firstnext.setEnabled(false);
                                                            firstnext.setTextColor(Color.argb(50,255,255,255));
                                                        }
//
                                                    }
                                                    else{
                                                        firstnext.setEnabled(false);
                                                        firstnext.setTextColor(Color.argb(50,255,255,255));
                                                    }
                                                }
                                                else{
                                                    firstnext.setEnabled(false);
                                                    firstnext.setTextColor(Color.argb(50,255,255,255));
                                                }

                                            }else{
                                                firstnext.setEnabled(false);
                                                firstnext.setTextColor(Color.argb(50,255,255,255));

                                            }

                                        }else{
                                            firstnext.setEnabled(false);
                                            firstnext.setTextColor(Color.argb(50,255,255,255));
                                        }

                                    }else{
                                        firstnext.setEnabled(false);
                                        firstnext.setTextColor(Color.argb(50,255,255,255));
                                    }

                                }else{
                                    firstnext.setEnabled(false);
                                    firstnext.setTextColor(Color.argb(50,255,255,255));
                                }

                            }else{
                                firstnext.setEnabled(false);
                                firstnext.setTextColor(Color.argb(50,255,255,255));
                            }
                        }else{
                            firstnext.setEnabled(false);
                            firstnext.setTextColor(Color.argb(50,255,255,255));
                        }

                    }else{
                        firstnext.setEnabled(false);
                        firstnext.setTextColor(Color.argb(50,255,255,255));
                    }

                }else{
                    firstnext.setEnabled(false);
                    firstnext.setTextColor(Color.argb(50,255,255,255));
                }
            }else{
                firstnext.setEnabled(false);
                firstnext.setTextColor(Color.argb(50,255,255,255));
            }
        }
        else{
            firstnext.setEnabled(false);
            firstnext.setTextColor(Color.argb(50,255,255,255));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

      //  String spinrelation=relation.getSelectedItem().toString();
        String spingender=gender.getSelectedItem().toString();
        String spincomplexion=complexion.getSelectedItem().toString();

         spinrelation=relation.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
