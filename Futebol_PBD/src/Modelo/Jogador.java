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
@Table(name = "jogador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogador.findAll", query = "SELECT j FROM Jogador j"),
    @NamedQuery(name = "Jogador.findByIdJogador", query = "SELECT j FROM Jogador j WHERE j.idJogador = :idJogador"),
    @NamedQuery(name = "Jogador.findByNome", query = "SELECT j FROM Jogador j WHERE j.nome = :nome"),
    @NamedQuery(name = "Jogador.findByCpf", query = "SELECT j FROM Jogador j WHERE j.cpf = :cpf")})
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_jogador")
    private Integer idJogador;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPais;
    @JoinColumn(name = "id_time", referencedColumnName = "id_time")
    @ManyToOne
    private Time idTime;

    public Jogador() {
    }

    public Jogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
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

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
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
        hash += (idJogador != null ? idJogador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogador)) {
            return false;
        }
        Jogador other = (Jogador) object;
        if ((this.idJogador == null && other.idJogador != null) || (this.idJogador != null && !this.idJogador.equals(other.idJogador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "futebol_pbd.Jogador[ idJogador=" + idJogador + " ]";
    }
    
}
