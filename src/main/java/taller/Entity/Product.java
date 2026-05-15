package taller.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

// @Entity le dice a JPA que esta clase representa una tabla en la base de datos
@Entity
@Table(name = "products")
public class Product {

    // @Id indica que este campo es la clave primaria
    // @GeneratedValue hace que el ID se genere automaticamente (1, 2, 3...)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank valida que el campo no este vacio
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    // La descripcion no tiene validacion, es opcional
    private String description;

    // @Positive valida que el precio sea mayor a 0
    @Positive(message = "El precio debe ser mayor a 0")
    private Double price;

    // @Min valida que el stock no sea negativo
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotBlank(message = "La categoria es obligatoria")
    private String category;

    // Este campo se llena automaticamente cuando se crea el producto
    private LocalDateTime createdAt;

    // @PrePersist se ejecuta justo antes de guardar en la base de datos
    @PrePersist
    public void asignarFecha() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
