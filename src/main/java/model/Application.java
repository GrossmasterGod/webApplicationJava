package model;

public class Application {
    private int id;
    private int clientId;
    private int quantity;
    private int category;
    private int staying;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStaying() {
        return staying;
    }

    public void setStaying(int staying) {
        this.staying = staying;
    }
}
