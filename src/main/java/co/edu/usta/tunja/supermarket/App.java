/* Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.*/
package co.edu.usta.tunja.supermarket;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import co.edu.usta.tunja.supermarket.persistence.entity.PersonEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.ProductTypeEntity;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("supermarket-PU");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            ProductTypeEntity pte = new ProductTypeEntity();
            pte.setName("Aromatizadores");
            System.out.println(pte.getName());
            transaction.commit();
                /*PersonEntity person = new PersonEntity();
                person.setName("Jhon");
                person.setLastName("Bloch");
                person.setDni("Bloch");
                person.setAddress("Bloch");
                person.setPhone("+1-33-3-23-3-3");
                entityManager.persist(pte);
                transaction.commit();
                Query q = entityManager.creteQuery("Select a from Stu s");
                List<Student> resultList = q.getResultList();
                System.out.println("num of students: "+resultList.size());
                for(Student next : resultList){
                System.out.println("next student: " + next);
                }
             */
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
            entityManager.close();
            emf.close();
        }

    }
}
