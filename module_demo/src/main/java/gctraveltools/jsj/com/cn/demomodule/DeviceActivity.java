package gctraveltools.jsj.com.cn.demomodule;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.commonlib.util.DeviceUtils;

/**
 * -----------作者----------日期----------变更内容-----
 * -          刘泽      2018-05-23       创建class
 */
public class DeviceActivity extends BaseActivity {

    private TextView mViewById;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        mViewById = (TextView) findViewById(R.id.tv_device);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        ;
        String s = DeviceUtils.getAndroidID() +
                DeviceUtils.getMacAddress() +
                DeviceUtils.getManufacturer() +
                DeviceUtils.getModel() +
                DeviceUtils.getSDKVersionCode() +
                DeviceUtils.getSDKVersionName() +
                DeviceUtils.isDeviceRooted() + "\n" +
                Build.getRadioVersion() +"\n" + Build.BOARD + "\n" +Build.BOOTLOADER
       + "\n"    + Build.BRAND + "\n" +Build.DEVICE +"\n" + Build.DISPLAY + "\n\n"

                +Build.FINGERPRINT + "\n" +Build.HARDWARE
        +"\n" + Build.HOST +"\n" + Build.ID + "\n" +Build.MANUFACTURER +
                "\n" +Build.MODEL +"\n" + Build.PRODUCT
        +"\n" + Build.TAGS +"\n" + Build.TYPE + "\n" +Build.USER;
        mViewById.setText(s);
    }
}
