package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "estadio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadio.findAll", query = "SELECT e FROM Estadio e"),
    @NamedQuery(name = "Estadio.findByIdEstadio", query = "SELECT e FROM Estadio e WHERE e.idEstadio = :idEstadio"),
    @NamedQuery(name = "Estadio.findByNome", query = "SELECT e FROM Estadio e WHERE e.nome = :nome"),
    @NamedQuery(name = "Estadio.findByPublico", query = "SELECT e FROM Estadio e WHERE e.publico = :publico")})
public class Estadio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadio")
    private Integer idEstadio;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "publico")
    private Double publico;
    @OneToMany(mappedBy = "idEstadio")
    private Collection<Time> timeCollection;
    @OneToMany(mappedBy = "idEstadio")
    private Collection<Jogo> jogoCollection;

    public Estadio() {
    }

    public Estadio(Integer idEstadio) {
        this.idEstadio = idEstadio;
    }

    public Integer getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(Integer idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPublico() {
        return publico;
    }

    public void setPublico(Double publico) {
        this.publico = publico;
    }

    @XmlTransient
    public Collection<Time> getTimeCollection() {
        return timeCollection;
    }

    public void setTimeCollection(Collection<Time> timeCollection) {
        this.timeCollection = timeCollection;
    }

    @XmlTransient
    public Collection<Jogo> getJogoCollection() {
        return jogoCollection;
    }

    public void setJogoCollection(Collection<Jogo> jogoCollection) {
        this.jogoCollection = jogoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadio != null ? idEstadio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadio)) {
            return false;
        }
        Estadio other = (Estadio) object;
        if ((this.idEstadio == null && other.idEstadio != null) || (this.idEstadio != null && !this.idEstadio.equals(other.idEstadio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "futebol_pbd.Estadio[ idEstadio=" + idEstadio + " ]";
    }
    
}
