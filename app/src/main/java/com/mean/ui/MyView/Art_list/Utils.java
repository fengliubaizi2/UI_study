package com.mean.ui.MyView.Art_list;

/**
 * Created by renzhenhua on 2017/10/18.
 */

import android.content.Context;
import android.util.TypedValue;

public class Utils {

    public static int dp2px(Context context, int dp) {
        return Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()));
    }
}
