package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TICKET")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer id;

    @Column(name = "half_payment", length = 13, precision = 2, nullable = true)
    private Double helfPayment;

    @Column(name = "ticket_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="fk_id_person_customer")
    private Integer fkIdPesonCustomer;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_person_customer", insertable = false, updatable = false, nullable = false)
    private PersonEntity personCustomerEntity;

    @Column(name="fk_id_person_cashier")
    private Integer fkIdPersonCashier;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_person_cashier", insertable = false, updatable = false, nullable = false)
    private PersonEntity personCashierEntity;

    @OneToMany(mappedBy = "ticketEntity")
    private List<TicketDetailEntity> ticketDetailEntitiesList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHelfPayment() {
        return helfPayment;
    }

    public void setHelfPayment(Double helfPayment) {
        this.helfPayment = helfPayment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PersonEntity getPersonCustomerEntity() {
        return personCustomerEntity;
    }

    public void setPersonCustomerEntity(PersonEntity personCustomerEntity) {
        this.personCustomerEntity = personCustomerEntity;
    }

    public PersonEntity getPersonCashierEntity() {
        return personCashierEntity;
    }

    public void setPersonCashierEntity(PersonEntity personCashierEntity) {
        this.personCashierEntity = personCashierEntity;
    }

    public List<TicketDetailEntity> getTicketDetailEntitiesList() {
        return ticketDetailEntitiesList;
    }

    public void setTicketDetailEntitiesList(List<TicketDetailEntity> ticketDetailEntitiesList) {
        this.ticketDetailEntitiesList = ticketDetailEntitiesList;
    }

    public Integer getFkIdPesonCustomer() {
        return fkIdPesonCustomer;
    }

    public void setFkIdPesonCustomer(Integer fkIdPesonCustomer) {
        this.fkIdPesonCustomer = fkIdPesonCustomer;
    }

    public Integer getFkIdPersonCashier() {
        return fkIdPersonCashier;
    }

    public void setFkIdPersonCashier(Integer fkIdPersonCashier) {
        this.fkIdPersonCashier = fkIdPersonCashier;
    }    

    @Override
    public String toString() {
        String nameCashier = personCashierEntity.getName()+" "+personCashierEntity.getLastName();
        String customerInfo = personCustomerEntity.getName()
                +" "+personCustomerEntity.getLastName() 
                +" DNI: "+ personCustomerEntity.getDni() ;
        return "Date: " + date + ", Cashier Name: " + nameCashier  + ", Customer info: " + customerInfo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.helfPayment);
        hash = 71 * hash + Objects.hashCode(this.date);
        hash = 71 * hash + Objects.hashCode(this.personCustomerEntity);
        hash = 71 * hash + Objects.hashCode(this.personCashierEntity);
        hash = 71 * hash + Objects.hashCode(this.ticketDetailEntitiesList);
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
        final TicketEntity other = (TicketEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.helfPayment, other.helfPayment)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.personCustomerEntity, other.personCustomerEntity)) {
            return false;
        }
        if (!Objects.equals(this.personCashierEntity, other.personCashierEntity)) {
            return false;
        }
        if (!Objects.equals(this.ticketDetailEntitiesList, other.ticketDetailEntitiesList)) {
            return false;
        }
        return true;
    }
    
}
