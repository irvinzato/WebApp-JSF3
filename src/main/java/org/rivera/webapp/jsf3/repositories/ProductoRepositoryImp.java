package org.rivera.webapp.jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.rivera.webapp.jsf3.entities.Producto;

import java.util.List;

@RequestScoped
public class ProductoRepositoryImp implements CrudRepository<Producto>{

  @Inject
  private EntityManager em;

  //Debo modificar las consultas porque necesito que de una vez traiga las categorias(De la otra manera es LAZY y estaría cerrada la session)
  @Override
  public List<Producto> toList() {
    return em.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN FETCH p.category", Producto.class)
            .getResultList();
  }

  @Override
  public Producto byId(Long id) {
    //return em.find(Producto.class, id);
    return em.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN FETCH p.category WHERE p.id=:idParam", Producto.class)
            .setParameter("idParam", id)
            .getSingleResult();
  }

  @Override
  public void save(Producto producto) {
    if( producto.getId() != null && producto.getId() > 0 ) {
      em.merge(producto);
    } else {
      em.persist(producto);
    }
  }

  @Override
  public void delete(Long id) {
    em.remove(byId(id));
  }

}
