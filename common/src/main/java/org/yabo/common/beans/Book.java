package org.yabo.common.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Serializable {

    public enum Status {
        UNPAID("未支付"), PAID("已支付");
        String label;

        Status(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    private Long id;
    private String name;
    private String isbn;
    private Status status;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", status=" + status +
                '}';
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.name="a|b";
        Book b2=new Book();
        b2.name="b|c";
        Book b3=new Book();
        b3.name="d|e";
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);


        System.out.println(Arrays.toString(b1.name.split("\\|")));

    }
}
