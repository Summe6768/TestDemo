package com.app.summer.testdemo.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.app.summer.testdemo.R;

/**
 * @author jingwei
 * date: 2019/8/2
 * desc: 自定义View
 */
public class MyCustomView extends View {
    private Context context;

    private int circleRadius = 50; //圆的半径
    private int circleX = 60; //圆的x坐标
    private int circleY = 60; //圆的y坐标

    private String mText;

    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        mText = typedArray.getString(R.styleable.MyCustomView_text);
        typedArray.recycle();

    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 设置wrap_content的默认宽 / 高值
        // 默认宽/高的设定并无固定依据,根据需要灵活设置
        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看
        int mWidth = 200;
        int mHeight = 200;

        // 获取宽-测量规则的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        // 获取高-测量规则的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        // 当布局参数设置为wrap_content时，设置默认值
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth, mHeight);
            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth, heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, mHeight);
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        circle(canvas);
        //画空心圆
        circleHollow(canvas);
        //画空心圆 (添加阴影)
        circleShadeHollow(canvas);
        //xml中设置自定义text
        drawText(canvas, context);
        //画线
        drawLine(canvas);


    }


    /**
     * 画圆
     *
     * @param canvas
     */
    private void circle(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(false); //设置抗锯齿
        paint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawCircle(circleX, circleY, circleRadius, paint);
    }

    /**
     * 画空心圆
     *
     * @param canvas
     */
    private void circleHollow(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(circleX * 3, circleY, circleRadius, paint);
    }

    /**
     * 画空心圆 (添加阴影)
     *
     * @param canvas
     */
    private void circleShadeHollow(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.STROKE);
        paint.setShadowLayer(1, 5, 5, getResources().getColor(R.color.colorBlack)); // 阴影
        canvas.drawCircle(circleX * 5, circleY, circleRadius, paint);
    }

    /**
     * xml中设置自定义text
     *
     * @param canvas
     */
    private void drawText(Canvas canvas, Context context) {
        Paint paint = new Paint();
        //android 6.0 ，6.0以上getResources().getColor() 方法过时
        //paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setColor(ContextCompat.getColor(context, R.color.colorBlack));
        paint.setTextSize(50);
        if (!TextUtils.isEmpty(mText)) {
            //设置xml中的字体
            canvas.drawText(mText, circleX * 7, circleY, paint);
        } else {
            //设置默认字体
            canvas.drawText("默认字体", circleX * 7, circleY, paint);
        }
    }

    /**
     * 画线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.colorBlack));
        canvas.drawLine(circleX * 12, circleY, circleX * 17, circleY * 2, paint);
        canvas.drawLine(circleX * 17, circleY * 2, circleX * 18, circleY, paint);
        canvas.drawOval(100,100,200,150,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("TAG", "onTouchEvent : DOWN"  );
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("TAG", "onTouchEvent : MOVE"  );
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TAG", "onTouchEvent : UP"  );
                break;
        }
        return true;
    }
}
