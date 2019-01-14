package com.codegym.springbook.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 10 , max = 10, message = "Code phải là 10 số")
    private String code;

    @Min(0)
    private double price;

    @Min(1)
    @Max(3)
    private int status;

    @NotEmpty
    private String company;

    @Min(0)
    private int number;

    @NotEmpty
    private String description;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
    }

    public Book(@NotEmpty @Size(min = 10) String code, @Min(0) double price, @Min(1) @Max(3) int status, @NotEmpty String company, @Min(0) int number, @NotEmpty String description, Category category) {
        this.code = code;
        this.price = price;
        this.status = status;
        this.company = company;
        this.number = number;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
