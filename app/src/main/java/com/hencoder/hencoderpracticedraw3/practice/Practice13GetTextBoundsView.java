package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Rect mTextBounds1;
    private Rect mTextBounds2;
    private Rect mTextBounds3;
    private Rect mTextBounds4;
    private Rect mTextBounds5;
    private Rect mTextBounds6;

    private float mStartX;

    private int mCenterY;

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        mTextBounds1 = getTextBounds(text1);
        mTextBounds2 = getTextBounds(text2);
        mTextBounds3 = getTextBounds(text3);
        mTextBounds4 = getTextBounds(text4);
        mTextBounds5 = getTextBounds(text5);
        mTextBounds6 = getTextBounds(text6);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float totalWidth = mTextBounds1.width() + mTextBounds2.width() + mTextBounds3.width() + mTextBounds4.width() + mTextBounds5.width() + mTextBounds6.width();
        mStartX = getMeasuredWidth() / 2 - totalWidth / 2;
        mCenterY = (top + bottom) / 2;
    }

    private Rect getTextBounds(String text1) {
        Rect rect1 = new Rect();
        paint2.getTextBounds(text1, 0, text1.length(), rect1);
        return rect1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        float x = mStartX;
        float y = mCenterY + mTextBounds1.height() / 2;
        canvas.drawText(text1, x, y, paint2);

        x += mTextBounds1.width();
        y = mCenterY + mTextBounds2.height() / 2;
        canvas.drawText(text2, x, y, paint2);

        x += mTextBounds2.width();
        y = mCenterY + mTextBounds3.height() / 2;
        canvas.drawText(text3, x, y, paint2);

        x += mTextBounds3.width();
        y = mCenterY + mTextBounds4.height() / 2;
        canvas.drawText(text4, x, y, paint2);

        x += mTextBounds4.width();
        y = mCenterY + mTextBounds5.height() / 2;
        canvas.drawText(text5, x, y, paint2);

        x += mTextBounds5.width();
        y = mCenterY + mTextBounds6.height() / 2;
        canvas.drawText(text6, x, y, paint2);
    }
}