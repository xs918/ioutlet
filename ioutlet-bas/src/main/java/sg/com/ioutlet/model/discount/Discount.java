package sg.com.ioutlet.model.discount;

import java.math.BigDecimal;
import java.util.Date;

import sg.com.ioutlet.model.product.Product;

public class Discount {
  private DiscountKey key;
  private String name;
  private int quantity;
  private int discountRate;
  private BigDecimal discountAmount;
  private Date startDate;
  private Date endDate;
  private Product product;
public DiscountKey getKey() {
	return key;
}
public void setKey(DiscountKey key) {
	this.key = key;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getDiscountRate() {
	return discountRate;
}
public void setDiscountRate(int discountRate) {
	this.discountRate = discountRate;
}
public BigDecimal getDiscountAmount() {
	return discountAmount;
}
public void setDiscountAmount(BigDecimal discountAmount) {
	this.discountAmount = discountAmount;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
  
  
	

}
