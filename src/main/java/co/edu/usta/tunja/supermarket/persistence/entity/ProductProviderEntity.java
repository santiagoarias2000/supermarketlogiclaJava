package co.edu.usta.tunja.supermarket.persistence.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_PROVIDER")
public class ProductProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_provider")
    private Integer id;

    @Column(name = "bar_code", length = 45, nullable = false)
    private String bar_code;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name="fk_id_product")
    private Integer fkIdProduct;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_product", insertable = false, updatable = false, nullable = false)
    private ProductEntity productEntity;

    @Column(name="fk_id_provider")
    private Integer fkIdProvider;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_provider", insertable = false, updatable = false, nullable = false)
    private ProviderEntity providerEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ProviderEntity getProviderEntity() {
        return providerEntity;
    }

    public void setProviderEntity(ProviderEntity providerEntity) {
        this.providerEntity = providerEntity;
    }

    public Integer getFkIdProduct() {
        return fkIdProduct;
    }

    public void setFkIdProduct(Integer fkIdProduct) {
        this.fkIdProduct = fkIdProduct;
    }

    public Integer getFkIdProvider() {
        return fkIdProvider;
    }

    public void setFkIdProvider(Integer fkIdProvider) {
        this.fkIdProvider = fkIdProvider;
    }

    
    @Override
    public String toString() {
        return "ProductProviderEntity{" + "bar_code=" + bar_code + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.bar_code);
        hash = 29 * hash + Objects.hashCode(this.stock);
        hash = 29 * hash + Objects.hashCode(this.productEntity);
        hash = 29 * hash + Objects.hashCode(this.providerEntity);
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
        final ProductProviderEntity other = (ProductProviderEntity) obj;
        if (!Objects.equals(this.bar_code, other.bar_code)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.stock, other.stock)) {
            return false;
        }
        if (!Objects.equals(this.productEntity, other.productEntity)) {
            return false;
        }
        if (!Objects.equals(this.providerEntity, other.providerEntity)) {
            return false;
        }
        return true;
    }


}
