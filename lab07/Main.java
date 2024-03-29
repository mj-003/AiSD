import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        TreeUserInterface.main(args);


//        Comparator<Student> idComparator = Comparator.comparingInt(Student::getId);
//        BST<Student> studentBST = new BST<>(idComparator);
//
//        Student s1 = new Student(1, "Anna", "Kowalska");
//        Student s2 = new Student(2, "Cnna", "Lowalska");
//        Student s3 = new Student(3, "Dnna", "Mowalska");
//        Student s4 = new Student(4, "Enna", "Nowalska");
//        Student s5 = new Student(5, "Fnna", "Oowalska");
//        Student s6 = new Student(6, "Gnna", "Powalska");
//        Student s7 = new Student(7, "Gnna", "Powalska");
//        Student s8 = new Student(8, "Gnna", "Powalska");
//        Student s9 = new Student(9, "Gnna", "Powalska");
//        Student s10 = new Student(10, "Gnna", "Powalska");
//        Student s11 = new Student(11, "Gnna", "Powalska");
//
//
//        // ----- DRZEWO BST -----
//
//        // dodawanie studentow
//        studentBST.insert(s3);
//        studentBST.insert(s1);
//        studentBST.insert(s5);
//        studentBST.insert(s4);
//        studentBST.insert(s6);
//        studentBST.insert(s2);
//
//        // wypisywanie struktury drzewa
//        System.out.println("wypisywanie struktury drzewa:");
//        System.out.println(studentBST);
//
//        // wypisywanie studentow
//        System.out.println("wypisywanie studentow post order:");
//        studentBST.printPostOrder();
//        System.out.println();
//        System.out.println();
//
//        // usuwanie studentow
//        System.out.println("usuwanie studenta s5:");
//        studentBST.delete(s5);
//        System.out.println(studentBST);
//
//        // studentBST.print("", studentBST.ROOT, false);
//
//        // szukanie studentow
//        System.out.println("szukanie studenta s2: ");
//        System.out.println("indeks: " + studentBST.search(s2));

        // ----- DRZEWO RBTree -----

//        RBTree<Student> studentRBT = new RBTree<>(idComparator);
//
//        // dodawanie studentow
//        studentRBT.insert(s1);
//        studentRBT.insert(s2);
//        studentRBT.insert(s3);
//        studentRBT.insert(s4);
//        studentRBT.insert(s5);
//        studentRBT.insert(s6);
//        studentRBT.insert(s7);
//        studentRBT.insert(s8);
//        studentRBT.insert(s9);
//        studentRBT.insert(s10);
//        studentRBT.insert(s11);
//
//        // wypisanie struktury drzewa
//        System.out.println("wypisywanie struktury drzewa:");
//        System.out.println(studentRBT);
//
//        // usuwanie studentow
//        System.out.println("usuwanie studenta s3:");
//        studentRBT.delete(s6);
//        System.out.println(studentRBT);
//
//        System.out.println("szukanie studenta s2: ");
//        //System.out.println("indeks: " + studentRBT.search(s2));
//
//        Comparator<Integer> comparator = Comparator.naturalOrder();
//
//        RBTree<Integer> studentRBTree = new RBTree<>(comparator);
//        studentRBTree.insert(1);
//        studentRBTree.insert(2);
//        studentRBTree.insert(3);
//        studentRBTree.insert(4);
//        studentRBTree.insert(5);
//        studentRBTree.insert(6);
//        studentRBTree.insert(7);
//        studentRBTree.insert(8);
//        studentRBTree.insert(9);
//        studentRBTree.insert(10);
//        studentRBTree.insert(11);
//        studentRBTree.insert(12);
//        studentRBTree.insert(13);
//        studentRBTree.insert(14);
//        studentRBTree.insert(15);
//        studentRBTree.insert(16);
//        studentRBTree.insert(17);
//        studentRBTree.insert(18);
//        studentRBTree.delete(12);
//        studentRBTree.delete(8);
//
//        System.out.println(studentRBTree);















    }
}