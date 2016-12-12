package com.example.kingwen.quickbox.Beans;

/**
 * Created by kingwen on 2016/12/12.
 * javaBean  主页面中每个商店的信息
 */
public class Shop {
    /**
     * 主页面商店名称
     */
    private String name;

    /**
     * 每个商店的图片的id
     */
    private int imgid;

    public Shop(String name, int imgid) {
        this.name = name;
        this.imgid = imgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
