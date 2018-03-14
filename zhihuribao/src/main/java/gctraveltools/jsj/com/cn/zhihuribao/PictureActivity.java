package gctraveltools.jsj.com.cn.zhihuribao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import gctraveltools.jsj.com.cn.zhihuribao.view.PictureView;
import gctraveltools.jsj.com.cn.zhihuribao.view.PrictureBean;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        PictureView pictureView = (PictureView) findViewById(R.id.PictureView);
        ArrayList<PrictureBean> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            PrictureBean e = new PrictureBean();
            switch (i) {
                case 0:
                    e.Percentage = 0.3f;
                    break;
                case 1:
                    e.Percentage = 0.2f;
                    break;
                case 2:
                    e.Percentage = 0.8f;
                    e.isLowProce = true;
                    break;
                case 3:
                    e.Percentage = 0.5f;
                    break;
                default:
                    e.Percentage = 1f;
                    break;
            }

            e.PriceDes = "1234";
            e.time = "333";
            items.add(e);

        }
        pictureView.setOnSelectListener(new PictureView.OnSelectListener() {
            @Override
            public void select(int position) {
                Toast.makeText(PictureActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        pictureView.setItems(items, 2);
    }
}
