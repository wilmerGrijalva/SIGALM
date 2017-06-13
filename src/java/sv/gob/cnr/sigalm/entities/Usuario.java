/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.cnr.sigalm.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author javii
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsrId", query = "SELECT u FROM Usuario u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "Usuario.findByUsrCarnet", query = "SELECT u FROM Usuario u WHERE u.usrCarnet = :usrCarnet"),
    @NamedQuery(name = "Usuario.findByUsrNombre", query = "SELECT u FROM Usuario u WHERE u.usrNombre = :usrNombre"),
    @NamedQuery(name = "Usuario.findByUsrApellido", query = "SELECT u FROM Usuario u WHERE u.usrApellido = :usrApellido"),
    @NamedQuery(name = "Usuario.findByUsrDui", query = "SELECT u FROM Usuario u WHERE u.usrDui = :usrDui"),
    @NamedQuery(name = "Usuario.findByUsrNit", query = "SELECT u FROM Usuario u WHERE u.usrNit = :usrNit"),
    @NamedQuery(name = "Usuario.findByUsrTelefono", query = "SELECT u FROM Usuario u WHERE u.usrTelefono = :usrTelefono"),
    @NamedQuery(name = "Usuario.findByUsrCelular", query = "SELECT u FROM Usuario u WHERE u.usrCelular = :usrCelular"),
    @NamedQuery(name = "Usuario.findByUsrCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.usrCorreoElectronico = :usrCorreoElectronico"),
    @NamedQuery(name = "Usuario.findByUsrUsuario", query = "SELECT u FROM Usuario u WHERE u.usrUsuario = :usrUsuario"),
    @NamedQuery(name = "Usuario.findByUsrContrasenia", query = "SELECT u FROM Usuario u WHERE u.usrContrasenia = :usrContrasenia"),
    @NamedQuery(name = "Usuario.findByUsrFoto", query = "SELECT u FROM Usuario u WHERE u.usrFoto = :usrFoto"),
    @NamedQuery(name = "Usuario.findByUsrDescripcion", query = "SELECT u FROM Usuario u WHERE u.usrDescripcion = :usrDescripcion"),
    @NamedQuery(name = "Usuario.findByFecCrea", query = "SELECT u FROM Usuario u WHERE u.fecCrea = :fecCrea"),
    @NamedQuery(name = "Usuario.findByUsuCrea", query = "SELECT u FROM Usuario u WHERE u.usuCrea = :usuCrea"),
    @NamedQuery(name = "Usuario.findByFecModi", query = "SELECT u FROM Usuario u WHERE u.fecModi = :fecModi"),
    @NamedQuery(name = "Usuario.findByUsuModi", query = "SELECT u FROM Usuario u WHERE u.usuModi = :usuModi"),
    @NamedQuery(name = "Usuario.findByRegActivo", query = "SELECT u FROM Usuario u WHERE u.regActivo = :regActivo"),
    @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.usrUsuario = :usrUsuario AND u.usrContrasenia = :usrContrasenia")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "USUARIO_USR_ID_GENERATOR", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_USR_ID_GENERATOR")
    @NotNull
    @Column(name = "USR_ID")
    private BigDecimal usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USR_CARNET")
    private String usrCarnet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USR_NOMBRE")
    private String usrNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USR_APELLIDO")
    private String usrApellido;
    @Size(max = 10)
    @Column(name = "USR_DUI")
    private String usrDui;
    @Size(max = 17)
    @Column(name = "USR_NIT")
    private String usrNit;
    @Size(max = 20)
    @Column(name = "USR_TELEFONO")
    private String usrTelefono;
    @Size(max = 20)
    @Column(name = "USR_CELULAR")
    private String usrCelular;
    @Size(max = 100)
    @Column(name = "USR_CORREO_ELECTRONICO")
    private String usrCorreoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USR_USUARIO")
    private String usrUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USR_CONTRASENIA")
    private String usrContrasenia;
    @Size(max = 250)
    @Column(name = "USR_FOTO")
    private String usrFoto;
    @Size(max = 4000)
    @Column(name = "USR_DESCRIPCION")
    private String usrDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USU_CREA")
    private String usuCrea;
    @Column(name = "FEC_MODI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModi;
    @Size(max = 6)
    @Column(name = "USU_MODI")
    private String usuModi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_ACTIVO")
    private short regActivo;
    @JoinColumn(name = "USR_ROL_ID", referencedColumnName = "ROL_ID")
    @ManyToOne(optional = false)
    private Rol usrRolId;

    public Usuario() {
        this.usrRolId = new Rol();
    }

    public Usuario(BigDecimal usrId) {
        this.usrId = usrId;
    }

    public Usuario(BigDecimal usrId, String usrCarnet, String usrNombre, String usrApellido, String usrUsuario, String usrContrasenia, Date fecCrea, String usuCrea, short regActivo) {
        this.usrId = usrId;
        this.usrCarnet = usrCarnet;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrUsuario = usrUsuario;
        this.usrContrasenia = usrContrasenia;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public BigDecimal getUsrId() {
        return usrId;
    }

    public void setUsrId(BigDecimal usrId) {
        this.usrId = usrId;
    }

    public String getUsrCarnet() {
        return usrCarnet;
    }

    public void setUsrCarnet(String usrCarnet) {
        this.usrCarnet = usrCarnet;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrDui() {
        return usrDui;
    }

    public void setUsrDui(String usrDui) {
        this.usrDui = usrDui;
    }

    public String getUsrNit() {
        return usrNit;
    }

    public void setUsrNit(String usrNit) {
        this.usrNit = usrNit;
    }

    public String getUsrTelefono() {
        return usrTelefono;
    }

    public void setUsrTelefono(String usrTelefono) {
        this.usrTelefono = usrTelefono;
    }

    public String getUsrCelular() {
        return usrCelular;
    }

    public void setUsrCelular(String usrCelular) {
        this.usrCelular = usrCelular;
    }

    public String getUsrCorreoElectronico() {
        return usrCorreoElectronico;
    }

    public void setUsrCorreoElectronico(String usrCorreoElectronico) {
        this.usrCorreoElectronico = usrCorreoElectronico;
    }

    public String getUsrUsuario() {
        return usrUsuario;
    }

    public void setUsrUsuario(String usrUsuario) {
        this.usrUsuario = usrUsuario;
    }

    public String getUsrContrasenia() {
        return usrContrasenia;
    }

    public void setUsrContrasenia(String usrContrasenia) {
        this.usrContrasenia = usrContrasenia;
    }

    public String getUsrFoto() {
        return usrFoto;
    }

    public void setUsrFoto(String usrFoto) {
        this.usrFoto = usrFoto;
    }

    public String getUsrDescripcion() {
        return usrDescripcion;
    }

    public void setUsrDescripcion(String usrDescripcion) {
        this.usrDescripcion = usrDescripcion;
    }

    public Date getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Date fecCrea) {
        this.fecCrea = fecCrea;
    }

    public String getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(String usuCrea) {
        this.usuCrea = usuCrea;
    }

    public Date getFecModi() {
        return fecModi;
    }

    public void setFecModi(Date fecModi) {
        this.fecModi = fecModi;
    }

    public String getUsuModi() {
        return usuModi;
    }

    public void setUsuModi(String usuModi) {
        this.usuModi = usuModi;
    }

    public short getRegActivo() {
        return regActivo;
    }

    public void setRegActivo(short regActivo) {
        this.regActivo = regActivo;
    }

    public Rol getUsrRolId() {
        return usrRolId;
    }

    public void setUsrRolId(Rol usrRolId) {
        this.usrRolId = usrRolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnr.gob.entidades.Usuario[ usrId=" + usrId + " ]";
    }

}
