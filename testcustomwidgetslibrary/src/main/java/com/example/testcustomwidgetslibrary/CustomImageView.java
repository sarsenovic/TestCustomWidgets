package com.example.testcustomwidgetslibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class CustomImageView extends ImageView {
    private String aspectRatio;

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        checkScalingType(context, attrs);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkScalingType(context, attrs);
    }

    private void checkScalingType(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attributeSet,
                    R.styleable.CustomImageView,
                    0, 0);

            try {
                aspectRatio = typedArray.getString(R.styleable.CustomImageView_aspectRatio);
            } finally {
                typedArray.recycle();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        if (aspectRatio != null) {
            if (aspectRatio.equals("43")) {
                height = (3 * width) / 4;
            } else if (aspectRatio.equals("169")) {
                height = (9 * width) / 16;
            }
        }

        setMeasuredDimension(width, height);
    }
}
