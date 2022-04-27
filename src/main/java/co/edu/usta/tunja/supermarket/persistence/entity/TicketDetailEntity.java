package co.edu.usta.tunja.supermarket.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TICKET_DETAIL")
public class TicketDetailEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket_detail")
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "devolution_request", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date devolutionRequest;

    @Column(name = "devolution_approved", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date devolutionApproved;

    @Column(name = "description", length = 45, nullable = false)
    private String description;

    @Column(name="fk_id_person_administrator")
    private Integer fkIdPersonAdm;
    
    @Column(name="fk_id_ticket")
    private Integer fkIdTicket;
    
    @Column(name="fk_id_tax_price_product")
    private Integer fkIdTaxPrice_product;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_person_administrator", insertable = false, updatable = false)
    private PersonEntity personAdminEntity;

    @ManyToOne
    @JoinColumn(name = "fk_id_ticket", insertable = false, updatable = false)
    private TicketEntity ticketEntity;

    @ManyToOne
    @JoinColumn(name = "fk_id_tax_price_product", insertable = false, updatable = false)
    private TaxPriceProductEntity taxPriceProductEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDevolutionRequest() {
        return devolutionRequest;
    }

    public void setDevolutionRequest(Date devolutionRequest) {
        this.devolutionRequest = devolutionRequest;
    }

    public Date getDevolutionApproved() {
        return devolutionApproved;
    }

    public void setDevolutionApproved(Date devolutionApproved) {
        this.devolutionApproved = devolutionApproved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonEntity getPersonAdminEntity() {
        return personAdminEntity;
    }

    public void setPersonAdminEntity(PersonEntity personAdminEntity) {
        this.personAdminEntity = personAdminEntity;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }

    public TaxPriceProductEntity getTaxPriceProductEntity() {
        return taxPriceProductEntity;
    }

    public void setTaxPriceProductEntity(TaxPriceProductEntity taxPriceProductEntity) {
        this.taxPriceProductEntity = taxPriceProductEntity;
    }

    public Integer getFkIdPersonAdm() {
        return fkIdPersonAdm;
    }

    public void setFkIdPersonAdm(Integer fkIdPersonAdm) {
        this.fkIdPersonAdm = fkIdPersonAdm;
    }

    public Integer getFkIdTicket() {
        return fkIdTicket;
    }

    public void setFkIdTicket(Integer fkIdTicket) {
        this.fkIdTicket = fkIdTicket;
    }

    public Integer getFkIdTaxPrice_product() {
        return fkIdTaxPrice_product;
    }

    public void setFkIdTaxPrice_product(Integer fkIdTaxPrice_product) {
        this.fkIdTaxPrice_product = fkIdTaxPrice_product;
    }

    
    
    @Override
    public String toString() {
        String prdName = taxPriceProductEntity.getPriceProductEntity().getProductEntity().getName();
        Double price = taxPriceProductEntity.getPriceProductEntity().getSalePrice();
        Double tax = taxPriceProductEntity.getTaxEntity().getValue();
        Double total = amount*(price*(1+tax));
        return "Name Product: " + prdName+ " cantidad: " + amount+ " Precio: " + price+ " Tax: " + tax
                + " Total: " + total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.amount);
        hash = 29 * hash + Objects.hashCode(this.devolutionRequest);
        hash = 29 * hash + Objects.hashCode(this.devolutionApproved);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.personAdminEntity);
        hash = 29 * hash + Objects.hashCode(this.ticketEntity);
        hash = 29 * hash + Objects.hashCode(this.taxPriceProductEntity);
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
        final TicketDetailEntity other = (TicketDetailEntity) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.devolutionRequest, other.devolutionRequest)) {
            return false;
        }
        if (!Objects.equals(this.devolutionApproved, other.devolutionApproved)) {
            return false;
        }
        if (!Objects.equals(this.personAdminEntity, other.personAdminEntity)) {
            return false;
        }
        if (!Objects.equals(this.ticketEntity, other.ticketEntity)) {
            return false;
        }
        if (!Objects.equals(this.taxPriceProductEntity, other.taxPriceProductEntity)) {
            return false;
        }
        return true;
    }

}
