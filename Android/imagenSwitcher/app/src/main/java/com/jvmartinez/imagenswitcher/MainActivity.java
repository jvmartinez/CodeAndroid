package com.jvmartinez.imagenswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageSwitcher imageSwitcher;
    private Button btnNext;
    private Button btnProvous;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.count = -1;
        this.initComponetView();
        this.addingListerner();
        this.addAnimation();
    }

    public void initComponetView(){
        this.imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcherMain);
        this.btnNext = (Button) findViewById(R.id.btnNetx);
        this.btnProvous = (Button) findViewById(R.id.btnPrevious);
        this.imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView image = new ImageView(getBaseContext());
                image.setLayoutParams(new ImageSwitcher.LayoutParams(-1,-1));
                image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                image.setImageResource(R.drawable.img_1);
                return image;
            }
        });
    }

    public void actionButtons(boolean action){

            if(action){
                this.count++;
                if(this.count==this.drawables().size()){
                    count = 0;
                }else {

                    this.imageSwitcher.setImageResource(this.drawables().get(this.count));
                }
            }else{
                if(this.count != -1){
                    if(this.count == this.drawables().size()){
                        this.count=0;
                    }else {
                        this.imageSwitcher.setImageResource((this.drawables().get(this.count) - 1));
                        this.count--;
                    }
            }
        }
    }

    public void addingListerner(){
        this.btnNext.setOnClickListener(this);
        this.btnProvous.setOnClickListener(this);
    }

    public List<Integer> drawables(){
        List<Integer> drawableList = new ArrayList<>();
        drawableList.add(R.drawable.img_1);
        drawableList.add(R.drawable.img_2);
        drawableList.add(R.drawable.img_3);
        drawableList.add(R.drawable.img_4);
        return drawableList;
    }

    public void addAnimation(){
        Animation animIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation animOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        this.imageSwitcher.setOutAnimation(animOut);
        this.imageSwitcher.setInAnimation(animIn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNetx:{
                this.actionButtons(true);
                break;
            }
            case R.id.btnPrevious:{
                this.actionButtons(false);
                break;
            }
        }
    }
}
