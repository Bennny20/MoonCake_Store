/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phientq.utils;

import java.util.List;
import phientq.dto.ProductDTO;

/**
 *
 * @author Phước Hà
 */
public class ProductUtils {
    
    public boolean checkExistInList(List<ProductDTO> pro , String id){
        for (int i = 0; i < pro.size(); i++) {
            if(pro.get(i).getProductID().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public int getProQuantity(List<ProductDTO> pro, String id){
        for (int i = 0; i < pro.size(); i++) {
            if(pro.get(i).getProductID().equals(id)){
                return pro.get(i).getQuantity();
            }
        }
        return 1;
    }
    
    public void updateProQuantity(List<ProductDTO> pro, String id,int newQuantity){
        for (int i = 0; i < pro.size(); i++) {
            if(pro.get(i).getProductID().equals(id)){
                pro.get(i).setQuantity(newQuantity);
            }
        }
    }
    
    public boolean deleteProduct(List<ProductDTO> pro, String id){
        for (int i = 0; i < pro.size(); i++) {
            if(pro.get(i).getProductID().equals(id)){
                pro.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean updateProduct(List<ProductDTO> pro, String id,int quantity){
        for (int i = 0; i < pro.size(); i++) {
            if(pro.get(i).getProductID().equals(id)){
                pro.get(i).setQuantity(quantity);
                return true;
            }
        }
        return false;
    }
    
    public float totalPriceProduct(List<ProductDTO> pro ){
        float productPrice = 0;
        for (int i = 0; i < pro.size(); i++) {
            productPrice += pro.get(i).getQuantity() * pro.get(i).getPrice();
        }
        return productPrice;
    }
    
    
        
    public String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
        return sb.toString();
    }
    
    public String getAutoNumber(int n){
        // chose a Character random from this String
        String number = "0123456789";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0 ; i < n; i++){
            // generate a random number between  0 to 9 
            int index = (int) (number.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(number.charAt(index));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ProductUtils utils = new ProductUtils();
        String n = utils.getAutoNumber(10) ;
        System.out.println(n);
    }
}
