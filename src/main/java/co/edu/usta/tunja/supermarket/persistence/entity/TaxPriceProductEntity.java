package co.edu.usta.tunja.supermarket.persistence.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "TAX_PRICE_PRODUCT")
public class TaxPriceProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tax_price_product")
    private Integer id;

    @Column(name = "fk_id_price_product")
    private Integer fkIdPriceProduct;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_price_product", insertable = false, updatable = false, nullable = false)
    private PriceProductEntity priceProductEntity;

    @Column(name="fk_id_tax")
    private Integer fkIdTax;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_tax", insertable = false, updatable = false, nullable = false)
    private TaxEntity taxEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PriceProductEntity getPriceProductEntity() {
        return priceProductEntity;
    }

    public void setPriceProductEntity(PriceProductEntity priceProductEntity) {
        this.priceProductEntity = priceProductEntity;
    }

    public TaxEntity getTaxEntity() {
        return taxEntity;
    }

    public void setTaxEntity(TaxEntity taxEntity) {
        this.taxEntity = taxEntity;
    }

    public Integer getFkIdPriceProduct() {
        return fkIdPriceProduct;
    }

    public void setFkIdPriceProduct(Integer fkIdPriceProduct) {
        this.fkIdPriceProduct = fkIdPriceProduct;
    }

    public Integer getFkIdTax() {
        return fkIdTax;
    }

    public void setFkIdTax(Integer fkIdTax) {
        this.fkIdTax = fkIdTax;
    }

    
    
    @Override
    public String toString() {
        return "TaxPriceProductEntity{" + "id=" + id + ", priceProductEntity=" + priceProductEntity + ", taxEntity=" + taxEntity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.priceProductEntity);
        hash = 53 * hash + Objects.hashCode(this.taxEntity);
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
        final TaxPriceProductEntity other = (TaxPriceProductEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.priceProductEntity, other.priceProductEntity)) {
            return false;
        }
        if (!Objects.equals(this.taxEntity, other.taxEntity)) {
            return false;
        }
        return true;
    }
    
}
