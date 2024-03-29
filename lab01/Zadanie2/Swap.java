package Zadanie2;

import java.util.*;

public class Swap {
    PatternMatch patternMatch = new PatternMatch();
    public Swap() {
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

    public String pierwszeDrugieID(String slowo) {
        int indeks = patternMatch.bitap_search(slowo, "=");
        String id1 = "";
        String id2 = "";
        for(int i = 0; i < indeks; i++) {
            id1 += slowo.charAt(i);
        }
        for(int i = indeks+1; i < slowo.length(); i++) {
            id2 += slowo.charAt(i);

        }

        String wynik = id1 + id2;
        String znak = interpunkcja(id2)[1];
        id2 = interpunkcja(id2)[0];
        if(poprawneID(id1) && poprawneID(id2)) {
            wynik = id2 + "=" + id1 + znak;
        }
        return wynik;
    }

    public void pairSwap(String text, String pattern) {
        StringBuilder nowyTekst = new StringBuilder();
        String[] slowa = text.split(" ");

        for(String slowo : slowa) {
            String nowe = slowo + " ";
            if(patternMatch.bitap_search(slowo, pattern) != -1) {
                nowe = pierwszeDrugieID(slowo) + " ";
            }
            nowyTekst.append(nowe);
        }
        System.out.println(nowyTekst);
    }


    public static void main(String[] args) {
        Swap swap = new Swap();
        swap.pairSwap("Abc=bddd, _aa0=bbcd, lalaa=bbdu! Bdceaa=bblu. BBa09=iuk", "c=b");
    }


}


