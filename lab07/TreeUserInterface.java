import java.util.Comparator;
import java.util.Scanner;

public class TreeUserInterface {
    private static final int OPTION_BST = 1;
    private static final int OPTION_RBT = 2;
    private static final int OPTION_INSERT = 1;
    private static final int OPTION_DELETE = 2;
    private static final int OPTION_SEARCH = 3;
    private static final int OPTION_DISPLAY = 4;
    private static final int OPTION_EXIT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree<Integer> tree;
        Comparator<Integer> comparator = Comparator.naturalOrder();
        int treeOption;
        int option;

        System.out.println("Wybierz rodzaj drzewa:");
        System.out.println("1. Binary Search Tree (BST)");
        System.out.println("2. Red-Black Tree (RBT)");
        treeOption = scanner.nextInt();
        scanner.nextLine();

        if (treeOption == OPTION_BST) {
            tree = new BST<>(comparator);
            System.out.println("Wybrano Binary Search Tree (BST).");
        } else if (treeOption == OPTION_RBT) {
            tree = new RBTree<>(comparator);
            System.out.println("Wybrano Red-Black Tree (RBT).");
        } else {
            System.out.println("Nieprawidłowy wybór. Zamykanie programu.");
            return;
        }

        while (true) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj element");
            System.out.println("2. Usuń element");
            System.out.println("3. Wyszukaj element");
            System.out.println("4. Wyświetl drzewo");
            System.out.println("5. Wyjście");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case OPTION_INSERT -> {
                    System.out.print("Podaj wartość do dodania: ");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    tree.insert(value);
                    System.out.println("Dodano element " + value);
                }
                case OPTION_DELETE -> {
                    System.out.print("Podaj wartość do usunięcia: ");
                    int valueToDelete = scanner.nextInt();
                    scanner.nextLine();
                    tree.delete(valueToDelete);
                    System.out.println("Usunięto element " + valueToDelete);
                }
                case OPTION_SEARCH -> {
                    System.out.print("Podaj wartosc do sprawdzenia: ");
                    int valueToSearch = scanner.nextInt();
                    scanner.nextLine();
                    tree.search(valueToSearch);
                    System.out.println("Element " + valueToSearch + " znajduje sie w drzewie: " + tree.search(valueToSearch));
                }
                case OPTION_DISPLAY -> {
                    System.out.println("Drzewo:");
                    System.out.println(tree);
                }
                case OPTION_EXIT -> {
                    System.out.println("Zamykanie programu.");
                    return;
                }
                default -> System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }
}

