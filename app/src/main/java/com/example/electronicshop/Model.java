package com.example.electronicshop;

public class Model {
    String productheader;
    int price;
    String productdescription;
    int productimage;

    public String getWarrenty() {
        return warrenty;
    }

    public void setWarrenty(String warrenty) {
        this.warrenty = warrenty;
    }

    public String getReplacementpolicy() {
        return replacementpolicy;
    }

    public void setReplacementpolicy(String replacementpolicy) {
        this.replacementpolicy = replacementpolicy;
    }

    String warrenty;
    String replacementpolicy;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductheader() {
        return productheader;
    }

    public void setProductheader(String productheader) {
        this.productheader = productheader;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }
}
