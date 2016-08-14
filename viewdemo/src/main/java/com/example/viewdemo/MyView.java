package com.example.viewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class MyView extends View {
    private float mWidth = 0; // TODO: use a default from R.string...
    private float mHeight = 0; // TODO: use a default from R.string...
    private float mRadius = 5; // TODO: use a default from R.string...
    private int circleColor = Color.BLUE; // TODO: use a default from R.string...

    public MyView(Context context) {
        super(context);

        Log.i("aaa","dd");
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);//布局文件调用这个构造方法
        init(context,attrs,0);
        Log.i("aaa","dd1");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

//        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {//wrap_content时
//            setMeasuredDimension((int)mRadius*2, (int) (mRadius*2));
//        } else if (widthMode == MeasureSpec.AT_MOST) {
//            setMeasuredDimension((int) (mRadius*2), height);
//        } else if (heightMode == MeasureSpec.AT_MOST) {
//            setMeasuredDimension(width, (int) (mRadius*2));
//        }
    if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {//wrap_content时
            setMeasuredDimension((int)mRadius*2, (int) (mRadius*2));
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension((int)mRadius*2, height);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, (int) (mRadius*2));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint myPaint = new Paint();
        myPaint.setColor(circleColor);
        Log.i("aaa","dd4");
        canvas.drawCircle(mWidth,mHeight,mRadius,myPaint);
    }
private void init(Context context,AttributeSet attrs,int defStyle){
    final TypedArray a = getContext().obtainStyledAttributes(
            attrs, R.styleable.MyView, defStyle, 0);
    mWidth = a.getDimension(R.styleable.MyView_mWidth,mWidth);
    mHeight = a.getDimension(R.styleable.MyView_mHeight,mWidth);
    mRadius = a.getDimension(R.styleable.MyView_mRadius,mRadius);
    circleColor = a.getColor(R.styleable.MyView_circleColor,circleColor);
}
}
