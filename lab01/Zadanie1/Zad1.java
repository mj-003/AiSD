package Zadanie1;

public class Zad1 {
    public Zad1() {
    }
    public void wypisz(int n, int h) {
        if(h <= 0 || n < 0) {
            return;
        }
        else {
            for(int i = 0; i < h-1; i++) {
                System.out.print(" ");
            }
            for(int i = 0; i < n; i++) {
                System.out.print("X");
            }
            System.out.println();
            h--;
            n+=2;
            wypisz(n, h);
        }
    }

    public void drawPyramid(int n, int h) {
        wypisz((2*n+1), h);
    }

    public void drawAFigure(int n) {
        int wierzcholek = 1;
        while (n > 0) {
            wypisz(wierzcholek, n);
            wierzcholek += 2;
            n--;
        }
    }


    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();
        zad1.drawPyramid(0, 3);
        System.out.println();
        zad1.drawAFigure(4);
        System.out.println();

    }
}


