package aysusayin.com.mynotebook;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Aysu on 8.07.2017.
 */

public class LoginTextView extends android.support.v7.widget.AppCompatTextView {


    public LoginTextView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "logintext.ttf");
        this.setTypeface(typeface);

    }

    public LoginTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "logintext.ttf");
        this.setTypeface(typeface);
    }

    public LoginTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "logintext.ttf");
        this.setTypeface(typeface);
    }
}
