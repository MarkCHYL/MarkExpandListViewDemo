package com.mark.view.markexpandlistviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mark.view.markexpandlistviewdemo.R;
import com.mark.view.markexpandlistviewdemo.bean.EXGroupBean;
import com.mark.view.markexpandlistviewdemo.bean.EXItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：MarkExpandListViewDemo
 * 类描述：ExpandListVie的适配器
 * Created by mark on 2018/4/9 01:24
 * 修改人：mark
 * 修改时间：2018/4/9 01:24
 * 修改备注：
 */
public class MarkExpandListViewAdapter extends BaseExpandableListAdapter {
    private List<EXGroupBean> gData = new ArrayList<>();
    private ArrayList<ArrayList<EXItemBean>> childData = new ArrayList<ArrayList<EXItemBean>>();
    private Context mContext;

    public MarkExpandListViewAdapter(Context mContext,List<EXGroupBean> gData,
                                     ArrayList<ArrayList<EXItemBean>> childData)
    {
        this.gData = gData;
        this.childData = childData;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup holderGroup = null;
        if (convertView == null && holderGroup == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_ex_group_item, parent, false);
            holderGroup = new ViewHolderGroup();
            holderGroup.tvGroupName = (TextView) convertView.findViewById(R.id.tv_group_name);
            holderGroup.ivIsselected = (ImageView)convertView.findViewById(R.id.iv_isselected);
            convertView.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup) convertView.getTag();
        }
        holderGroup.tvGroupName.setText(gData
                .get(groupPosition)
                .getgName());
        if (isExpanded){
            holderGroup.ivIsselected.setImageResource(R.mipmap.arrow_up_shop1);
        }else {
            holderGroup.ivIsselected.setImageResource(R.mipmap.arrow_down_shop1);
        }
        return convertView;
    }

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChildItem holderChildItem = null;
        if (convertView == null && holderChildItem == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_ex_child_item, parent, false);
            holderChildItem = new ViewHolderChildItem();
            holderChildItem.tvName = (TextView)convertView.findViewById(R.id.tv_name);
            holderChildItem.imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
            convertView.setTag(holderChildItem);
        } else {
            holderChildItem = (ViewHolderChildItem) convertView.getTag();
        }
        holderChildItem.imgIcon.setImageResource(childData
                .get(groupPosition)
                .get(childPosition)
                .getImgId());
        holderChildItem.tvName.setText(childData
                .get(groupPosition)
                .get(childPosition)
                .getName());
        return convertView;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolderGroup {
        private TextView tvGroupName;
        private ImageView ivIsselected;
    }

    private static class ViewHolderChildItem {
        private ImageView imgIcon;
        private TextView tvName;
    }
}
