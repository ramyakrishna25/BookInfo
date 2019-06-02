package com.nytimes.booksinfo.pojos;

public class BookDb {


    private String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getAmazon_product_url() {
        return amazon_product_url;
    }

    public void setAmazon_product_url(String amazon_product_url) {
        this.amazon_product_url = amazon_product_url;
    }

    private String description;
    private String title;
    private String author;
    private String contributor;
    private String book_image;
    private String amazon_product_url;

}
