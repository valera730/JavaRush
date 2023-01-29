package model;

public class Order {
    private int id;         //id заказа
    private int buyerId;    //id покупателя
    private int sellerId;   //id продавца
    private long[] books;   //список id проданных книг

    public Order(int id, int sellerId, int buyerId, long[] books) {
        this.id = id;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public long[] getBooks() {
        return books;
    }

    public void setBooks(long[] books) {
        this.books = books;
    }
}