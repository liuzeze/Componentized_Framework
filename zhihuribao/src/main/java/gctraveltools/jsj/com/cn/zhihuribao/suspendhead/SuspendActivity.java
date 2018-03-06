package gctraveltools.jsj.com.cn.zhihuribao.suspendhead;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import gctraveltools.jsj.com.cn.zhihuribao.R;

public class SuspendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend);
        ArrayList<SuspendBean> data = arrayList();
        Collections.sort(data, new Comparator<SuspendBean>() {
            @Override
            public int compare(SuspendBean o1, SuspendBean o2) {
                return o1.letter.compareTo(o2.letter);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SuSpendDecoration(data));

        recyclerView.setAdapter(new SuspendHeadAdapter(data));
    }


    private ArrayList<SuspendBean> arrayList() {
        ArrayList<SuspendBean> data = new ArrayList<SuspendBean>();
        for (int i = 0; i < 100; i++) {
            SuspendBean suspend = new SuspendBean();
            switch (i % 10) {
                case 0:
                    suspend.letter = "A";
                    break;
                case 1:
                    suspend.letter = "J";
                    break;
                case 2:
                    suspend.letter = "L";
                    break;
                case 3:
                    suspend.letter = "H";
                    break;
                case 4:
                    suspend.letter = "G";
                    break;
                case 5:
                    suspend.letter = "F";
                    break;
                case 6:
                    suspend.letter = "E";
                    break;
                case 7:
                    suspend.letter = "D";
                    break;
                case 8:
                    suspend.letter = "C";
                    break;
                case 9:
                    suspend.letter = "B";
                    break;
                default:
                    suspend.letter = "J";
                    break;
            }
            suspend.name = "条目内容" + i;
            data.add(suspend);
        }
        return data;
    }
}
