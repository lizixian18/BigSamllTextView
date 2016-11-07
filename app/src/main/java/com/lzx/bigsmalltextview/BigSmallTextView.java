package com.lzx.bigsmalltextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lzx on 2016/11/4.
 * 功能：
 */

public class BigSmallTextView extends View {

    private float bigTextSize;
    private float smallTextSize;
    private String bigText = "";
    private String smallText = "";
    private int bigTextColor;
    private int smallTextColor;

    private Paint mBigPaint, mSmallPain;
    private Rect mBigRect, mSmallRect;

    private float bigText_marginBottom;
    private float smallText_marginBottom;
    private float textOffset = 0;  //两个文字之间的距离

    public BigSmallTextView(Context context) {
        this(context, null);
    }

    public BigSmallTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public BigSmallTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BigSmallTextView);
        bigTextSize = typedArray.getDimension(R.styleable.BigSmallTextView_bigTextSize, 16);
        smallTextSize = typedArray.getDimension(R.styleable.BigSmallTextView_smallTextSize, 14);
        bigText = typedArray.getString(R.styleable.BigSmallTextView_bigText);
        smallText = typedArray.getString(R.styleable.BigSmallTextView_smallText);
        bigTextColor = typedArray.getColor(R.styleable.BigSmallTextView_bigTextColor, Color.BLACK);
        smallTextColor = typedArray.getColor(R.styleable.BigSmallTextView_smallTextColor, Color.BLACK);
        bigText_marginBottom = typedArray.getDimension(R.styleable.BigSmallTextView_bigTextMarginBottom, 0);
        smallText_marginBottom = typedArray.getDimension(R.styleable.BigSmallTextView_smallTextMarginBottom, 0);
        textOffset = typedArray.getDimension(R.styleable.BigSmallTextView_textOffset, 0);
        typedArray.recycle();

        mBigPaint = new TextPaint();
        mBigPaint.setAntiAlias(true);
        mBigPaint.setColor(bigTextColor);
        mBigPaint.setTextSize(bigTextSize);

        mSmallPain = new TextPaint();
        mSmallPain.setAntiAlias(true);
        mSmallPain.setColor(smallTextColor);
        mSmallPain.setTextSize(smallTextSize);

        mBigRect = new Rect();
        mSmallRect = new Rect();
        mBigPaint.getTextBounds(bigText, 0, bigText.length(), mBigRect);
        mSmallPain.getTextBounds(smallText, 0, smallText.length(), mSmallRect);
    }

    public void setSmallText(String smallText) {
        this.smallText = smallText;
    }

    public void setBigText(String bigText) {
        this.bigText = bigText;
    }

    public void setTextOffset(int textOffset) {
        this.textOffset = textOffset;
    }

    public void setSmallText_marginBottom(float smallText_marginBottom) {
        this.smallText_marginBottom = smallText_marginBottom;
    }

    public void setBigText_marginBottom(float bigText_marginBottom) {
        this.bigText_marginBottom = bigText_marginBottom;
    }

    public void setBigTextColor(int bigTextColor) {
        this.bigTextColor = bigTextColor;
    }

    public void setSmallTextColor(int smallTextColor) {
        this.smallTextColor = smallTextColor;
    }

    public void setSmallTextSize(float smallTextSize) {
        this.smallTextSize = smallTextSize;
    }

    public void setBigTextSize(float bigTextSize) {
        this.bigTextSize = bigTextSize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int bigTextWidth = mBigRect.width();//(int) mBigPaint.measureText(bigText);
        int smallTextWidth = mSmallRect.width();//(int) mSmallPain.measureText(smallText);

        //控件的实际宽高
        int realWidth = (int) (bigTextWidth + smallTextWidth + textOffset);
        int realHeight = mBigRect.height() > mSmallRect.height() ? mBigRect.height() : mSmallRect.height();

        int width = 0;
        int height = 0;

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            width = realWidth;
            height = realHeight;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = realWidth;
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            width = widthSize;
            height = realHeight;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight() - paddingTop - paddingBottom;

        //画文字
        float bigTextX = 0;
        float bigTextY = height - mBigPaint.descent() - bigText_marginBottom;
        canvas.drawText(bigText, bigTextX, bigTextY, mBigPaint);

        float smallTextX = mBigPaint.measureText(bigText) + textOffset;
        float smallTextY = height - mSmallPain.descent() - smallText_marginBottom;
        canvas.drawText(smallText, smallTextX, smallTextY, mSmallPain);
    }
}
