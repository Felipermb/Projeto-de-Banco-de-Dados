/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Estadio;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe Reis
 */
@Entity
@Table(name = "jogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j"),
    @NamedQuery(name = "Jogo.findByIdJogo", query = "SELECT j FROM Jogo j WHERE j.idJogo = :idJogo"),
    @NamedQuery(name = "Jogo.findByDataJogo", query = "SELECT j FROM Jogo j WHERE j.dataJogo = :dataJogo"),
    @NamedQuery(name = "Jogo.findByPlacar", query = "SELECT j FROM Jogo j WHERE j.placar = :placar")})
public class Jogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_jogo")
    private Integer idJogo;
    @Column(name = "data_jogo")
    @Temporal(TemporalType.DATE)
    private Date dataJogo;
    @Column(name = "placar")
    private String placar;
    @JoinColumn(name = "id_estadio", referencedColumnName = "id_estadio")
    @ManyToOne
    private Estadio idEstadio;
    @JoinColumn(name = "id_time1", referencedColumnName = "id_time")
    @ManyToOne
    private Time idTime1;
    @JoinColumn(name = "id_time2", referencedColumnName = "id_time")
    @ManyToOne
    private Time idTime2;

    public Jogo() {
    }

    public Jogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public Date getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        this.dataJogo = dataJogo;
    }

    public String getPlacar() {
        return placar;
    }

    public void setPlacar(String placar) {
        this.placar = placar;
    }

    public Estadio getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(Estadio idEstadio) {
        this.idEstadio = idEstadio;
    }

    public Time getIdTime1() {
        return idTime1;
    }

    public void setIdTime1(Time idTime1) {
        this.idTime1 = idTime1;
    }

    public Time getIdTime2() {
        return idTime2;
    }

    public void setIdTime2(Time idTime2) {
        this.idTime2 = idTime2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJogo != null ? idJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.idJogo == null && other.idJogo != null) || (this.idJogo != null && !this.idJogo.equals(other.idJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "futebol_pbd.Jogo[ idJogo=" + idJogo + " ]";
    }
    
}
