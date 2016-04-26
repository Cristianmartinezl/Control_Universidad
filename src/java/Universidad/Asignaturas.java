/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Universidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JohnSebastian
 */
@Entity
@Table(name = "ASIGNATURAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a"),
    @NamedQuery(name = "Asignaturas.findByIdAsignatura", query = "SELECT a FROM Asignaturas a WHERE a.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Asignaturas.findByNombreAsignatura", query = "SELECT a FROM Asignaturas a WHERE a.nombreAsignatura = :nombreAsignatura"),
    @NamedQuery(name = "Asignaturas.findByHorario", query = "SELECT a FROM Asignaturas a WHERE a.horario = :horario")})
public class Asignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASIGNATURA")
    private Integer idAsignatura;
    @Size(max = 15)
    @Column(name = "NOMBRE_ASIGNATURA")
    private String nombreAsignatura;
    @Size(max = 15)
    @Column(name = "HORARIO")
    private String horario;
    @JoinColumn(name = "ID_DOCENTE", referencedColumnName = "ID_DOCENTE")
    @ManyToOne
    private Docentes docentes;

    public Asignaturas() {
    }

    public Asignaturas(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Docentes getDocentes() {
        return docentes;
    }

    public void setDocentes(Docentes docentes) {
        this.docentes = docentes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Universidad.Asignaturas[ idAsignatura=" + idAsignatura + " ]";
    }
    
}
