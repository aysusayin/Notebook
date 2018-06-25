package aysusayin.com.mynotebook;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by Aysu on 8.07.2017.
 */

public class LoginButton extends AppCompatButton{


    public LoginButton(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "loginfont.otf");

        this.setTypeface(typeface);

    }

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "loginfont.otf");
        this.setTypeface(typeface);
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "loginfont.otf");
        this.setTypeface(typeface);
    }
}
