/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Universidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JohnSebastian
 */
@Entity
@Table(name = "DOCENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findByIdDocente", query = "SELECT d FROM Docentes d WHERE d.idDocente = :idDocente"),
    @NamedQuery(name = "Docentes.findByApellido", query = "SELECT d FROM Docentes d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Docentes.findByNombres", query = "SELECT d FROM Docentes d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "Docentes.findByAsignatura", query = "SELECT d FROM Docentes d WHERE d.asignatura = :asignatura"),
    @NamedQuery(name = "Docentes.findByHorario", query = "SELECT d FROM Docentes d WHERE d.horario = :horario")})
public class Docentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCENTE")
    private Integer idDocente;
    @Size(max = 15)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 15)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 15)
    @Column(name = "ASIGNATURA")
    private String asignatura;
    @Size(max = 15)
    @Column(name = "HORARIO")
    private String horario;
    @OneToMany(mappedBy = "docentes")
    private List<Asignaturas> asignaturasList;

    public Docentes() {
    }

    public Docentes(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @XmlTransient
    public List<Asignaturas> getAsignaturasList() {
        return asignaturasList;
    }

    public void setAsignaturasList(List<Asignaturas> asignaturasList) {
        this.asignaturasList = asignaturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocente != null ? idDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.idDocente == null && other.idDocente != null) || (this.idDocente != null && !this.idDocente.equals(other.idDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Universidad.Docentes[ idDocente=" + idDocente + " ]";
    }
    
}
