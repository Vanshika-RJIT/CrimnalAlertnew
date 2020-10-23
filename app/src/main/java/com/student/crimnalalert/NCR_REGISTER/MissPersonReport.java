package com.student.crimnalalert.NCR_REGISTER;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.student.crimnalalert.NCR_REGISTER_ADAPTER.MissPersonReportAdapter;
import com.student.crimnalalert.R;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MissPersonReport extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private ViewPager mPager;
    private int Layouts[] = {R.layout.fir_miss_person_register1, R.layout.fir_miss_person_register2,
            R.layout.fir_miss_person_register3, R.layout.fir_miss_person_register4};
    private MissPersonReportAdapter missPersonReportAdapterobj;
    private LinearLayout dotslayout;
    private ImageView dots[];
    private Button back,next;
    private int currentpage;

    private EditText fullname,alias,relativename,address,yearofbirth,weigth;
    private EditText agefrom,ageto,heightfromfeet,heightfrominch,heightfromcm, heighttofeet,heighttoinch,heighttocm;
    private Spinner relation,gender,bodytype,complexion;

    private String Relation[]={"Father","Mother","Sister","brother","Husband","Wife"};

    private String BodyType[]={"ectomorph","mesomorph","endomorph"};
    private String Complexion[]={"Light Skin","Fair Skin","Medium Skin","Oliv Skin","Tanbrown Skin","Blackbrown Skin"};
    private String Gender[]={"Male","Female","others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miss_person_report);

        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

        initializeid();

        back.setOnClickListener(this);
        next.setOnClickListener(this);

//        relation.setOnItemSelectedListener(this);
//        gender.setOnItemSelectedListener(this);
//        complexion.setOnItemSelectedListener(this);
//        bodytype.setOnItemSelectedListener(this);
//
//       ArrayAdapter<String> relationadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Relation);
//       relation.setAdapter(relationadapter);
//
//      ArrayAdapter genderadapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,Gender);
//        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        gender.setAdapter(genderadapter);
//
//       ArrayAdapter complexionadapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,Complexion);
//        complexionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        complexion.setAdapter(complexionadapter);
//
//       ArrayAdapter bodytypeadapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,BodyType);
//        bodytypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        bodytype.setAdapter(bodytypeadapter);




//        gender.setAdapter(genderadapter);
//        complexion.setAdapter(complexionadapter);
//        bodytype.setAdapter(bodytypeadapter);


        missPersonReportAdapterobj = new MissPersonReportAdapter(Layouts, MissPersonReport.this);
        mPager.setAdapter(missPersonReportAdapterobj);
//        createdots(0);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createdots(position);
                currentpage=position;
                if(position==0){
                    back.setEnabled(false);
                    back.setVisibility(View.INVISIBLE);
                    next.setText("next");
                    back.setText("");
                }else if(position==Layouts.length-1){
                    next.setEnabled(true);
                    back.setEnabled(true);
                    back.setVisibility(View.VISIBLE);
                    next.setText("finish");
                    back.setText("back");
                }else {
                    next.setEnabled(true);
                    back.setEnabled(true);
                    back.setVisibility(View.VISIBLE);
                    next.setText("next");
                    back.setText("back");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initializeid() {

        mPager = findViewById(R.id.viewpager);
        dotslayout = findViewById(R.id.dotlayout);
        back=findViewById(R.id.backid);
        next=findViewById(R.id.nextid);

        fullname=findViewById(R.id.MDPreg1fullname);
        alias=findViewById(R.id.MDPreg1altername);
        relativename=findViewById(R.id.MDPreg1relativename);
        address=findViewById(R.id.MDPreg1address);
        yearofbirth=findViewById(R.id.MDPreg1yearofbirth);
        weigth=findViewById(R.id.MDPreg1weight);

       // private EditText agefrom,ageto,heightfromfeet,heightfrominch,heightfromcm, heighttofeet,heighttoinch,heighttocm;
        agefrom=findViewById(R.id.MDPreg1agefrom);
        ageto=findViewById(R.id.MDPreg1ageto);
        heightfromfeet=findViewById(R.id.MDPreg1heightfromfeet);
        heightfrominch=findViewById(R.id.MDPreg1heightfrominch);
        heightfromcm=findViewById(R.id.MDPreg1heightfromcm);
        heighttofeet=findViewById(R.id.MDPreg1heighttofeet);
        heighttoinch=findViewById(R.id.MDPreg1heighttoinch);
        heighttocm=findViewById(R.id.MDPreg1heighttocm);

        relation=findViewById(R.id.spinnerrelation);
        gender=findViewById(R.id.spinnergender);
        bodytype=findViewById(R.id.spinnerbodytype);
        complexion=findViewById(R.id.spinnercomplexion);

    }

    private void createdots(int current_position) {
        if (dotslayout != null) {
            dotslayout.removeAllViews();
        }
        dots = new ImageView[Layouts.length];
        for (int i = 0; i < Layouts.length; i++) {
            dots[i] = new ImageView(MissPersonReport.this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(MissPersonReport.this,R.drawable.activedots));
            }else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(MissPersonReport.this,R.drawable.inactivedots));
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dotslayout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backid:
                mPager.setCurrentItem(currentpage-1);
                break;
            case R.id.nextid:
                mPager.setCurrentItem(currentpage+1);
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (view.getId()){
            case R.id.spinnerrelation:
                Toast.makeText(view.getContext(),"hiii",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
