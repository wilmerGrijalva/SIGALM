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
@Table(name = "PERMISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByPerId", query = "SELECT p FROM Permiso p WHERE p.perId = :perId"),
    @NamedQuery(name = "Permiso.findByPerNombre", query = "SELECT p FROM Permiso p WHERE p.perNombre = :perNombre"),
    @NamedQuery(name = "Permiso.findByPerDescripcion", query = "SELECT p FROM Permiso p WHERE p.perDescripcion = :perDescripcion"),
    @NamedQuery(name = "Permiso.findByFecCrea", query = "SELECT p FROM Permiso p WHERE p.fecCrea = :fecCrea"),
    @NamedQuery(name = "Permiso.findByUsuCrea", query = "SELECT p FROM Permiso p WHERE p.usuCrea = :usuCrea"),
    @NamedQuery(name = "Permiso.findByFecModi", query = "SELECT p FROM Permiso p WHERE p.fecModi = :fecModi"),
    @NamedQuery(name = "Permiso.findByUsuModi", query = "SELECT p FROM Permiso p WHERE p.usuModi = :usuModi"),
    @NamedQuery(name = "Permiso.findByRegActivo", query = "SELECT p FROM Permiso p WHERE p.regActivo = :regActivo")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "PERMISO_PER_ID_GENERATOR", sequenceName = "SEQ_PERMISO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISO_PER_ID_GENERATOR")
    @NotNull
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Size(max = 4000)
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;
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
    @JoinColumn(name = "PER_MNU_ID", referencedColumnName = "MNU_ID")
    @ManyToOne(optional = false)
    private Menu perMnuId;
    @JoinColumn(name = "PER_ROL_ID", referencedColumnName = "ROL_ID")
    @ManyToOne(optional = false)
    private Rol perRolId;

    public Permiso() {
    }

    public Permiso(BigDecimal perId) {
        this.perId = perId;
    }

    public Permiso(BigDecimal perId, String perNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.perId = perId;
        this.perNombre = perNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
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

    public Menu getPerMnuId() {
        return perMnuId;
    }

    public void setPerMnuId(Menu perMnuId) {
        this.perMnuId = perMnuId;
    }

    public Rol getPerRolId() {
        return perRolId;
    }

    public void setPerRolId(Rol perRolId) {
        this.perRolId = perRolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnr.gob.entidades.Permiso[ perId=" + perId + " ]";
    }
    
}
