package usedb;

import org.hibernate.annotations.Immutable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by YanVydra on 30.05.2017.
 */
@Entity
@Immutable//имитация таблицы
@Table(name = "vnall", schema = "YanDB", catalog = "")
public class VnallEnt {
    private int idCourse;
    private String nCourse;
    private int idStud;
    private String sfio;
    private Integer idLec;
    private long id;

    @Basic
    @Column(name = "id_course", nullable = false)
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "n_course", nullable = true, length = 50)
    public String getnCourse() {
        return nCourse;
    }

    public void setnCourse(String nCourse) {
        this.nCourse = nCourse;
    }

    @Basic
    @Column(name = "id_stud", nullable = false)
    public int getIdStud() {
        return idStud;
    }

    public void setIdStud(int idStud) {
        this.idStud = idStud;
    }

    @Basic
    @Column(name = "sfio", nullable = false, length = 100)
    public String getSfio() {
        return sfio;
    }

    public void setSfio(String sfio) {
        this.sfio = sfio;
    }

    @Basic
    @Column(name = "id_lec", nullable = true)
    public Integer getIdLec() {
        return idLec;
    }

    public void setIdLec(Integer idLec) {
        this.idLec = idLec;
    }

    @Basic
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VnallEnt vnallEnt = (VnallEnt) o;

        if (idCourse != vnallEnt.idCourse) return false;
        if (idStud != vnallEnt.idStud) return false;
        if (id != vnallEnt.id) return false;
        if (nCourse != null ? !nCourse.equals(vnallEnt.nCourse) : vnallEnt.nCourse != null) return false;
        if (sfio != null ? !sfio.equals(vnallEnt.sfio) : vnallEnt.sfio != null) return false;
        if (idLec != null ? !idLec.equals(vnallEnt.idLec) : vnallEnt.idLec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCourse;
        result = 31 * result + (nCourse != null ? nCourse.hashCode() : 0);
        result = 31 * result + idStud;
        result = 31 * result + (sfio != null ? sfio.hashCode() : 0);
        result = 31 * result + (idLec != null ? idLec.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
