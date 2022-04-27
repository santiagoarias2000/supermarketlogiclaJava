package co.edu.usta.tunja.supermarket.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductTypeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product_type")
    private Integer id;

    @Column(name = "product_type_name", length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "productTypeEntity")
    private List<ProductEntity> productEntityList;

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

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    @Override
    public String toString() {
        return  name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.productEntityList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductTypeEntity other = (ProductTypeEntity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.productEntityList, other.productEntityList)) {
            return false;
        }
        return true;
    }

}
