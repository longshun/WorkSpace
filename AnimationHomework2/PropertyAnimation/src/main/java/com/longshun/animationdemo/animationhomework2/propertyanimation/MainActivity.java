package com.longshun.animationdemo.animationhomework2.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {

    private ImageView startIcon;
    private ImageView endIcon;
    private ImageView iconA;
    private ImageView iconB;
    private ImageView iconC;
    private ImageView iconD;
    private ImageView iconE;
    private ImageView iconF;
    private float y;
    private float x;
    private Animator scaleAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setIconsListener();
    }
    private void initViews(){
        startIcon = (ImageView)findViewById(R.id.img_icon_start);
        endIcon = (ImageView) findViewById(R.id.img_icon_end);
        iconA = (ImageView) findViewById(R.id.img_icon_a);
        iconB = (ImageView) findViewById(R.id.img_icon_b);
        iconC = (ImageView) findViewById(R.id.img_icon_c);
        iconD = (ImageView) findViewById(R.id.img_icon_d);
        iconE = (ImageView) findViewById(R.id.img_icon_e);
        iconF = (ImageView) findViewById(R.id.img_icon_f);
    }
    private void setIconsListener(){
        iconA.setOnTouchListener(this);//为什么不能给RelativeLayout设置监听事件
        iconB.setOnTouchListener(this);
        iconC.setOnTouchListener(this);
        iconD.setOnTouchListener(this);
        iconE.setOnTouchListener(this);
        iconF.setOnTouchListener(this);
    }
    public void imgStart(View view) {

        //旋转,旋转存在bug！！！
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_start_icon);
        animator.setTarget(startIcon);
        animator.start();
        //隐藏
        startIcon.setVisibility(View.INVISIBLE);
        //显示
        endIcon.setVisibility(View.VISIBLE);
        //iconA
        y = startIcon.getY();
        x = startIcon.getX();
        iconA.setY(y - 360);
        iconB.setX(x + 80);
        iconB.setY(y - 310);
        iconC.setX(x + 150);
        iconC.setY(y - 250);
        iconD.setX(x + 210);
        iconD.setY(y - 180);
        iconE.setX(x + 260);
        iconE.setY(y - 100);
        iconF.setX(x + 300);

    }
    public void imgEnd(View view) {
        if (scaleAnimator != null) {
            scaleAnimator.end();//如果有动画正在执行，结束动画;
            // TODO 存在bug，如果同时开启多个动画，只能结束一个动画！
        }
        //旋转
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_end_icon);
        animator.setTarget(endIcon);
        animator.start();
        //隐藏
        endIcon.setVisibility(View.INVISIBLE);
        //显示
        startIcon.setVisibility(View.VISIBLE);

        iconA.setY(y);
        iconB.setX(x);
        iconB.setY(y);
        iconC.setX(x);
        iconC.setY(y);
        iconD.setX(x);
        iconD.setY(y);
        iconE.setX(x);
        iconE.setY(y);
        iconF.setX(x);
        iconA.setScaleX(1);//图形在变化的时候，用户点击缩回，会出现touch的图形还会变化
        iconA.setScaleY(1);
        iconB.setScaleX(1);
        iconB.setScaleY(1);
        iconC.setScaleX(1);
        iconC.setScaleY(1);
        iconD.setScaleX(1);
        iconD.setScaleY(1);
        iconE.setScaleX(1);
        iconE.setScaleY(1);
        iconF.setScaleX(1);
        iconF.setScaleY(1);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean result = false;
        int action = event.getAction();
        ImageView imgIcon = null;
        switch (v.getId()) {
            case R.id.img_icon_a:
                if (action == MotionEvent.ACTION_DOWN) {
                    imgIcon = iconA;
                }
                break;
            case R.id.img_icon_b:
                if (action == MotionEvent.ACTION_DOWN) {
                    imgIcon = iconB;
                }
                break;
            case R.id.img_icon_c:
                if (action == MotionEvent.ACTION_DOWN) {
                    imgIcon = iconC;
                }
                break;
            case R.id.img_icon_d:
                if (action == MotionEvent.ACTION_DOWN) {
                    imgIcon = iconD;
                }
                break;
            case R.id.img_icon_e:
                if (action == MotionEvent.ACTION_DOWN) {
                    imgIcon = iconE;
                }
                break;
            case R.id.img_icon_f:
                if (action == MotionEvent.ACTION_DOWN) {
                    imgIcon = iconF;
                }
                break;
        }
        if (imgIcon != null) {
            scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.anim_icon_scale);
            scaleAnimator.setTarget(imgIcon);
            scaleAnimator.start();
            result = true;
        }
        return result;
    }
}
