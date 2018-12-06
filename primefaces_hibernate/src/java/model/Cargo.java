/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RKOrtega
 */
@Entity
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByCargoId", query = "SELECT c FROM Cargo c WHERE c.cargoId = :cargoId")
    , @NamedQuery(name = "Cargo.findByCargoDescripcion", query = "SELECT c FROM Cargo c WHERE c.cargoDescripcion = :cargoDescripcion")
    , @NamedQuery(name = "Cargo.findByCargoFechaCreacion", query = "SELECT c FROM Cargo c WHERE c.cargoFechaCreacion = :cargoFechaCreacion")
    , @NamedQuery(name = "Cargo.findByCargoFechaModificacion", query = "SELECT c FROM Cargo c WHERE c.cargoFechaModificacion = :cargoFechaModificacion")
    , @NamedQuery(name = "Cargo.findByCargoEstado", query = "SELECT c FROM Cargo c WHERE c.cargoEstado = :cargoEstado")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargoId")
    private Integer cargoId;
    @Size(max = 100)
    @Column(name = "cargoDescripcion")
    private String cargoDescripcion;
    @Column(name = "cargoFechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cargoFechaCreacion;
    @Column(name = "cargoFechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cargoFechaModificacion;
    @Size(max = 1)
    @Column(name = "cargoEstado")
    private String cargoEstado;
    @OneToMany(mappedBy = "cargoId")
    private Collection<Empleado> empleadoCollection;

    public Cargo() {
    }

    public Cargo(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoDescripcion() {
        return cargoDescripcion;
    }

    public void setCargoDescripcion(String cargoDescripcion) {
        this.cargoDescripcion = cargoDescripcion;
    }

    public Date getCargoFechaCreacion() {
        return cargoFechaCreacion;
    }

    public void setCargoFechaCreacion(Date cargoFechaCreacion) {
        this.cargoFechaCreacion = cargoFechaCreacion;
    }

    public Date getCargoFechaModificacion() {
        return cargoFechaModificacion;
    }

    public void setCargoFechaModificacion(Date cargoFechaModificacion) {
        this.cargoFechaModificacion = cargoFechaModificacion;
    }

    public String getCargoEstado() {
        return cargoEstado;
    }

    public void setCargoEstado(String cargoEstado) {
        this.cargoEstado = cargoEstado;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoId != null ? cargoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargoId == null && other.cargoId != null) || (this.cargoId != null && !this.cargoId.equals(other.cargoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cargo[ cargoId=" + cargoId + " ]";
    }
    
}
