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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpleadoId", query = "SELECT e FROM Empleado e WHERE e.empleadoId = :empleadoId")
    , @NamedQuery(name = "Empleado.findByEmpleadoPrimerNombre", query = "SELECT e FROM Empleado e WHERE e.empleadoPrimerNombre = :empleadoPrimerNombre")
    , @NamedQuery(name = "Empleado.findByEmpleadoSegundoNombre", query = "SELECT e FROM Empleado e WHERE e.empleadoSegundoNombre = :empleadoSegundoNombre")
    , @NamedQuery(name = "Empleado.findByEmpleadoPrimerApellido", query = "SELECT e FROM Empleado e WHERE e.empleadoPrimerApellido = :empleadoPrimerApellido")
    , @NamedQuery(name = "Empleado.findByEmpleadoSegundoApellido", query = "SELECT e FROM Empleado e WHERE e.empleadoSegundoApellido = :empleadoSegundoApellido")
    , @NamedQuery(name = "Empleado.findByEmpleadoTipoDni", query = "SELECT e FROM Empleado e WHERE e.empleadoTipoDni = :empleadoTipoDni")
    , @NamedQuery(name = "Empleado.findByEmpleadoDni", query = "SELECT e FROM Empleado e WHERE e.empleadoDni = :empleadoDni")
    , @NamedQuery(name = "Empleado.findByEmpleadoEstadoCivil", query = "SELECT e FROM Empleado e WHERE e.empleadoEstadoCivil = :empleadoEstadoCivil")
    , @NamedQuery(name = "Empleado.findByEmpleadoNombreConyugue", query = "SELECT e FROM Empleado e WHERE e.empleadoNombreConyugue = :empleadoNombreConyugue")
    , @NamedQuery(name = "Empleado.findByEmpleadoSexo", query = "SELECT e FROM Empleado e WHERE e.empleadoSexo = :empleadoSexo")
    , @NamedQuery(name = "Empleado.findByEmpleadoFechaCreacion", query = "SELECT e FROM Empleado e WHERE e.empleadoFechaCreacion = :empleadoFechaCreacion")
    , @NamedQuery(name = "Empleado.findByEmpleadoFechaModificacion", query = "SELECT e FROM Empleado e WHERE e.empleadoFechaModificacion = :empleadoFechaModificacion")
    , @NamedQuery(name = "Empleado.findByEmpleadoEstado", query = "SELECT e FROM Empleado e WHERE e.empleadoEstado = :empleadoEstado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleadoId")
    private Integer empleadoId;
    @Size(max = 150)
    @Column(name = "empleadoPrimerNombre")
    private String empleadoPrimerNombre;
    @Size(max = 150)
    @Column(name = "empleadoSegundoNombre")
    private String empleadoSegundoNombre;
    @Size(max = 150)
    @Column(name = "empleadoPrimerApellido")
    private String empleadoPrimerApellido;
    @Size(max = 150)
    @Column(name = "empleadoSegundoApellido")
    private String empleadoSegundoApellido;
    @Column(name = "empleadoTipoDni")
    private Character empleadoTipoDni;
    @Size(max = 50)
    @Column(name = "empleadoDni")
    private String empleadoDni;
    @Column(name = "empleadoEstadoCivil")
    private Character empleadoEstadoCivil;
    @Size(max = 500)
    @Column(name = "empleadoNombreConyugue")
    private String empleadoNombreConyugue;
    @Column(name = "empleadoSexo")
    private Character empleadoSexo;
    @Column(name = "empleadoFechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empleadoFechaCreacion;
    @Column(name = "empleadoFechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empleadoFechaModificacion;
    @Column(name = "empleadoEstado")
    private Character empleadoEstado;
    @JoinColumn(name = "cargoId", referencedColumnName = "cargoId")
    @ManyToOne
    private Cargo cargoId;
    @JoinColumn(name = "empresaId", referencedColumnName = "empresaId")
    @ManyToOne
    private Empresa empresaId;
    @OneToMany(mappedBy = "empleadoId")
    private Collection<Usuario> usuarioCollection;

    public Empleado() {
    }

    public Empleado(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getEmpleadoPrimerNombre() {
        return empleadoPrimerNombre;
    }

    public void setEmpleadoPrimerNombre(String empleadoPrimerNombre) {
        this.empleadoPrimerNombre = empleadoPrimerNombre;
    }

    public String getEmpleadoSegundoNombre() {
        return empleadoSegundoNombre;
    }

    public void setEmpleadoSegundoNombre(String empleadoSegundoNombre) {
        this.empleadoSegundoNombre = empleadoSegundoNombre;
    }

    public String getEmpleadoPrimerApellido() {
        return empleadoPrimerApellido;
    }

    public void setEmpleadoPrimerApellido(String empleadoPrimerApellido) {
        this.empleadoPrimerApellido = empleadoPrimerApellido;
    }

    public String getEmpleadoSegundoApellido() {
        return empleadoSegundoApellido;
    }

    public void setEmpleadoSegundoApellido(String empleadoSegundoApellido) {
        this.empleadoSegundoApellido = empleadoSegundoApellido;
    }

    public Character getEmpleadoTipoDni() {
        return empleadoTipoDni;
    }

    public void setEmpleadoTipoDni(Character empleadoTipoDni) {
        this.empleadoTipoDni = empleadoTipoDni;
    }

    public String getEmpleadoDni() {
        return empleadoDni;
    }

    public void setEmpleadoDni(String empleadoDni) {
        this.empleadoDni = empleadoDni;
    }

    public Character getEmpleadoEstadoCivil() {
        return empleadoEstadoCivil;
    }

    public void setEmpleadoEstadoCivil(Character empleadoEstadoCivil) {
        this.empleadoEstadoCivil = empleadoEstadoCivil;
    }

    public String getEmpleadoNombreConyugue() {
        return empleadoNombreConyugue;
    }

    public void setEmpleadoNombreConyugue(String empleadoNombreConyugue) {
        this.empleadoNombreConyugue = empleadoNombreConyugue;
    }

    public Character getEmpleadoSexo() {
        return empleadoSexo;
    }

    public void setEmpleadoSexo(Character empleadoSexo) {
        this.empleadoSexo = empleadoSexo;
    }

    public Date getEmpleadoFechaCreacion() {
        return empleadoFechaCreacion;
    }

    public void setEmpleadoFechaCreacion(Date empleadoFechaCreacion) {
        this.empleadoFechaCreacion = empleadoFechaCreacion;
    }

    public Date getEmpleadoFechaModificacion() {
        return empleadoFechaModificacion;
    }

    public void setEmpleadoFechaModificacion(Date empleadoFechaModificacion) {
        this.empleadoFechaModificacion = empleadoFechaModificacion;
    }

    public Character getEmpleadoEstado() {
        return empleadoEstado;
    }

    public void setEmpleadoEstado(Character empleadoEstado) {
        this.empleadoEstado = empleadoEstado;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoId != null ? empleadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoId == null && other.empleadoId != null) || (this.empleadoId != null && !this.empleadoId.equals(other.empleadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empleado[ empleadoId=" + empleadoId + " ]";
    }
    
}
