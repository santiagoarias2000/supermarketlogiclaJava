package co.edu.usta.tunja.supermarket.persistence.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="PERSON_PERSON_TYPE")
public class PersonPersonTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_person_person_type")
    private Integer id;

    @Column(name="fk_id_person")
    private Integer fkIdPerson;
    
    @ManyToOne
    @JoinColumn(name="fk_id_person", insertable = false,updatable = false, nullable = false)
    private PersonEntity personEntity;

    @Column(name="fk_id_person_type")
    private Integer fkIdPersonType;
    
    @ManyToOne
    @JoinColumn(name="fk_id_person_type", insertable = false,updatable = false, nullable = false)
    private PersonTypeEntity personTypeEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public PersonTypeEntity getPersonTypeEntity() {
        return personTypeEntity;
    }

    public void setPersonTypeEntity(PersonTypeEntity personTypeEntity) {
        this.personTypeEntity = personTypeEntity;
    }

    public Integer getFkIdPerson() {
        return fkIdPerson;
    }

    public void setFkIdPerson(Integer fkIdPerson) {
        this.fkIdPerson = fkIdPerson;
    }

    public Integer getFkIdPersonType() {
        return fkIdPersonType;
    }

    public void setFkIdPersonType(Integer fkIdPersonType) {
        this.fkIdPersonType = fkIdPersonType;
    }

    
    @Override
    public String toString() {
        return "PersonPersonTypeEntity{" + "id=" + id + ", personEntity=" + personEntity + ", personTypeEntity=" + personTypeEntity + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.personEntity);
        hash = 53 * hash + Objects.hashCode(this.personTypeEntity);
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
        final PersonPersonTypeEntity other = (PersonPersonTypeEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.personEntity, other.personEntity)) {
            return false;
        }
        if (!Objects.equals(this.personTypeEntity, other.personTypeEntity)) {
            return false;
        }
        return true;
    }

}
