/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarket.persistence.ejd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author USUARIO
 */
public abstract class Abstract<T> {

    //general consult for tables, add, delete, update, list
    // T -> is a template (parameter in a class)
    private final Class<T> entidad;

    protected abstract EntityManager getAdmEntidad();

    public Abstract(Class<T> entidad) {
        this.entidad = entidad;
    }

    //Save all class with contains word entity
    public void save(T entidad) {
        getAdmEntidad().persist(entidad);
    }

    // delete data en data base
    public void delete(T entidad) {
        if (!getAdmEntidad().contains(entidad)) {
            entidad = getAdmEntidad().merge(entidad);
        }
        getAdmEntidad().remove(entidad);
    }

    // update register in the data base
    public void update(T entidad) {
        if (!getAdmEntidad().contains(entidad)) {            
            entidad = getAdmEntidad().merge(entidad);
        }
        //Get attributes of the database...
        //getAdmEntidad().getTransaction().begin();
        //Save new attributes in one array...
        getAdmEntidad().merge(entidad);
        //Save new attributes in the database...
        //getAdmEntidad().getTransaction().commit();
    }

    //Dind object in the data base
    public T search(Object id) {
        return getAdmEntidad().find(entidad, id);
    }

    //List data in the database
    public List<T> seeList() {
        CriteriaBuilder cd = getAdmEntidad().getCriteriaBuilder();
        CriteriaQuery<T> cq = cd.createQuery(entidad);
        cq.select(cq.from(entidad));
        List<T> allData = getAdmEntidad().createQuery(cq).getResultList();
        return allData;
    }

}
