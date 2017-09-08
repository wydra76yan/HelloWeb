package usedb;

import javax.persistence.*;

/**
 * Created by YanVydra on 29.05.2017.
 */
@Entity
@Table(name = "Students", schema = "YanDB", catalog = "")
public class StudentsEnt {
    private int idStud;
    private String sfio;
    private String llogin;
    private String lpassword;

    @Id
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
    @Column(name = "llogin", nullable = true, length = 30)
    public String getLlogin() {
        return llogin;
    }

    public void setLlogin(String llogin) {
        this.llogin = llogin;
    }

    @Basic
    @Column(name = "lpassword", nullable = true, length = 30)
    public String getLpassword() {
        return lpassword;
    }

    public void setLpassword(String lpassword) {
        this.lpassword = lpassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEnt that = (StudentsEnt) o;

        if (idStud != that.idStud) return false;
        if (sfio != null ? !sfio.equals(that.sfio) : that.sfio != null) return false;
        if (llogin != null ? !llogin.equals(that.llogin) : that.llogin != null) return false;
        if (lpassword != null ? !lpassword.equals(that.lpassword) : that.lpassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStud;
        result = 31 * result + (sfio != null ? sfio.hashCode() : 0);
        result = 31 * result + (llogin != null ? llogin.hashCode() : 0);
        result = 31 * result + (lpassword != null ? lpassword.hashCode() : 0);
        return result;
    }
}
