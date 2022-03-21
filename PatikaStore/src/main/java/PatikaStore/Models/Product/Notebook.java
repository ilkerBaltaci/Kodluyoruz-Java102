package PatikaStore.Models.Product;

import PatikaStore.Models.Brand;

import java.math.BigDecimal;

public class Notebook {
    private int id;
    private String name;
    private BigDecimal unitPrice;
    private int discountRate;
    private int stock;
    private Brand brand;
    private String ScreenSizeInch;
    private String memory;

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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getScreenSizeInch() {
        return ScreenSizeInch + "Inch";
    }

    public void setScreenSizeInch(String screenSizeInch) {
        ScreenSizeInch = screenSizeInch;
    }

    public String getMemory() {
        return memory + "GB";
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
