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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByEmpresaId", query = "SELECT e FROM Empresa e WHERE e.empresaId = :empresaId")
    , @NamedQuery(name = "Empresa.findByEmpresaRazonSocial", query = "SELECT e FROM Empresa e WHERE e.empresaRazonSocial = :empresaRazonSocial")
    , @NamedQuery(name = "Empresa.findByEmpresaRuc", query = "SELECT e FROM Empresa e WHERE e.empresaRuc = :empresaRuc")
    , @NamedQuery(name = "Empresa.findByEmpresaDireccion", query = "SELECT e FROM Empresa e WHERE e.empresaDireccion = :empresaDireccion")
    , @NamedQuery(name = "Empresa.findByEmpresaTelefono", query = "SELECT e FROM Empresa e WHERE e.empresaTelefono = :empresaTelefono")
    , @NamedQuery(name = "Empresa.findByEmpresaCorreo", query = "SELECT e FROM Empresa e WHERE e.empresaCorreo = :empresaCorreo")
    , @NamedQuery(name = "Empresa.findByEmpresaFechaCreacion", query = "SELECT e FROM Empresa e WHERE e.empresaFechaCreacion = :empresaFechaCreacion")
    , @NamedQuery(name = "Empresa.findByEmpresaFechaModificacion", query = "SELECT e FROM Empresa e WHERE e.empresaFechaModificacion = :empresaFechaModificacion")
    , @NamedQuery(name = "Empresa.findByEmpresaEstado", query = "SELECT e FROM Empresa e WHERE e.empresaEstado = :empresaEstado")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresaId")
    private Integer empresaId;
    @Size(max = 250)
    @Column(name = "empresaRazonSocial")
    private String empresaRazonSocial;
    @Size(max = 15)
    @Column(name = "empresaRuc")
    private String empresaRuc;
    @Size(max = 250)
    @Column(name = "empresaDireccion")
    private String empresaDireccion;
    @Size(max = 15)
    @Column(name = "empresaTelefono")
    private String empresaTelefono;
    @Size(max = 200)
    @Column(name = "empresaCorreo")
    private String empresaCorreo;
    @Column(name = "empresaFechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empresaFechaCreacion;
    @Column(name = "empresaFechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empresaFechaModificacion;
    @Column(name = "empresaEstado")
    private Character empresaEstado;
    @OneToMany(mappedBy = "empresaId")
    private Collection<Empleado> empleadoCollection;

    public Empresa() {
    }

    public Empresa(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getEmpresaRazonSocial() {
        return empresaRazonSocial;
    }

    public void setEmpresaRazonSocial(String empresaRazonSocial) {
        this.empresaRazonSocial = empresaRazonSocial;
    }

    public String getEmpresaRuc() {
        return empresaRuc;
    }

    public void setEmpresaRuc(String empresaRuc) {
        this.empresaRuc = empresaRuc;
    }

    public String getEmpresaDireccion() {
        return empresaDireccion;
    }

    public void setEmpresaDireccion(String empresaDireccion) {
        this.empresaDireccion = empresaDireccion;
    }

    public String getEmpresaTelefono() {
        return empresaTelefono;
    }

    public void setEmpresaTelefono(String empresaTelefono) {
        this.empresaTelefono = empresaTelefono;
    }

    public String getEmpresaCorreo() {
        return empresaCorreo;
    }

    public void setEmpresaCorreo(String empresaCorreo) {
        this.empresaCorreo = empresaCorreo;
    }

    public Date getEmpresaFechaCreacion() {
        return empresaFechaCreacion;
    }

    public void setEmpresaFechaCreacion(Date empresaFechaCreacion) {
        this.empresaFechaCreacion = empresaFechaCreacion;
    }

    public Date getEmpresaFechaModificacion() {
        return empresaFechaModificacion;
    }

    public void setEmpresaFechaModificacion(Date empresaFechaModificacion) {
        this.empresaFechaModificacion = empresaFechaModificacion;
    }

    public Character getEmpresaEstado() {
        return empresaEstado;
    }

    public void setEmpresaEstado(Character empresaEstado) {
        this.empresaEstado = empresaEstado;
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
        hash += (empresaId != null ? empresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaId == null && other.empresaId != null) || (this.empresaId != null && !this.empresaId.equals(other.empresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empresa[ empresaId=" + empresaId + " ]";
    }
    
}
