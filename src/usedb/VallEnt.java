package usedb;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * Created by YanVydra on 21.06.2017.
 */
@Entity
@Immutable
@Table(name = "vall", schema = "YanDB")
public class VallEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private int idLec;
    private String fio;
    private int idCourse;
    private String nCourse;
    private int idStud;
    private String sfio;
    private Integer mark;

    @Basic
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_lec", nullable = false)
    public int getIdLec() {
        return idLec;
    }

    public void setIdLec(int idLec) {
        this.idLec = idLec;
    }

    @Basic
    @Column(name = "FIO", nullable = false, length = 100)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

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
    @Column(name = "mark", nullable = true)
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VallEnt vallEnt = (VallEnt) o;

        if (idLec != vallEnt.idLec) return false;
        if (idCourse != vallEnt.idCourse) return false;
        if (idStud != vallEnt.idStud) return false;
        if (id != vallEnt.id) return false;
        if (fio != null ? !fio.equals(vallEnt.fio) : vallEnt.fio != null) return false;
        if (nCourse != null ? !nCourse.equals(vallEnt.nCourse) : vallEnt.nCourse != null) return false;
        if (sfio != null ? !sfio.equals(vallEnt.sfio) : vallEnt.sfio != null) return false;
        if (mark != null ? !mark.equals(vallEnt.mark) : vallEnt.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLec;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + idCourse;
        result = 31 * result + (nCourse != null ? nCourse.hashCode() : 0);
        result = 31 * result + idStud;
        result = 31 * result + (sfio != null ? sfio.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
