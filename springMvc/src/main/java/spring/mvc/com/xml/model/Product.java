package spring.mvc.com.xml.model;

public class Product {

    private static final long serialVersionUID = 3626552579086276167L;
    
    private Long id;
    private String nameAr;
    private String nameEn;
    private String descriptionAr;
    private String descriptionEn;
    private Long minStockAmount;
    private Double individualPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameAr() {
		return nameAr;
	}
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getDescriptionAr() {
		return descriptionAr;
	}
	public void setDescriptionAr(String descriptionAr) {
		this.descriptionAr = descriptionAr;
	}
	public String getDescriptionEn() {
		return descriptionEn;
	}
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
	public Long getMinStockAmount() {
		return minStockAmount;
	}
	public void setMinStockAmount(Long minStockAmount) {
		this.minStockAmount = minStockAmount;
	}
	public Double getIndividualPrice() {
		return individualPrice;
	}
	public void setIndividualPrice(Double individualPrice) {
		this.individualPrice = individualPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
        }