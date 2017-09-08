package webutils;


/**
 * Created by YanVydra on 22.03.2017.
 */
public class HiWeb {

    public static String getMessage(int ii, String stxt){
        String str1="<h3 class=\"message\">Hi everybody from MathFac!</h3>";
        switch (ii) {//need to add messagbox
            case 1:
                str1 = "<h3 class=\"message\">List of lectures of "+stxt+" </h3>";
                break;
            case 2:
                str1 = "<div  color=\"red\"><h3 class=\"message\">Error login.</h3></div>";
                break;
            case 3:
                str1 = "<h3 class=\"message\">"+stxt+" </h3>";
                break;
             default:
                 str1 = stxt;
                 break;
        }
        return str1;
    }
    public static String getMessage() {
        //int num1 = this.num;
        return getMessage(0, "");
    }


}
