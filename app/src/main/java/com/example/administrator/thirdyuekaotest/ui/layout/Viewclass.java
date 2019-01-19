package com.example.administrator.thirdyuekaotest.ui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class Viewclass extends View {


    public Viewclass(Context context) {
        super(context);
    }

    public Viewclass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Viewclass(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 测量：

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    // 绘制：

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 圆
        Paint pa1 = new Paint();
        pa1.setColor(Color.GREEN);
        pa1.setAntiAlias(true);
        canvas.drawCircle(50,50,50,pa1);

    }
    // 定位：

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    // 监听

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
