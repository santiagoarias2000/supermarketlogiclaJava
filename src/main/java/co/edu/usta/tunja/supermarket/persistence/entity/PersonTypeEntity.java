package co.edu.usta.tunja.supermarket.persistence.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "PERSON_TYPE")
public class PersonTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_person_type")
    private Integer id;

    @Column(name="person_type_name", length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "personTypeEntity")
    private List<PersonPersonTypeEntity> personPersonTypeEntities;

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

    public List<PersonPersonTypeEntity> getPersonPersonTypeEntities() {
        return personPersonTypeEntities;
    }

    public void setPersonPersonTypeEntities(List<PersonPersonTypeEntity> personPersonTypeEntities) {
        this.personPersonTypeEntities = personPersonTypeEntities;
    }

    @Override
    public String toString() {
        return "PersonTypeEntity{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.personPersonTypeEntities);
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
        final PersonTypeEntity other = (PersonTypeEntity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.personPersonTypeEntities, other.personPersonTypeEntities)) {
            return false;
        }
        return true;
    }
    
}
