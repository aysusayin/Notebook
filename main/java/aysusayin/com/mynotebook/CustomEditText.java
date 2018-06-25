package aysusayin.com.mynotebook;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Aysu on 8.07.2017.
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    public CustomEditText(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "loginfont.otf");
        this.setTypeface(typeface);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "loginfont.otf");
        this.setTypeface(typeface);

    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "loginfont.otf");
        this.setTypeface(typeface);
    }
}

