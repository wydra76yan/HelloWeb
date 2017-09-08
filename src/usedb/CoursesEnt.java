package usedb;

import javax.persistence.*;

/**
 * Created by YanVydra on 14.05.2017.
 */
@Entity
@Table(name = "Courses", schema = "YanDB", catalog = "")
public class CoursesEnt {
    private int idCourse;
    private String nCourse;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesEnt that = (CoursesEnt) o;

        if (idCourse != that.idCourse) return false;
        if (nCourse != null ? !nCourse.equals(that.nCourse) : that.nCourse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCourse;
        result = 31 * result + (nCourse != null ? nCourse.hashCode() : 0);
        return result;
    }
}
