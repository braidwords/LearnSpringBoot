package my.learning.project.schema;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Books implements Serializable {

    private Integer id;

    private String name;

    private Integer noOfCopies;

    private Set<Integer> users = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(Integer noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public Set<Integer> getUsers() {
        return users;
    }

    public void setUsers(Set<Integer> users) {
        this.users = users;
    }
}
