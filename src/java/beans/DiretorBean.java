package beans;

import entities.Diretor;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.DiretorService;

@Named
@ViewScoped
public class DiretorBean implements Serializable {
    @EJB
    private DiretorService diretorService;

    @Inject
    private RequestParameters parameters;

    private Diretor value;
    private boolean consultar;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Diretor();
        else value = diretorService.find(Long.valueOf(id));
    }
    
    public void inserir() {
        reset();
        consultar = false;
    }
    
    public void consultar(Diretor value) {
        setValue(value);
        consultar = true;
    }
    
    public void reset () {
        value = new Diretor();
    }
    
    public Diretor getValue() {
        return value;
    }

    public void setValue(Diretor value) {
        this.value = value;
    }

    public List<Diretor> getAll() {
        return diretorService.getAll();
    }
    
    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public String save() {
        diretorService.create(value);
        reset();
        return null;
    }

    public String update() {
        diretorService.edit(value);
        return null;
    }

    public String delete() {
        diretorService.remove(value);
        return null;
    }

}
