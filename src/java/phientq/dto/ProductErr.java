/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phientq.dto;

import java.io.Serializable;

/**
 *
 * @author phien
 */
public class ProductErr implements Serializable{
    private String productIDLengthViolent;
    private String productIDIsExiste;
    private String productNameLengthViolent;
    private String priceLengthViolent;
    private String quantityLengthViolent;
    private String createDateLengthViolent;
    private String expirationDateLengthViolent;
    private String imageLengthViolent;
    private String statusLengthViolent;
    private String shortDescriptionLengthViolent;
    private String categoryNotChoice;

    public ProductErr() {
    }

    public String getProductIDIsExiste() {
        return productIDIsExiste;
    }

    public void setProductIDIsExiste(String productIDIsExiste) {
        this.productIDIsExiste = productIDIsExiste;
    }

    public String getProductIDLengthViolent() {
        return productIDLengthViolent;
    }

    public void setProductIDLengthViolent(String productIDLengthViolent) {
        this.productIDLengthViolent = productIDLengthViolent;
    }

    public String getProductNameLengthViolent() {
        return productNameLengthViolent;
    }

    public void setProductNameLengthViolent(String productNameLengthViolent) {
        this.productNameLengthViolent = productNameLengthViolent;
    }

    public String getPriceLengthViolent() {
        return priceLengthViolent;
    }

    public void setPriceLengthViolent(String priceLengthViolent) {
        this.priceLengthViolent = priceLengthViolent;
    }

    public String getQuantityLengthViolent() {
        return quantityLengthViolent;
    }

    public void setQuantityLengthViolent(String quantityLengthViolent) {
        this.quantityLengthViolent = quantityLengthViolent;
    }

    public String getCreateDateLengthViolent() {
        return createDateLengthViolent;
    }

    public void setCreateDateLengthViolent(String createDateLengthViolent) {
        this.createDateLengthViolent = createDateLengthViolent;
    }

    public String getExpirationDateLengthViolent() {
        return expirationDateLengthViolent;
    }

    public void setExpirationDateLengthViolent(String expirationDateLengthViolent) {
        this.expirationDateLengthViolent = expirationDateLengthViolent;
    }

    public String getImageLengthViolent() {
        return imageLengthViolent;
    }

    public void setImageLengthViolent(String imageLengthViolent) {
        this.imageLengthViolent = imageLengthViolent;
    }

    public String getStatusLengthViolent() {
        return statusLengthViolent;
    }

    public void setStatusLengthViolent(String statusLengthViolent) {
        this.statusLengthViolent = statusLengthViolent;
    }

    public String getShortDescriptionLengthViolent() {
        return shortDescriptionLengthViolent;
    }

    public void setShortDescriptionLengthViolent(String shortDescriptionLengthViolent) {
        this.shortDescriptionLengthViolent = shortDescriptionLengthViolent;
    }

    public String getCategoryNotChoice() {
        return categoryNotChoice;
    }

    public void setCategoryNotChoice(String categoryNotChoice) {
        this.categoryNotChoice = categoryNotChoice;
    }
 
}
