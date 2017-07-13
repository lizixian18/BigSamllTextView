package com.lzx.bigsmalltextview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by lzx on 2017/7/13.
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
    private DisplayMetrics metrics;

    public BigSmallTextView(Context context) {
        this(context, null);
    }

    public BigSmallTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BigSmallTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Context c = getContext();
        Resources r;
        if (c == null)
            r = Resources.getSystem();
        else
            r = c.getResources();

        metrics = r.getDisplayMetrics();

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

        mSmallPain = new TextPaint();
        mSmallPain.setAntiAlias(true);

        mBigRect = new Rect();
        mSmallRect = new Rect();
    }

    public BigSmallTextView setSmallText(String smallText) {
        this.smallText = smallText;
        return this;
    }

    public BigSmallTextView setBigText(String bigText) {
        this.bigText = bigText;
        return this;
    }

    public BigSmallTextView setTextOffset(int textOffset) {
        this.textOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, textOffset, metrics);
        return this;
    }

    public BigSmallTextView setSmallTextMarginBottom(float smallText_marginBottom) {
        this.smallText_marginBottom = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, smallText_marginBottom, metrics);
        return this;
    }

    public BigSmallTextView setBigTextMarginBottom(float bigText_marginBottom) {
        this.bigText_marginBottom = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bigText_marginBottom, metrics);
        return this;
    }

    public BigSmallTextView setBigTextColor(int bigTextColor) {
        this.bigTextColor = bigTextColor;
        return this;
    }

    public BigSmallTextView setSmallTextColor(int smallTextColor) {
        this.smallTextColor = smallTextColor;
        return this;
    }

    public BigSmallTextView setSmallTextSize(float smallTextSize) {
        this.smallTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, smallTextSize, metrics);
        return this;
    }

    public BigSmallTextView setBigTextSize(float bigTextSize) {
        this.bigTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, bigTextSize, metrics);
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        mBigPaint.setColor(bigTextColor);
        mBigPaint.setTextSize(bigTextSize);

        mSmallPain.setColor(smallTextColor);
        mSmallPain.setTextSize(smallTextSize);

        mBigPaint.getTextBounds(bigText, 0, bigText.length(), mBigRect);
        mSmallPain.getTextBounds(smallText, 0, smallText.length(), mSmallRect);

        int bigTextWidth = (int) mBigPaint.measureText(bigText);
        int smallTextWidth = (int) mSmallPain.measureText(smallText);

        //控件的实际宽高
        int realWidth = (int) (bigTextWidth + smallTextWidth + textOffset);
        int realHeight;
        if (mBigRect.height() > mSmallRect.height()) {
            realHeight = (int) (mBigRect.height() + mBigPaint.descent() + bigText_marginBottom + smallText_marginBottom);
        } else {
            realHeight = (int) (mSmallRect.height() + mSmallPain.descent() + bigText_marginBottom + smallText_marginBottom);
        }

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
