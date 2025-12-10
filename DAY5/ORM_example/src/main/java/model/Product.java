package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int Id;
    private String name;

    public Product (){
    
    }
    

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, String name) {
        Id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Product [Id=" + Id + ", name=" + name + "]";
    }
    

}
