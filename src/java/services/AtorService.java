package services;

import entities.Ator;
import javax.ejb.Stateless;

/**
 *
 * @author Thiago
 */
@Stateless
public class AtorService extends EntityService<Ator> {

    public AtorService() {
        super(Ator.class);
    }
}