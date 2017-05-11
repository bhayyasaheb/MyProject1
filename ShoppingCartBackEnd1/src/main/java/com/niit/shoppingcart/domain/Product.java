/*package com.niit.shoppingcart.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Entity
@Component
@Table(name="Product1")
public class Product {

	// private properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please Enter the Product Name!")
	private String name;
	
	private String code;
	
	@NotBlank(message="Please Enter the Brand Name!")
	private String brand;
	
	//@JsonIgnore
	@NotBlank(message="Please Enter the Description for Product!")
	private String description;
	
	@Column(name="unit_price")
	@Min(value=1, message="The Price can not be less than 1!")
	private double unitPrice;
	
	private int quantity;
	
	@Column(name="is_active")
	private boolean active;
	
	@Column(name="category_id")
	//@JsonIgnore
	private String category_Id;
	
	@Column(name="supplier_id")
	//@JsonIgnore
	private String supplier_Id;
	
	private int purchases;
	
	private int views;
	
	@Transient
	private MultipartFile file;
	
	
	@ManyToOne
	@JoinColumn(name="category_Id", updatable=false, insertable=false, nullable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id", updatable=false, insertable=false, nullable=false)
	private Supplier supplier;
	
	// default constructor
	public Product(){
		this.code = "SBK" +UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	
	// setter and getter methods


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	// toString for debugging

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}
		
	
}*/












package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Table(name="Product")
public class Product {

	@Id
	private String id;

	private String name;

	private String description;

	@Column(name = "price") // if the name of field in db and property name in
							// Domain Object is different
	private double price;
	
	private int quantity;
	
	private String category_id;

	private String supplier_id;
	
	@Transient
	private MultipartFile image;
	
	@ManyToOne
	@JoinColumn(name="category_id", updatable=false, insertable=false, nullable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id", updatable=false, insertable=false, nullable=false)
	// @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
	// @JoinColumn(name="supplier_id")
	private Supplier supplier;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
