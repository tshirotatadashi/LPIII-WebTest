package services;

import entities.Categoria;
import javax.ejb.Stateless;

/**
 *
 * @author Thiago
 */
@Stateless
public class CategoriaService extends EntityService<Categoria> {

    public CategoriaService() {
        super(Categoria.class);
    }
    
}
