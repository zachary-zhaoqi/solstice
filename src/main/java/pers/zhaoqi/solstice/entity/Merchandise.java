package pers.zhaoqi.solstice.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Merchandise {

    @TableId
    private int merchandiseId;//商品ID
    private String productCategoriesId;//产品类别ID
    private String merchandiseBrandId;//商标ID
    private String merchandiseName;//商品名称
    private String merchandiseDetail;//商品描述
    private String merchandisePicture;//商品图片
    private String merchandiseSpecification;//包装规格
    private double merchandisePrices;//商品价格
    private boolean merchandiseIsPutaway;//是否上架
    private String createdTime;
    private String updatedTime;

    @Override
    public String toString() {
        return "Merchandise{" +
                "merchandiseId=" + merchandiseId +
                ", productCategoriesId='" + productCategoriesId + '\'' +
                ", merchandiseBrandId='" + merchandiseBrandId + '\'' +
                ", merchandiseName='" + merchandiseName + '\'' +
                ", merchandiseDetail='" + merchandiseDetail + '\'' +
                ", merchandisePicture='" + merchandisePicture + '\'' +
                ", merchandiseSpecification='" + merchandiseSpecification + '\'' +
                ", merchandisePrices=" + merchandisePrices +
                ", merchandiseIsPutaway=" + merchandiseIsPutaway +
                ", createdTime='" + createdTime + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                '}';
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getProductCategoriesId() {
        return productCategoriesId;
    }

    public void setProductCategoriesId(String productCategoriesId) {
        this.productCategoriesId = productCategoriesId;
    }

    public String getMerchandiseBrandId() {
        return merchandiseBrandId;
    }

    public void setMerchandiseBrandId(String merchandiseBrandId) {
        this.merchandiseBrandId = merchandiseBrandId;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

    public String getMerchandiseDetail() {
        return merchandiseDetail;
    }

    public void setMerchandiseDetail(String merchandiseDetail) {
        this.merchandiseDetail = merchandiseDetail;
    }

    public String getMerchandisePicture() {
        return merchandisePicture;
    }

    public void setMerchandisePicture(String merchandisePicture) {
        this.merchandisePicture = merchandisePicture;
    }

    public String getMerchandiseSpecification() {
        return merchandiseSpecification;
    }

    public void setMerchandiseSpecification(String merchandiseSpecification) {
        this.merchandiseSpecification = merchandiseSpecification;
    }

    public double getMerchandisePrices() {
        return merchandisePrices;
    }

    public void setMerchandisePrices(double merchandisePrices) {
        this.merchandisePrices = merchandisePrices;
    }

    public boolean isMerchandiseIsPutaway() {
        return merchandiseIsPutaway;
    }

    public void setMerchandiseIsPutaway(boolean merchandiseIsPutaway) {
        this.merchandiseIsPutaway = merchandiseIsPutaway;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
