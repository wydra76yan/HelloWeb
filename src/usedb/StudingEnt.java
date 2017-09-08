package usedb;

import javax.persistence.*;

/**
 * Created by YanVydra on 14.05.2017.
 */
@Entity
@Table(name = "Studing", schema = "YanDB", catalog = "")
public class StudingEnt {
    private int idStuding;
    private Integer mark;
    private CoursesEnt coursesByIdCourse;
    private StudentsEnt studentsByIdStud;

    @Id
    @Column(name = "id_studing", nullable = false)
    public int getIdStuding() {
        return idStuding;
    }

    public void setIdStuding(int idStuding) {
        this.idStuding = idStuding;
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

        StudingEnt that = (StudingEnt) o;

        if (idStuding != that.idStuding) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStuding;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course", nullable = false)
    public CoursesEnt getCoursesByIdCourse() {
        return coursesByIdCourse;
    }

    public void setCoursesByIdCourse(CoursesEnt coursesByIdCourse) {
        this.coursesByIdCourse = coursesByIdCourse;
    }

    @ManyToOne
    @JoinColumn(name = "id_stud", referencedColumnName = "id_stud")
    public StudentsEnt getStudentsByIdStud() {
        return studentsByIdStud;
    }

    public void setStudentsByIdStud(StudentsEnt studentsByIdStud) {
        this.studentsByIdStud = studentsByIdStud;
    }
}
