package gctraveltools.jsj.com.cn.commonlib.base;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

/**
 * 屏幕适配
 */

public class ScreenAdaptation {


    /**
     * 注册
     */
    public static void register(Context context, float width) {
        resetDensity(context, width);
    }

    /**
     * 注销
     */
    public void unregister(Context context) {
        //设置为默认
        context.getResources().getDisplayMetrics().setToDefaults();
    }

    /**
     * dp适配 getResources().getDisplayMetrics().density
     * sp适配 getResources().getDisplayMetrics().scaledDensity
     * pt适配 getResources().getDisplayMetrics().xdpi
     * @param context
     * @param width   ui设计图的宽度
     */
    private static void resetDensity(Context context, float width) {
        Point point = new Point();
        //获取屏幕的数值
        ((WindowManager) context.getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
        //dp适配 getResources().getDisplayMetrics().density
        context.getResources().getDisplayMetrics().density = point.x / width ;
        // context.getResources().getDisplayMetrics().density = point.y/height*2f;
        //sp适配 getResources().getDisplayMetrics().scaledDensity
        context.getResources().getDisplayMetrics().scaledDensity = point.x / width;
        //  context.getResources().getDisplayMetrics().scaledDensity = point.y/height*2f;
    }


}
