package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t"),
    @NamedQuery(name = "Time.findByIdTime", query = "SELECT t FROM Time t WHERE t.idTime = :idTime"),
    @NamedQuery(name = "Time.findByNome", query = "SELECT t FROM Time t WHERE t.nome = :nome"),
    @NamedQuery(name = "Time.findBySigla", query = "SELECT t FROM Time t WHERE t.sigla = :sigla")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_time")
    private Integer idTime;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(mappedBy = "idTime")
    private Collection<Tecnico> tecnicoCollection;
    @JoinColumn(name = "id_estadio", referencedColumnName = "id_estadio")
    @ManyToOne
    private Estadio idEstadio;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPais;
    @OneToMany(mappedBy = "idTime1")
    private Collection<Jogo> jogoCollection;
    @OneToMany(mappedBy = "idTime2")
    private Collection<Jogo> jogoCollection1;
    @OneToMany(mappedBy = "idTime")
    private Collection<Jogador> jogadorCollection;

    public Time() {
    }

    public Time(Integer idTime) {
        this.idTime = idTime;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @XmlTransient
    public Collection<Tecnico> getTecnicoCollection() {
        return tecnicoCollection;
    }

    public void setTecnicoCollection(Collection<Tecnico> tecnicoCollection) {
        this.tecnicoCollection = tecnicoCollection;
    }

    public Estadio getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(Estadio idEstadio) {
        this.idEstadio = idEstadio;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public Collection<Jogo> getJogoCollection() {
        return jogoCollection;
    }

    public void setJogoCollection(Collection<Jogo> jogoCollection) {
        this.jogoCollection = jogoCollection;
    }

    @XmlTransient
    public Collection<Jogo> getJogoCollection1() {
        return jogoCollection1;
    }

    public void setJogoCollection1(Collection<Jogo> jogoCollection1) {
        this.jogoCollection1 = jogoCollection1;
    }

    @XmlTransient
    public Collection<Jogador> getJogadorCollection() {
        return jogadorCollection;
    }

    public void setJogadorCollection(Collection<Jogador> jogadorCollection) {
        this.jogadorCollection = jogadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTime != null ? idTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.idTime == null && other.idTime != null) || (this.idTime != null && !this.idTime.equals(other.idTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "futebol_pbd.Time[ idTime=" + idTime + " ]";
    }
    
}
