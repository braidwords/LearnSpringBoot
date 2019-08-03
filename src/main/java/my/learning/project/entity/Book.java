package my.learning.project.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id
/*    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book() {
    }

    public Book(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
