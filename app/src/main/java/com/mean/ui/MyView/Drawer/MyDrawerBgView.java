package com.mean.ui.MyView.Drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mean.ui.R;

/**
 * Created by renzhenhua on 2017/10/16.
 */

public class MyDrawerBgView extends View {
    Path path =new Path();
    Paint paint=new Paint();

    public MyDrawerBgView(Context context) {
        this(context,null);
    }

    public MyDrawerBgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setAntiAlias(true);
    }
    public void setPaintColor(int color){
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path,paint);
    }
    public void setTouchY(float y,float percent){
        path.reset();
        float width=getWidth();
        float height=getHeight();
        float offsetY=height/8;
        path.lineTo(100,-offsetY);//起点坐标
        path.quadTo(1.5f*width,y,100,height*9f/8f);
        path.lineTo(0,height);
        path.close();
        invalidate();
    }
}
