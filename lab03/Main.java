public class Main {
    public static void main(String[] args) {
//        Lista<String> listaPusta = new Lista<>();
//        Lista<String> listaJednoEl = new Lista<>();
//        Lista<String> listaPar = new Lista<>();
//        Lista<String> listaNPar = new Lista<>();
//
//
//        // ----------LISTA PUSTA---------
//
//        System.out.println("lista pusta: ");
//        listaPusta.wypisz();
//        System.out.println();
//
//        System.out.println("size: " + listaPusta.size());
//        System.out.println("contains: " + listaPusta.contains("a"));
//        // System.out.println("get: "listaPusta.get(1));
//        System.out.println("index of: " + listaPusta.indexOf("a"));
//        System.out.println("is empty: " + listaPusta.isEmpty());
//        System.out.println("remove: " + listaPusta.remove("a"));
//        System.out.println("remove: " + listaPusta.remove(1));
//
//
//        // ----------LISTA JEDNOELEMENTOWA---------
//
//        System.out.println();
//        System.out.println("lista jednoelementowa:");
//        listaJednoEl.add("a");
//        listaJednoEl.wypisz();
//        System.out.println();
//
//        System.out.println("size: " + listaJednoEl.size());
//        System.out.println("contains: " + listaJednoEl.contains("a"));
//
//        // zmiana elementu na "b"
//        System.out.print("set: ");
//        listaJednoEl.set(0, "b");
//        listaJednoEl.wypisz();
//        System.out.println();
//
//        System.out.println("get: " + listaJednoEl.get(0));
//        System.out.println("index of: " + listaJednoEl.indexOf("a"));
//        System.out.println("is empty: " + listaJednoEl.isEmpty());
//        System.out.println("remove: " + listaJednoEl.remove("b"));
//
//
//        // ----------LISTA PARZYSTA---------
//
//        System.out.println();
//        System.out.println("lista parzysta:");
//
//        listaPar.add("a");
//        listaPar.add("b");
//        listaPar.add("c");
//        listaPar.add(1, "d");
//        listaPar.wypisz();
//        System.out.println();
//
//        System.out.println("size: " + listaPar.size());
//        System.out.println("contains: " + listaPar.contains("a"));
//        System.out.println("get: " + listaPar.get(0));
//        System.out.println("index of: " + listaPar.indexOf("a"));
//        System.out.println("is empty: " + listaPar.isEmpty());
//        System.out.print("set: ");
//        listaPar.set(1, "x");
//        listaPar.wypisz();
//        System.out.println();
//        System.out.println("remove: " + listaPar.remove(1));
//        System.out.print("after remove: ");
//        listaPar.wypisz();
//        System.out.println();
//
//
//        // ----------LISTA NIEPARZYSTA---------
//
//        System.out.println();
//        System.out.println("lista nieparzysta:");
//
//        listaNPar.add("a");
//        listaNPar.add("b");
//        listaNPar.add("c");
//        listaNPar.add(1, "d");
//        listaNPar.add("e");
//        listaNPar.wypisz();
//        System.out.println();
//
//        System.out.println("size: " + listaNPar.size());
//        System.out.println("contains: " + listaNPar.contains("e"));
//        System.out.println("get: " + listaNPar.get(1));
//        System.out.println("index of: " + listaNPar.indexOf("c"));
//        System.out.println("is empty: " + listaNPar.isEmpty());
//        System.out.print("set: ");
//        listaNPar.set(1, "x");
//        listaNPar.wypisz();
//        System.out.println();
//        System.out.println("remove: " + listaNPar.remove("a"));
//        System.out.print("after remove: ");
//        listaNPar.wypisz();
//        System.out.println();
//
//        System.out.print("clear -> ");
//        listaNPar.clear();
//        System.out.println("size: " + listaNPar.size());


        // ----------LISTA DWUKIERUNKOWA---------

        Lista<String> listaDwukierunkowa = new Lista<>();
        listaDwukierunkowa.add("x");
        listaDwukierunkowa.remove("x");

        listaDwukierunkowa.add("a");
        listaDwukierunkowa.add("b");
        listaDwukierunkowa.add("c");
        listaDwukierunkowa.add("d");
        listaDwukierunkowa.remove("x");

        listaDwukierunkowa.wypiszOdPrzodu();
        System.out.println();
        listaDwukierunkowa.wypiszOdTylu();
        listaDwukierunkowa.remove("a");
        System.out.println();
        listaDwukierunkowa.wypiszOdTylu();











    }

}