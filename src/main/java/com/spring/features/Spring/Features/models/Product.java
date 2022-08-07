package com.spring.features.Spring.Features.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Cant be empty")
    @NotBlank(message = "Cant be blank")
    @Min(value = 4)
    @Max(value = 255)
    private String name;

    @Column
    @Min(value = 0)
    @Max(value = 1000)
    private Integer qtd;

    @Column
    private Date createdAt;

    public Product() {
    }

    public Product(String name, Integer qtd) {
        this.name = name;
        this.qtd = qtd;
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

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qtd=" + qtd +
                ", createAt=" + createdAt +
                '}';
    }
}
