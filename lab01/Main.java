import java.util.Arrays;

public class Main {
    public Main() {
    }

    public static boolean czyIdentyfikator(String slowo){
        for(int i = 1; i < slowo.length(); i++){
            if(!Character.isLetterOrDigit(slowo.charAt(i)))
                return false;
        }
        return Character.isLetter(slowo.charAt(0)) || slowo.charAt(0) == '_';
    }

    public static String czySwap(String tekst){
        String[] pom = tekst.split("=");
        String interpunkcja = "";
        if(pom[1].charAt(pom[1].length()-1) == ','){
            pom[1] = pom[1].substring(0, pom[1].length()-1);
            interpunkcja = ",";
        }
        if(czyIdentyfikator(pom[0]) && czyIdentyfikator(pom[1])){
            return pom[1] +"="+ pom[0] + interpunkcja;
        }
        else return tekst;
    }
    public static void pairSwap(String tekst){
        String[] pom = tekst.split(" ");
        for(int i = 0; i < pom.length; i++){
            if(pom[i].contains("=")){
                pom[i] = czySwap(pom[i]);
            }
            System.out.print(pom[i] + " ");
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        main.pairSwap("Litw0=0jczyzno moja, Ty jestes jak zdr0w13, ile C13=c3n1c, t3n ty1k0\n" +
                "si3 d0wie=_kt0 C13 stracil.");


    }
}