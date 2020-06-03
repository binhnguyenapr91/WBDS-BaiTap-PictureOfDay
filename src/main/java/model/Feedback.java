package model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int star;
    private String author;
    private String comment;
    private Date time;
    private int numberOfLike;

    public Feedback(int id, int star, String author, String comment, Date time, int numberOfLike) {
        this.id = id;
        this.star = star;
        this.author = author;
        this.comment = comment;
        this.time = time;
        this.numberOfLike = numberOfLike;
    }

    public Feedback() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", star=" + star +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                ", numberOfLike=" + numberOfLike +
                '}';
    }
}
