package com.student.crimnalalert.NCR_REGISTER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.student.crimnalalert.NCR_REGISTER_ADAPTER.MissChildrenReportAdapter;
import com.student.crimnalalert.NCR_REGISTER_ADAPTER.MissPersonReportAdapter;
import com.student.crimnalalert.R;

public class MissingChildrenReport extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mPager;
    private int Layouts[] = {R.layout.fir_missing_children_register1, R.layout.fir_missing_children_register2,
            R.layout.fir_missing_children_register3, R.layout.fir_missing_children_register4};

    private MissChildrenReportAdapter misschildrenreportadapterobj;
    private LinearLayout dotslayout;
    private ImageView dots[];
    private Button back,next;
    private int currentpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_children_report);

        initializeid();

        back.setOnClickListener(this);
        next.setOnClickListener(this);

        misschildrenreportadapterobj = new MissChildrenReportAdapter(Layouts, MissingChildrenReport.this);
        mPager.setAdapter(misschildrenreportadapterobj);
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

    }

    private void createdots(int current_position) {
        if (dotslayout != null) {
            dotslayout.removeAllViews();
        }
        dots = new ImageView[Layouts.length];
        for (int i = 0; i < Layouts.length; i++) {
            dots[i] = new ImageView(MissingChildrenReport.this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(MissingChildrenReport.this,R.drawable.activedots));
            }else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(MissingChildrenReport.this,R.drawable.inactivedots));
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


}
