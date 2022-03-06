package Model;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stockAmount;
    private Long publishDateInMillis;

    public Product(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ("\nProduct --> "  +
                " id= " + id + " | " +
                "name= " + name +" | "  +
                "description= " + description +" | " +
                "price= " + price  + " | " +
                "stockAmount= " + stockAmount);
    }


    public void setPublishDateInMillis(Long publishDateInMillis) {
        this.publishDateInMillis = publishDateInMillis;
    }

    public long getPublishDateInMillis() {
        return publishDateInMillis;
    }

}

