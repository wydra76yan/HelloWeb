package webutils;

/**
 * Created by YanVydra on 19.05.2017.
 */
// Класс лектор для отображения на странице
public class Lectors {
        int id_lec;
        String fio;
        String llogin;
        String lpassword;

        public Lectors(int i, String lecfio,String plogin, String ppassword) {
            id_lec = i;
            fio = lecfio;
            llogin = plogin;
            lpassword = ppassword;
        }

        public int getId_lec() {
            return id_lec;
        }
        public void setId_lec(int id) {
            this.id_lec = id;
        }

        public String getFio() {
            return fio;
        }
        public void setFio(String txt) {
            this.fio = txt;
        }

        public String getLlogin() {
        return llogin;
    }
        public void setLlogin(String txt) {
        this.llogin = txt;
    }

        public String getLpassword() {
        return lpassword;
    }
        public void setLpassword(String txt) {
        this.lpassword = txt;
    }
    }


