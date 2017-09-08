package webutils;

/**
 * Created by YanVydra on 19.05.2017.
 */
// Класс  для отображения на странице
public class Vall {
        int id;
        int id_lec;
        int id_course;
        int id_stud;
        int ord;

        String fio;
        String sfio;
        String n_course;
        Integer mark;

        public Vall(int iord, int isi,int il,int ic,int is, String tfio, String tncourse, String tsfio, Integer tmark) {
            id = isi;
            id_lec = il;
            id_course = ic;
            id_stud = is;
            fio = tfio;
            sfio = tsfio;
            n_course = tncourse;
            mark= tmark;
            ord = iord;//kol-vo stud
        }

    public int getOrd() {return ord; }
    public void setOrd(int id) {
        this.ord = id;
    }

        public int getId() {return id; }
        public void setId(int id) {
            this.id = id;
        }

        public int getId_lec() {
        return id_lec;
    }
        public void setId_lec(int id) {
        this.id_lec = id;
    }

        public int getId_course() {
        return id_course;
    }
        public void setId_course(int id) {
        this.id_course = id;
    }

        public int getId_stud() {
        return id_stud;
    }
        public void setId_stud(int id) {
        this.id_stud = id;
    }

        public String getFio() {
            return fio;
        }
        public void setFio(String txt) {
            this.fio = txt;
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
        public void setN_course(String txt) {this.n_course = txt;}

        public Integer getMark() { return mark; }
        public void setMark(Integer tmark) {
        this.mark = tmark;
    }
    }


