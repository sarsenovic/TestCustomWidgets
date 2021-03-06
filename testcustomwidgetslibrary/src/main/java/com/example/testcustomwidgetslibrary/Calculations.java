package com.example.testcustomwidgetslibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class Calculations {
    private String aspectRatio;
    private String fixedParam;

    public void checkScalingType(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attributeSet,
                    R.styleable.CustomImageView,
                    0, 0);

            try {
                aspectRatio = typedArray.getString(R.styleable.CustomImageView_aspectRatio);
                fixedParam = typedArray.getString(R.styleable.CustomImageView_fixedParam);
//                customHorizontalRatio = typedArray.getInt(R.styleable.CustomImageView_customHorizontalRatio, 0);
//                customVerticalRatio = typedArray.getInt(R.styleable.CustomImageView_customVerticalRatio, 0);
            } finally {
                typedArray.recycle();
            }
        }
    }

    public int ratioCalculation(String aspectRatio, int parameterForEdit) {
        if (aspectRatio != null) {
            if (aspectRatio.equals("43") || aspectRatio.equals("4:3")) {
                return (3 * parameterForEdit) / 4;
            } else if (aspectRatio.equals("169") || aspectRatio.equals("16:9")) {
                return (9 * parameterForEdit) / 16;
            } else if (aspectRatio.equals("21") || aspectRatio.equals("2:1")) {
                return parameterForEdit / 2;
            }
        } else {
            return 0;
        }
        return 0;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public String getFixedParam() {
        return fixedParam;
    }
}
