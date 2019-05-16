package com.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "phone_book", schema = "liquibase", catalog = "")
public class Note {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Override
    public String toString(){
        return  "{note=Note(id= " + id + ", name= "+ name +", phoneNumber= "+ phoneNumber +")}";
    }


    public Note(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


}
