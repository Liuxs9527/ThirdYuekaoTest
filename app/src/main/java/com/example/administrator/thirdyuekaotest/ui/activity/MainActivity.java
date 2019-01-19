package com.example.administrator.thirdyuekaotest.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.thirdyuekaotest.R;
import com.example.administrator.thirdyuekaotest.ui.layout.Viewclass;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    Viewclass Myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Myview = (Viewclass) findViewById(R.id.bull);
        ObjectAnimator move = ObjectAnimator.ofFloat(Myview, "translationY", 0, 1180f);
        ObjectAnimator scale2 = ObjectAnimator.ofFloat(Myview, "translationX",0,800f);

        /*ObjectAnimator anim = ObjectAnimator.ofObject(Myview, "color", new ColorEvaluator(),"#0000FF", "#FF0000");
        anim.setDuration(5000);
        anim.start();*/
        AnimatorSet animset = new AnimatorSet();
        animset.play(move).with(scale2);
        animset.setDuration(5000);
        animset.start();
        // 动画监听
        animset.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
