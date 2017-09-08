package webutils;

/**
 * Created by YanVydra on 19.05.2017.
 */
// Класс лектор для отображения на странице
public class Vnall {
        int id;
        int id_course;
        int id_lec;
        String n_course;
        int id_stud;
        String sfio;
        int ord;

        public Vnall( int iord, int ic, int il, int is, String tncourse, String tsfio) {
            id_course = ic;
            n_course = tncourse;
            id_lec = il;
            id_stud = is;
            sfio = tsfio;
            ord = iord;
        }

        public int getId() { return id; }
        public void setId(int id) {
        this.id = id;
    }

        public int getId_course() {        return id_course;    }
        public void setId_course(int id) {
        this.id_course = id;
    }

        public int getId_lec() {
        return id_lec;
    }
        public void setId_lec(int id) {
        this.id_lec = id;
    }

        public int getId_stud() {
        return id_stud;
    }
        public void setId_stud(int id) {
        this.id_stud = id;
    }

        public String getSfio() {
        return sfio;
    }
        public void setSfio(String txt) {
        this.sfio = txt;
    }

        public String getN_course() {
        return n_course;
    }
        public void setN_course(String txt) {
        this.n_course = txt;
    }

        public int getOrd() { return ord; }
        public void setOrd(int id) {
        this.ord = id;
    }

}


