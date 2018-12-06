/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RKOrtega
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuario.findByUsuarioUsername", query = "SELECT u FROM Usuario u WHERE u.usuarioUsername = :usuarioUsername")
    , @NamedQuery(name = "Usuario.findByUsuarioPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioPassword = :usuarioPassword")
    , @NamedQuery(name = "Usuario.findByUsuarioFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.usuarioFechaCreacion = :usuarioFechaCreacion")
    , @NamedQuery(name = "Usuario.findByUsuarioFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.usuarioFechaModificacion = :usuarioFechaModificacion")
    , @NamedQuery(name = "Usuario.findByUsuarioEstado", query = "SELECT u FROM Usuario u WHERE u.usuarioEstado = :usuarioEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioId")
    private Integer usuarioId;
    @Size(max = 50)
    @Column(name = "usuarioUsername")
    private String usuarioUsername;
    @Size(max = 50)
    @Column(name = "usuarioPassword")
    private String usuarioPassword;
    @Column(name = "usuarioFechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioFechaCreacion;
    @Column(name = "usuarioFechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioFechaModificacion;
    @Column(name = "usuarioEstado")
    private Character usuarioEstado;
    @JoinColumn(name = "empleadoId", referencedColumnName = "empleadoId")
    @ManyToOne
    private Empleado empleadoId;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioUsername() {
        return usuarioUsername;
    }

    public void setUsuarioUsername(String usuarioUsername) {
        this.usuarioUsername = usuarioUsername;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public Date getUsuarioFechaCreacion() {
        return usuarioFechaCreacion;
    }

    public void setUsuarioFechaCreacion(Date usuarioFechaCreacion) {
        this.usuarioFechaCreacion = usuarioFechaCreacion;
    }

    public Date getUsuarioFechaModificacion() {
        return usuarioFechaModificacion;
    }

    public void setUsuarioFechaModificacion(Date usuarioFechaModificacion) {
        this.usuarioFechaModificacion = usuarioFechaModificacion;
    }

    public Character getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(Character usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
