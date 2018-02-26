package com.example.clitusdmonte.hw5slideshow;

/**
 * Created by clitus dmonte on 2/23/2018.
 */

class ImageDataDAO {
    private int image;
    private String title;
    private String desc;

    public ImageDataDAO() {
    }

    public ImageDataDAO(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ImageDataDAO{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
