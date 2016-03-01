package java.inventory;

public class Product {

    private int id;
    private String name;
    private Category category;
    private String description;
    private double price;

    public Product(int id, String name, Category category, String description, double price) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
    public Product(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Product p) {
        if (this.id == p.getId()) {
            return true;
        }
        return false;

    }

}