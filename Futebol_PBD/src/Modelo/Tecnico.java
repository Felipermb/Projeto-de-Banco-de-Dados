/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe Reis
 */
@Entity
@Table(name = "tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t"),
    @NamedQuery(name = "Tecnico.findByIdTecnico", query = "SELECT t FROM Tecnico t WHERE t.idTecnico = :idTecnico"),
    @NamedQuery(name = "Tecnico.findByNome", query = "SELECT t FROM Tecnico t WHERE t.nome = :nome"),
    @NamedQuery(name = "Tecnico.findByCpf", query = "SELECT t FROM Tecnico t WHERE t.cpf = :cpf")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tecnico")
    private Integer idTecnico;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @JoinColumn(name = "id_time", referencedColumnName = "id_time")
    @ManyToOne
    private Time idTime;

    public Tecnico() {
    }

    public Tecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Time getIdTime() {
        return idTime;
    }

    public void setIdTime(Time idTime) {
        this.idTime = idTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTecnico != null ? idTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.idTecnico == null && other.idTecnico != null) || (this.idTecnico != null && !this.idTecnico.equals(other.idTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "futebol_pbd.Tecnico[ idTecnico=" + idTecnico + " ]";
    }
    
}
