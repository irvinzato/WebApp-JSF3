package org.rivera.webapp.jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.rivera.webapp.jsf3.entities.Categoria;

import java.util.List;

@RequestScoped
public class CategoriaRepositoryImp implements CrudRepository<Categoria>{

  @Inject
  private EntityManager em;

  @Override
  public List<Categoria> toList() {
    return em.createQuery("FROM Categoria", Categoria.class)
            .getResultList();
  }

  @Override
  public Categoria byId(Long id) {
    return em.find(Categoria.class, id);
  }

  @Override
  public void save(Categoria categoria) {
    if( categoria.getId() != null && categoria.getId() > 0 ) {
      em.merge(categoria);
    } else {
      em.persist(categoria);
    }
  }

  @Override
  public void delete(Long id) {
    em.remove(byId(id));
  }
}
