package com.GrowHub.Server.models;


import javax.persistence.*;

import com.GrowHub.Server.models.enums.Month;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

@Entity
@Table(name="know_hows")
public class Knowhow extends TextContent{

    @Column
    @Enumerated(value = EnumType.STRING)
    private Month month;

    //@JsonIgnoreProperties(value = "know_hows")
    @JsonBackReference(value="know_hows")
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    //CONSTRUCTOR
    public Knowhow(String date, User author, String title, String body, Month month) {
        super(date, title, body);
        this.month = month;
        this.author = author;
    }

    public Knowhow() {

    }

//    public String getMonth(){
//        List<String> months = Arrays.asList(
//                "January", "February", "March", "April", "May", "June",
//                "July", "August", "September", "October", "November", "December");
//        String[] splitDate = getDate().split("-");
//        int monthIndex = parseInt(splitDate[1]) - 1;
//        return months.get(monthIndex);
//    }


    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
