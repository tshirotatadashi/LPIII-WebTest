package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Thiago
 */
@Entity
public class Categoria implements Serializable, PersistentEntity {

    public enum Tipo {
        Lançamento("Lançamento"), Promoção("Promoção"), Catálogo("Catálogo");

        private final String label;

        private Tipo(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valor;
    private int diasLocacao;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDiasLocacao() {
        return diasLocacao;
    }

    public void setDiasLocacao(int diasLocacao) {
        this.diasLocacao = diasLocacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    
    @Override
    public String toString() {
        return tipo.label;
    }

}
