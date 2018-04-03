package hello.model;

import hello.dto.Brand;
import hello.dto.Category;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private double weight;
    private double height;
    private double width;
    private double depth;
    private String colour;
    private double unitPrice;
    @OneToOne
    private CategoryEntity categories;
    @OneToOne
    private BrandEntity brand;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public CategoryEntity getCategories() {
        return categories;
    }

    public void setCategories(CategoryEntity categories) {
        this.categories = categories;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
