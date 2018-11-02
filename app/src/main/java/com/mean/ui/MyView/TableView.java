package com.mean.ui.MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by renzhenhua on 2017/10/2.
 */

public class TableView extends ViewGroup {


    private int currentX;
    private int currentY;

    private int scrollX;
    private int scrollY;
    //第一行
    private int firstRow;
    //第一列
    private int firstColumn;
    private int[] widths;
    private int[] heights;

    @SuppressWarnings("unused")
    private View headView;
    private List<View> rowViewList;
    private List<View> columnViewList;
    private List<List<View>> bodyViewTable;
    private int rowCount;
    private int columnCount;
    private int width;
    private int height;

    private  int minimumVelocity;

    private  int maximumVelocity;
    //需要重绘标志位
    private boolean needRelayout;
    private VelocityTracker velocityTracker;
    //滑动最小距离
    private int touchSlop;

    private Recycler recycler;
    public TableView(Context context) {
        this(context,null);
    }

    public TableView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getSize(heightMeasureSpec);
        // 如果是warp_content情况下，记录宽和高
        int width = 0;
        int height = 0;


        setMeasuredDimension(width,height);
    }
}
