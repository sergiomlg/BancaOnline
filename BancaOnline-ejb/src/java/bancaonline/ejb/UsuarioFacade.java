/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.ejb;

import bancaonline.entity.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "BancaOnline-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario buscarUsuarioPorDni (String dni){
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :dni");
        
        List<Usuario> result=q.getResultList();
        Usuario res = null;
        if(result.get(0) != null){
            res = result.get(0);
        }
        
        return res;
    }
    
}
