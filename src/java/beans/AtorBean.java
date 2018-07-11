package beans;

import entities.Ator;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.AtorService;


@Named
@ViewScoped
public class AtorBean implements Serializable {
    @EJB
    private AtorService atorService;

    @Inject
    private RequestParameters parameters;

    private Ator value;
    private boolean consultar;
    private List<Ator> atoresFiltrados;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Ator();
        } else {
            value = atorService.find(Long.valueOf(id));
        }
    }

    public void inserir() {
        reset();
        consultar = false;
    }

    public void consultar(Ator value) {
        setValue(value);
        consultar = true;
    }

    public void reset() {
        value = new Ator();
    }

    public Ator getValue() {
        return value;
    }

    public void setValue(Ator value) {
        this.value = value;
    }
    
    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }
    
    public List<Ator> getAll() {
        return atorService.getAll();
    }

    public List<Ator> getAtoresFiltrados() {
        return atoresFiltrados;
    }
    
    public void setAtoresFiltrados(List<Ator> AtoresFiltrados) {
        this.atoresFiltrados = AtoresFiltrados;
    }

    public String save() {
        atorService.create(value);
        reset();
        return null;
    }

    public String update() {
        atorService.edit(value);
        return null;
    }

    public String delete() {
        atorService.remove(value);
        consultar = false;
        return null;
    }
    
}