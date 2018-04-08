package com.mark.view.markexpandlistviewdemo.bean;

/**
 * 项目名称：MarkExpandListViewDemo
 * 类描述：子item的实体类
 * Created by mark on 2018/4/9 01:17
 * 修改人：mark
 * 修改时间：2018/4/9 01:17
 * 修改备注：
 */
public class EXItemBean {
    private int imgId;
    private String name;

    public EXItemBean(int imgId, String name) {
        this.imgId = imgId;
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
