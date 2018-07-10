package util;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

public class RequestParameters implements Serializable {

    private Map<String, String> params;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        params = fc.getExternalContext().getRequestParameterMap();
    }

    public String get(String param) {
        return params.get(param);
    }
}
