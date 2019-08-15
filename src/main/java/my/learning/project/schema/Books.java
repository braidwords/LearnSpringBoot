package my.learning.project.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Books implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "Book ID")
    private Integer id;

    @ApiModelProperty(value = "Book Name")
    private String name;

    @ApiModelProperty(value = "Number of copies")
    private Integer noOfCopies;

    @ApiModelProperty(value = "Users to whom books are issued")
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
