package usedb;

import javax.persistence.*;

/**
 * Created by YanVydra on 14.05.2017.
 */
@Entity
@Table(name = "Lectors", schema = "YanDB", catalog = "")
public class LectorsEnt {
    private int idLec;
    private String fio;
    private String llogin;
    private String lpassword;

    @Id
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
    @Column(name = "llogin", nullable = true, length = 10)
    public String getLlogin() {
        return llogin;
    }

    public void setLlogin(String llogin) {
        this.llogin = llogin;
    }

    @Basic
    @Column(name = "lpassword", nullable = true, length = 10)
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

        LectorsEnt that = (LectorsEnt) o;

        if (idLec != that.idLec) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (llogin != null ? !llogin.equals(that.llogin) : that.llogin != null) return false;
        if (lpassword != null ? !lpassword.equals(that.lpassword) : that.lpassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLec;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (llogin != null ? llogin.hashCode() : 0);
        result = 31 * result + (lpassword != null ? lpassword.hashCode() : 0);
        return result;
    }
}
