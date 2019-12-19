package com.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author krishsravs
 *
 */
@Entity
@XmlRootElement
public class Product {
	
	@Id
	@SequenceGenerator(name="PRODUCT_SEQUENCE", sequenceName="CLIENT_SEQUENCE_ID", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator="PRODUCT_SEQUENCE")	
	private long productId;
	@NotBlank
	private String productName;
	private String productCode;
	private String releaseDate;
	private int price;
	private String description;
	private double starRating;
	private String imageUrl;

	public Product(long productId, String productName, String productCode, String releaseDate, int price,
			String description, double starRating, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.releaseDate = releaseDate;
		this.price = price;
		this.description = description;
		this.starRating = starRating;
		this.imageUrl = imageUrl;
	}
	
	public Product() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public int getPrice() {
		return price;
	}

	public String getProductCode() {
		return productCode;
	}

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public double getStarRating() {
		return starRating;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}

}
