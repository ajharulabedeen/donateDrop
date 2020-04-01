/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.geocode;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author G7
 */
@Component
public class Dao_GeoCode_Impl implements Dao_GeoCode_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DivisionsEngName> getDivisions() {
        String sql = "SELECT divisions.id, divisions.name FROM divisions";
        return entityManager.createNativeQuery(sql, DivisionsEngName.class).getResultList();
    }

    @Override
    public List<DistrictsEngName> getDistricts(String divID) {
        String sql = "SELECT districts.id, districts.name FROM districts WHERE districts.division_id=" + divID;
        return entityManager.createNativeQuery(sql, DistrictsEngName.class).getResultList();
    }

    @Override
    public List<UpzillaEngName> getUpzillas(String distID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
