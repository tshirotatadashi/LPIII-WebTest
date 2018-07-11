package beans;

import entities.Categoria;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.CategoriaService;

/**
 *
 * @author Thiago
 */
@Named
@ViewScoped
public class CategoriaBean implements Serializable {

    @EJB
    private CategoriaService categoriaService;

    @Inject
    private RequestParameters parameters;

    private Categoria value;
    private boolean consultar;
    private List<Categoria> categoriasFiltradas;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Categoria();
        } else {
            value = categoriaService.find(Long.valueOf(id));
        }
    }

    public SelectItem[] getTipos(boolean filtrar) {
        SelectItem[] items;
        int length = Categoria.Tipo.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }

        for (Categoria.Tipo tipo : Categoria.Tipo.values()) {
            items[n++] = new SelectItem(tipo, tipo.getLabel());
        }

        return items;
    }

    public void inserir() {
        reset();
        consultar = false;
    }

    public void consultar(Categoria value) {
        setValue(value);
        consultar = true;
    }

    public void reset() {
        value = new Categoria();
    }

    public Categoria getValue() {
        return value;
    }

    public void setValue(Categoria value) {
        this.value = value;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Categoria> getCategoriasFiltradas() {
        return categoriasFiltradas;
    }

    public void setCategoriasFiltradas(List<Categoria> categoriasFiltradas) {
        this.categoriasFiltradas = categoriasFiltradas;
    }

    public List<Categoria> getAll() {
        return categoriaService.getAll();
    }

    public String save() {
        categoriaService.create(value);
        reset();
        return null;
    }

    public String update() {
        categoriaService.edit(value);
        return null;
    }

    public String delete() {
        categoriaService.remove(value);
        consultar = false;
        return null;
    }

}
