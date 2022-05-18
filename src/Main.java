import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Catalogue cat = new Catalogue();

        cat.loadFromFile("D:\\Programming\\Projects\\Devices\\src\\file.txt");

        // 1. Prints catalogue in the following format: " Tablet: Lenovo, Black, 25.4 cm, 450 lv; ".
        cat.printCatalogue();
        System.out.println("=======================================================");

        // 2. Sort descending
        System.out.println("Catalogue sorted by price - descending");
        Collections.sort(cat.getList());
        System.out.println(cat.getList());
        System.out.println("=======================================================");

        // 3.
        cat.findItemsNumAvgPriceAndmaxPrice();
        System.out.println("=======================================================");

        // 4.
        cat.chooseBrand();
        FileOperations.writeCatalogueToFile(cat, "D:\\Programming\\Projects\\Devices\\src\\forWritting.txt");

        // Check if the selected brand items are from one type
        cat.checkType();

    }
}
