package webutils;

/**
 * Created by YanVydra on 19.05.2017.
 */
public class Students {
        int id_stud;
        String sfio;
    String slogin;
    String spass;

        public Students(int i, String studfio,String plogin, String ppass) {
            id_stud = i;
            sfio = studfio;
            slogin = plogin;
            spass = ppass;
        }

        public int getId_stud() {
            return id_stud;
        }
        public void setId_stud(int id) {
            this.id_stud = id;
        }

        public String getSfio() {            return sfio;        }
        public void setSfio(String txt) {
            this.sfio = txt;
        }

        public String getSlogin() {            return slogin;        }
        public void setSlogin(String txt) {
        this.slogin = txt;
    }

        public String getSpass() {            return spass;        }
        public void setSpass(String txt) {
        this.spass = txt;
    }
    }


