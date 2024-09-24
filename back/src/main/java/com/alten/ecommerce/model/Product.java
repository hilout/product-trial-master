
package com.alten.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private double price;
    private int quantity;
    private String internalReference;
    private int shellId;
    private String inventoryStatus;
    private int rating;
    private long createdAt;
    private long updatedAt;

    // Getters and Setters

    public void copy(Product product) {
        this.code = product.code;
        this.name = product.name;
        this.description = product.description;
        this.image = product.image;
        this.category = product.category;
        this.price = product.price;
        this.quantity = product.quantity;
        this.internalReference = product.internalReference;
        this.shellId = product.shellId;
        this.inventoryStatus = product.inventoryStatus;
        this.rating = product.rating;
        this.createdAt = product.createdAt;
        this.updatedAt = product.updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getInternalReference() {
        return internalReference;
    }

    public int getShellId() {
        return shellId;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public int getRating() {
        return rating;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", internalReference='" + internalReference + '\'' +
                ", shellId=" + shellId +
                ", inventoryStatus='" + inventoryStatus + '\'' +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && quantity == product.quantity && shellId == product.shellId && rating == product.rating && createdAt == product.createdAt && updatedAt == product.updatedAt && Objects.equals(id, product.id) && Objects.equals(code, product.code) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(image, product.image) && Objects.equals(category, product.category) && Objects.equals(internalReference, product.internalReference) && Objects.equals(inventoryStatus, product.inventoryStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description, image, category, price, quantity, internalReference, shellId, inventoryStatus, rating, createdAt, updatedAt);
    }
}
