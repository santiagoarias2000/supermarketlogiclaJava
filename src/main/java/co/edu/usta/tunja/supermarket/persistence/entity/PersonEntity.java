package co.edu.usta.tunja.supermarket.persistence.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PERSON")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_person")
    private Integer id;

    @Column(name="person_dni",length = 20, nullable = false)
    private String dni;

    @Column(name="person_name", length = 25, nullable = false)
    private String name;

    @Column(name="person_last_name", length = 45, nullable = false)
    private String lastName;

    @Column(name="person_phone",length = 45, nullable = false)
    private String phone;

    @Column(name="person_address", length = 45, nullable = false)
    private String address;

    @OneToMany(mappedBy = "personCashierEntity")
    private List<TicketEntity> ticketCashierEntityList;
    
    @OneToMany(mappedBy = "personCustomerEntity")
    private List<TicketEntity> ticketCustomerEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TicketEntity> getTicketCashierEntityList() {
        return ticketCashierEntityList;
    }

    public void setTicketCashierEntityList(List<TicketEntity> ticketCashierEntityList) {
        this.ticketCashierEntityList = ticketCashierEntityList;
    }

    public List<TicketEntity> getTicketCustomerEntityList() {
        return ticketCustomerEntityList;
    }

    public void setTicketCustomerEntityList(List<TicketEntity> ticketCustomerEntityList) {
        this.ticketCustomerEntityList = ticketCustomerEntityList;
    }

    @Override
    public String toString() {
        return  dni + " " + name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dni);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.phone);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.ticketCashierEntityList);
        hash = 29 * hash + Objects.hashCode(this.ticketCustomerEntityList);
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
        final PersonEntity other = (PersonEntity) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ticketCashierEntityList, other.ticketCashierEntityList)) {
            return false;
        }
        if (!Objects.equals(this.ticketCustomerEntityList, other.ticketCustomerEntityList)) {
            return false;
        }
        return true;
    }

    
}
