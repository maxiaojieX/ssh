package com.ma.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "productType")
    private Set<Product> productSet;

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
