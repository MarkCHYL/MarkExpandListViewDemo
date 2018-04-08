package com.mark.view.markexpandlistviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.mark.view.markexpandlistviewdemo.adapter.MarkExpandListViewAdapter;
import com.mark.view.markexpandlistviewdemo.bean.EXGroupBean;
import com.mark.view.markexpandlistviewdemo.bean.EXItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.extlist)
    ExpandableListView extlist;
    private List<EXGroupBean> gData = new ArrayList<>();
    private ArrayList<ArrayList<EXItemBean>> childData = new ArrayList<ArrayList<EXItemBean>>();
    private ArrayList<EXItemBean> exItemData = null;
    private Context mContext;
    private MarkExpandListViewAdapter markExpandListViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //去掉默认的上下箭头指示器
        extlist.setGroupIndicator(null);
        mContext = this;

        initData();
        initContent();
    }

    //数据准备
    private void initData() {
        gData.add(new EXGroupBean("大猫"));
        gData.add(new EXGroupBean("小猫"));
        gData.add(new EXGroupBean("萌猫猫"));

        //第一组
        exItemData = new ArrayList<>();
        exItemData.add(new EXItemBean(R.mipmap.catimg,"大猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"大猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"大猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"大猫"));
        childData.add(exItemData);
        //第二组
        exItemData = new ArrayList<>();
        exItemData.add(new EXItemBean(R.mipmap.catimg,"小猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"小猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"小猫"));
        childData.add(exItemData);
        //第三组
        exItemData = new ArrayList<>();
        exItemData.add(new EXItemBean(R.mipmap.catimg,"萌猫猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"萌猫猫"));
        exItemData.add(new EXItemBean(R.mipmap.catimg,"萌猫猫"));
        childData.add(exItemData);

    }

    private void initContent() {
        markExpandListViewAdapter = new MarkExpandListViewAdapter(mContext,
                gData,childData);
        extlist.setAdapter(markExpandListViewAdapter);

        extlist.setOnChildClickListener(
                new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition,
                                        long id) {
                Toast.makeText(mContext, "你点击了："
                        + childData.get(groupPosition).get(childPosition).getName(),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
