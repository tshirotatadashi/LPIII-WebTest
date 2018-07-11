package converters;

import entities.Categoria;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author Thiago
 */
@FacesConverter(forClass = Categoria.class)
@Named
public class CategoriaConverter extends EntityConverter<Categoria> {
    
    public CategoriaConverter() {
        super(Categoria.class);
    }
}
