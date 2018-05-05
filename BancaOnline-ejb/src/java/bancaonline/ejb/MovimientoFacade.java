/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.ejb;

import bancaonline.entity.Cuenta;
import bancaonline.entity.Movimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author W10
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> {

    @PersistenceContext(unitName = "BancaOnline-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }
    
    public List<Movimiento> findByConcepto(String concepto, Cuenta idCuenta){
        Query q= em.createNamedQuery("Movimiento.findByConcepto");
        q.setParameter("concepto", concepto);
        
        List<Movimiento> lista= q.getResultList();
        if(lista == null || lista.isEmpty())
            return null;
        else
            return lista;
        
        
    }
    
}
