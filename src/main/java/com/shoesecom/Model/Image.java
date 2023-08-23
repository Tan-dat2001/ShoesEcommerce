package com.shoesecom.Model;

public class Image {
    private int image_id;
    private int product_id;
    private String image1;
    private String image2;
    private String image3;


    public Image(int image_id, int product_id, String image1, String image2, String image3) {
        this.image_id = image_id;
        this.product_id = product_id;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image_id=" + image_id +
                ", product_id=" + product_id +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                '}';
    }
}
