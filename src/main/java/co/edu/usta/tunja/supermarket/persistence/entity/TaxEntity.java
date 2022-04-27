package co.edu.usta.tunja.supermarket.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TAX")
public class TaxEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tax")
    private Integer id;

    @Column(name = "tax_value", length = 5, precision = 2, nullable = false)
    private Double value;

    @Column(name = "tax_name", length = 15, nullable = false)
    private String name;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(mappedBy = "taxEntity")
    private List<TaxPriceProductEntity> taxPriceProductEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<TaxPriceProductEntity> getTaxPriceProductEntityList() {
        return taxPriceProductEntityList;
    }

    public void setTaxPriceProductEntityList(List<TaxPriceProductEntity> taxPriceProductEntityList) {
        this.taxPriceProductEntityList = taxPriceProductEntityList;
    }

    @Override
    public String toString() {
        return "TaxEntity{" + "value=" + value + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.value);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.creationDate);
        hash = 29 * hash + Objects.hashCode(this.taxPriceProductEntityList);
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
        final TaxEntity other = (TaxEntity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.creationDate, other.creationDate)) {
            return false;
        }
        if (!Objects.equals(this.taxPriceProductEntityList, other.taxPriceProductEntityList)) {
            return false;
        }
        return true;
    }
    
}
