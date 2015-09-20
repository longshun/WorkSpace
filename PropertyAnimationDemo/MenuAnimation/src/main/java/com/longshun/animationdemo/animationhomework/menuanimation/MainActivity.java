package com.longshun.animationdemo.animationhomework.menuanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {
    private ImageView openIcons;
    private ImageView closeIcons;
    private ImageView iconA;
    private ImageView iconB;
    private ImageView iconC;
    private ImageView iconD;
    private ImageView iconE;
    private ImageView iconF;
    private float centerX;
    private float centerY;
    private Animator scaleAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiViews();
        setIconsListener();
    }

    //初始化图标
    private void intiViews() {
        openIcons = (ImageView) findViewById(R.id.img_open_icons);
        closeIcons = (ImageView) findViewById(R.id.img_close_icons);
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
    //点击图标打开展开图标
    public void imgClickOpenIcons(View view) {
        //注意：如果在Activity的OnCreate()事件输出那些参数，是全为0，要等UI控件都加载完了才能获取到这些。
        centerX = openIcons.getX();
        centerY = openIcons.getY();
        float iconWidth = openIcons.getWidth();
        float iconHeight = openIcons.getHeight();
        float halfIconWidth = iconWidth / 2;
        float halfIconHeight = iconHeight / 2;

        RelativeLayout parent = (RelativeLayout) openIcons.getParent();//imageview所处的父容器
        float parentWidth = parent.getWidth();//父容器的宽度
        float parentHeight = parent.getHeight();//父容器的高度
        float spitParentWidth = parentWidth / 4;//将父容器宽度分割成4分，三个切点，每个点上放一个icon
        float spitParentHeight = parentHeight / 6;//将父容器高度分割成6分，五个切点，每个点上放一个icon

        //1.设置open_icons的动画
        Animator openAnimator = AnimatorInflater.loadAnimator(this, R.animator.anim_open_icons_hide);
        openAnimator.setTarget(openIcons);
        openAnimator.start();
        openIcons.setVisibility(View.GONE);
        //2.close_icons动画
        closeIcons.setVisibility(View.VISIBLE);
        Animator closeAnimator = AnimatorInflater.loadAnimator(this, R.animator.anim_close_icons_show);
        closeAnimator.setTarget(closeIcons);
        closeAnimator.start();
        //3.iconA
        iconA.setX(spitParentWidth - halfIconWidth);
        iconA.setY(spitParentHeight - halfIconHeight);
        //4.iconB
        iconB.setX(spitParentWidth * 2 - halfIconWidth);
        iconB.setY(spitParentHeight - halfIconHeight);
        //5.iconC
        iconC.setX(spitParentWidth * 3 - halfIconWidth);
        iconC.setY(spitParentHeight - halfIconHeight);
        //6.iconD
        iconD.setX(spitParentWidth - halfIconWidth);
        iconD.setY(spitParentHeight * 2 - halfIconHeight);
        //7.iconE
        iconE.setX(spitParentWidth * 2 - halfIconWidth);
        iconE.setY(spitParentHeight * 2 - halfIconHeight);
        //8.iconF
        iconF.setX(spitParentWidth * 3 - halfIconWidth);
        iconF.setY(spitParentHeight * 2 - halfIconHeight);
    }

    //点击图标隐藏打开图标
    public void imgClickCloseIcons(View view) {
        if (scaleAnimator != null) {
            scaleAnimator.end();//如果有动画正在执行，结束动画
        }
        //2.close_icons动画
        Animator closeAnimator = AnimatorInflater.loadAnimator(this, R.animator.anim_close_icons_hide);
        closeAnimator.setTarget(closeIcons);
        closeAnimator.start();
        closeIcons.setVisibility(View.INVISIBLE);
        //1.设置open_icons的动画
        openIcons.setVisibility(View.VISIBLE);
        Animator openAnimator = AnimatorInflater.loadAnimator(this, R.animator.anim_open_icons_show);
        openAnimator.setTarget(openIcons);
        openAnimator.start();
        //3.iconA，还原所有图标的初始状态
        iconA.setX(centerX);
        iconA.setY(centerY);
        iconA.setScaleX(1);//图形在变化的时候，用户点击缩回，会出现touch的图形还会变化
        iconA.setScaleY(1);
        //4.iconB
        iconB.setX(centerX);
        iconB.setY(centerY);
        iconB.setScaleX(1);
        iconB.setScaleY(1);
        //5.iconC
        iconC.setX(centerX);
        iconC.setY(centerY);
        iconC.setScaleX(1);
        iconC.setScaleY(1);
        //6.iconD
        iconD.setX(centerX);
        iconD.setY(centerY);
        iconD.setScaleX(1);
        iconD.setScaleY(1);
        //7.iconE
        iconE.setX(centerX);
        iconE.setY(centerY);
        iconE.setScaleX(1);
        iconE.setScaleY(1);
        //8.iconF
        iconF.setX(centerX);
        iconF.setY(centerY);
        iconF.setScaleX(1);
        iconF.setScaleY(1);
    }

    //只要触摸到某个Icon就缩放
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
