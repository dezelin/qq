package imageeffects;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import static android.R.attr.width;

/**
 * Created by dezelin on 3.12.16..
 */

public class Effects {

    public static Bitmap downsample(Context context, Bitmap src, int width, int height) {
        Bitmap scaled = Bitmap.createScaledBitmap(src, width, height, false);
        Bitmap dst = Bitmap.createBitmap(scaled);

        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation inputAllocation = Allocation.createFromBitmap(rs, scaled);
        Allocation outputAllocation = Allocation.createFromBitmap(rs, dst);
        blurScript.setRadius(0.005f);
        blurScript.setInput(inputAllocation);
        blurScript.forEach(outputAllocation);
        outputAllocation.copyTo(dst);

        return dst;

    }
}
