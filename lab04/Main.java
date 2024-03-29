import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Anna", "Kowalska", "12345", "123", 2.5, 1);
        Student student2 = new Student("Bnna", "Lowalska", "12346", "124", 3.5, 1);
        Student student3 = new Student("Cnna", "Mowalska", "12347", "125", 4.5, 2);
        Student student4 = new Student("Dnna", "Nowalska", "12348", "126", 2.0, 3);
        Student student5 = new Student("Enna", "Oowalska", "12349", "127", 4.0, 3);
        Student student6 = new Student("Fnna", "Powalska", "12340", "128", 5.5, 2);
        Student student7 = new Student("Gnna", "Rowalska", "12344", "129", 5.5, 2);


        // -------TEST LISTA JEDNOKIERUNKOWA---------

        System.out.println("-------TEST LISTA JEDNOKIERUNKOWA--------- ");


        OneWayLinkedList<Student> listaJednokierunkowa = new OneWayLinkedList<>();

        listaJednokierunkowa.addBeg(student1);
        listaJednokierunkowa.addBeg(student2);
        listaJednokierunkowa.addBeg(student3);
        listaJednokierunkowa.addBeg(student4);
        listaJednokierunkowa.addEnd(student5);

        listaJednokierunkowa.addAfter(student6, "124", Student::getIndex);
        listaJednokierunkowa.addBefore(student7, "127", Student::getIndex);
        listaJednokierunkowa.remove("Anna", Student::getFirstName);
        listaJednokierunkowa.remove("kasia", Student::getFirstName);

        // posortowanie listy wedlug klucza
        System.out.println("(posortowane po roku studiow)");
        listaJednokierunkowa.bubbleSortByKey(Student::getYearOfStudy);
        System.out.println();

        // przejscie po liscie
        for (Student student : listaJednokierunkowa) {
            System.out.println(student);
        }


        // -------TEST LISTA DWUKIERUNKOWA---------

        System.out.println();
        System.out.println("-------TEST LISTA DWUKIERUNKOWA---------");

        TwoWayLinkedList<Student> listaDwukierunkowa = new TwoWayLinkedList<>();
//
//        listaDwukierunkowa.addBeg(student1);
//        listaDwukierunkowa.addBeg(student2);
//        listaDwukierunkowa.addBeg(student3);
//        listaDwukierunkowa.addBeg(student4);
//        listaDwukierunkowa.addEnd(student5);
//
//        listaDwukierunkowa.addAfter(student6, "124", Student::getIndex);
//        listaDwukierunkowa.addBefore(student7, "127", Student::getIndex);
//        listaDwukierunkowa.remove("Anna", Student::getFirstName);
//        listaDwukierunkowa.remove("kasia", Student::getFirstName);
//
//        // posortowanie listy wedlug klucza
//        System.out.println("(posortowane po sredniej ocen)");
//        listaDwukierunkowa.bubbleSortByKey(Student::getAverageGrade);
//        System.out.println();
//
//        // przejscie po liscie od poczatku i od konca
//        ListIterator<Student> iteratorD = listaDwukierunkowa.listIterator();
//
//        while (iteratorD.hasNext()) {
//            System.out.println(iteratorD.next());
//        }
//        System.out.println();
//        while (iteratorD.hasPrevious()) {
//            System.out.println(iteratorD.previous());
//        }


        // -------TEST LISTA JEDNOKIERUNKOWA CYKLICZNA---------

        System.out.println();
        System.out.println("-------TEST LISTA JEDNOKIERUNKOWA CYKLICZNA---------");

        OneWayCycledList<Student> listaJednokierunkowaCykliczna = new OneWayCycledList<>();

        listaJednokierunkowaCykliczna.addBeg(student1);
        listaJednokierunkowaCykliczna.addBeg(student2);
        listaJednokierunkowaCykliczna.addBeg(student3);
        listaJednokierunkowaCykliczna.addBeg(student4);
        listaJednokierunkowaCykliczna.addEnd(student5);


        listaJednokierunkowaCykliczna.addAfter(student6, "124", Student::getIndex);
        listaJednokierunkowaCykliczna.addBefore(student7, "127", Student::getIndex);
        listaJednokierunkowaCykliczna.remove("Anna", Student::getFirstName);

        // posortowanie listy
        System.out.println("(posortowane po imieniu)");
        listaJednokierunkowaCykliczna.bubbleSortByKey(Student::getFirstName);
        System.out.println();

        // przejscie po liscie
        for (Student student : listaJednokierunkowaCykliczna) {
            System.out.println(student);
        }


        // -------TEST LISTA DWUKIERUNKOWA CYKLICZNA---------

        System.out.println();
        System.out.println("-------TEST LISTA DWUKIERUNKOWA CYKLICZNA---------");

        TwoWayCycledList<Student> listaDwukierunkowaCykliczna = new TwoWayCycledList<>();

        listaDwukierunkowaCykliczna.addBeg(student1);
        listaDwukierunkowaCykliczna.addBeg(student2);
        listaDwukierunkowaCykliczna.addBeg(student3);
        listaDwukierunkowaCykliczna.addBeg(student4);
        listaDwukierunkowaCykliczna.addEnd(student5);

        listaDwukierunkowaCykliczna.addAfter(student6, "124", Student::getIndex);
        listaDwukierunkowaCykliczna.addBefore(student7, "127", Student::getIndex);
        listaDwukierunkowaCykliczna.remove("Anna", Student::getFirstName);

        // posortowanie listy wedlug klucza
        System.out.println("(posortowane po nazwisku)");
        listaDwukierunkowaCykliczna.bubbleSortByKey(Student::getLastName);
        System.out.println();

        // przejscie po liscie
        for(Student student : listaJednokierunkowaCykliczna) {
            System.out.println(student);
        }

        System.out.println();

        // przejscie po liscie od konca
        ListIterator<Student> iteratorDC = listaDwukierunkowaCykliczna.listIterator();

        while (iteratorDC.hasPrevious()) {
            System.out.println(iteratorDC.previous());
        }
    }
}