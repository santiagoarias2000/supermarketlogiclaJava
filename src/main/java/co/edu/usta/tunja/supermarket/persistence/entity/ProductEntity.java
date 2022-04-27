package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private Integer id;

    @Column(name="product_name", length = 45, nullable = false)
    private String name;

    @Column(name="fk_id_product_type")
    private Integer fkIdProductType;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_product_type", referencedColumnName="id_product_type", insertable = false, updatable = false, nullable = false)
    private ProductTypeEntity productTypeEntity;

    

    public Integer getId() {
        return id;
    }

    public Integer getFkIdProductType() {
        return fkIdProductType;
    }

    public void setFkIdProductType(Integer fkIdProductType) {
        this.fkIdProductType = fkIdProductType;
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

    public ProductTypeEntity getProductTypeEntity() {
        return productTypeEntity;
    }

    public void setProductTypeEntity(ProductTypeEntity productTypeEntity) {
        this.productTypeEntity = productTypeEntity;
    }

    

    @Override
    public String toString() {
        return "ProductEntity{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.productTypeEntity);
       
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
        final ProductEntity other = (ProductEntity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.productTypeEntity, other.productTypeEntity)) {
            return false;
        }
       
        return true;
    }

}
