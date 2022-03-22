package PatikaStore.Models.Product;

import PatikaStore.Models.Brand;

import java.math.BigDecimal;
import java.util.UUID;

public class MobilePhone implements IProduct{
    private int Id;
    private String name;
    private BigDecimal unitPrice;
    private int discountRate;
    private int stock;
    private Brand brand;
    private String screenSizeInch;
    private String camera;
    private String memory;
    private String battery;
    private String ram;
    private String color;

    public MobilePhone(String name, BigDecimal unitPrice, int discountRate, Brand brand, String screenSizeInch, String camera, String memory, String battery, String ram, String color) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.brand = brand;
        this.screenSizeInch = screenSizeInch;
        this.camera = camera;
        this.memory = memory;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return screenSizeInch + "Inch";
    }

    public void setScreenSizeInch(String screenSizeInch) {
        screenSizeInch = screenSizeInch;
    }

    public String getMemory() {
        return memory + "GB";
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getBattery() {
        return battery + "Mah";
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRam() {
        return ram + "GB";
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
