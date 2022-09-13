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

  @Override
  public List<Producto> toList() {
    return em.createQuery("FROM Producto", Producto.class)
            .getResultList();
  }

  @Override
  public Producto byId(Long id) {
    return em.find(Producto.class, id);
  }

}
