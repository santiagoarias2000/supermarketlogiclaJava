/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarket.persistence.ejd;

import co.edu.usta.tunja.supermarket.persistence.entity.ProviderEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
/**
 *
 * @author USUARIO
 */

@Stateless
public class ProviderFacade extends Abstract<ProviderEntity>{
    
    @PersistenceContext(unitName = "supermarketpu")
    private EntityManager _em;

    @Override
    protected EntityManager getAdmEntidad() {
        return this._em;
    }

    public ProviderFacade() {
    super(ProviderEntity.class);
    }
}