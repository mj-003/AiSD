package Zadanie2;
import java.util.*;

public class Zad2 {
    public Zad2() {
    }

    public boolean poprawneID(String slowo) {
        for(int i = 1; i < slowo.length(); i++){
            if(!Character.isLetterOrDigit(slowo.charAt(i)))
                return false;
        }
        return Character.isLetter(slowo.charAt(0)) || slowo.charAt(0) == '_';
    }

    public String[] interpunkcja(String id) {
        String ch = "";
        Set<Character> znakiInter = new HashSet<>(Arrays.asList(',', '.', '!', '?', ';'));
        if(znakiInter.contains(id.charAt(id.length()-1))) {
            ch = String.valueOf(id.charAt(id.length()-1));
            id = id.replace(ch, "");
        }
        String[] ret = new String[2];
        ret[0] = id;
        ret[1] = ch;
        return ret;
    }

    public void pairSwap(String text) {
        StringBuilder nowyTekst = new StringBuilder();
        String[] slowa = text.split(" ");

        for(String slowo : slowa) {
            String wynik = slowo + " ";

            if (slowo.contains("=") && Collections.frequency(List.of(slowo.split("")), "=") == 1) {
                String[] arr = slowo.split("=");
                String id1 = interpunkcja(arr[0])[0];
                String id2 = interpunkcja(arr[1])[0];
                if(poprawneID(id1) && poprawneID(id2)) {
                    wynik = id2 + "=" + id1 + interpunkcja(arr[1])[1] + " ";
                }
            }
            nowyTekst.append(wynik);
        }
        System.out.println(nowyTekst);
    }

    public static void main(String[] args) {
        Zad2 zad2 = new Zad2();
        zad2.pairSwap("Litw0==0jczyzno moja, Ty jestes jak zdr0w13, ile C13=c3n1c,, t3n ty1k0 si3 d0wie=_kt0 C13 stracil.");
    }
}
