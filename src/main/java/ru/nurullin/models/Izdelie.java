package ru.nurullin.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Izdelie")
public class Izdelie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Price should be greater than 0")
    @Column(name = "price")
    private int price;

    @Column(name = "calories")
    @NotEmpty(message = "Calories should not be empty")
    private String calories;


    @Column(name = "supplier")
    private String supplier;

    @Column(name = "content")
    @NotEmpty(message = "The content field should not be empty")
    private String content;

    public Izdelie() {

    }

    public Izdelie(String name, int price, String calories, String supplier, String content) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.supplier = supplier;
        this.content = content;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int age) {
        this.price = age;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String email) {
        this.calories = email;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public @NotEmpty(message = "The content field should not be empty") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "The content field should not be empty") String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Izdelie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", calories='" + calories + '\'' +
                ", supplier='" + supplier + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}