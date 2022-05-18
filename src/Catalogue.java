import java.sql.Array;
import java.util.*;

public class Catalogue {

    ArrayList<Device> list = new ArrayList<>();
    ArrayList<Device> byBrand = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    public void loadFromFile(String path) {
        ArrayList<String> rows = FileOperations.readFileByRow(path);
        for (int i = 1; i < rows.size() + 1; i++) {
            Device device = Parser.getObjectFromRow(rows.get(i - 1));
            if (device != null) {
                addDevice(device);
            } else {
                System.out.println("No device type is recognize at row: " + i);
            }
        }//end for
        System.out.println("Objects loaded from file: " + list.size());
    }//end loadFromFile




    public void addDevice(Device device) {
        list.add(device);
    }

    public void printCatalogue() {
        for (Device device : list) {
            System.out.println(device);
        }
    }

    public ArrayList<Device> getList() {
        return list;
    }

    public ArrayList<Device> getByBrand() {
        return byBrand;
    }

    public void findItemsNumAvgPriceAndmaxPrice() {

        System.out.println("Choose 'T' for Tablet or 'P' for phone: ");
        String choice = scanner.next().toLowerCase();
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> tablets = new ArrayList<>();

        ArrayList<Integer> phonesPrice = new ArrayList<>();
        ArrayList<Integer> tabletsPrice = new ArrayList<>();

             for (Device device : list) {
                 String[] deviceCont =  device.getString().split(", ");
                 String type = deviceCont[0].split(" ")[0].replace(":", "");

                 int price = Integer.parseInt(deviceCont[3].replace(" lv;", ""));

                 if (choice.equals("p") && type.equals("Phone")) {
                     phones.add(type);
                     phonesPrice.add(price);


                 } else if (choice.equals("t") && type.equals("Tablet")) {
                     tablets.add(type);
                     tabletsPrice.add(price);

                 } else if (! choice.equals("t") && ! choice.equals("p")) {
                     System.out.println("Invalid choice!");
                 }
             }

             if (choice.equals("t")) {
                 System.out.printf("Number of tablets: %s %n", tablets.size());

                 Collections.sort(tabletsPrice);

                 int maxPrice =  tabletsPrice.get(tabletsPrice.size()-1);

                 int total =  0;
                 for (int i = 0; i<=tabletsPrice.size() - 1; i++ ) {
                     total += tabletsPrice.get(i);
                 }

                 int avg = total / tabletsPrice.size();
                 System.out.printf("Average price: %d %n",avg);

                 System.out.printf("The most expensive item costs: %d lv. %n", maxPrice);


             } else if (choice.equals("p")) {
                 System.out.printf("Number of phones: %s %n", phones.size());

                 Collections.sort(phonesPrice);
                 int maxPrice =  phonesPrice.get(phonesPrice.size()-1);

                 int total =  0;
                 for (int i = 0; i<=phonesPrice.size() - 1; i++ ) {
                     total += phonesPrice.get(i);
                 }

                 int avg = total / phonesPrice.size();
                 System.out.printf("Average price: %d %n",avg);
                 System.out.printf("The most expensive item costs: %d lv. %n", maxPrice);


             } else {
                 System.out.println("Invalid choice!");
             }

    }



    public ArrayList<Device> chooseBrand () {

        System.out.println("Choose a brand: ");

        String choice = scanner.next();

        for ( Device device : list) {


            if (device.getBrand().toLowerCase().equals(choice.toLowerCase())) {
                byBrand.add(device);
            }
        }
        if (byBrand.size() == 0) {
            System.out.println("Brand not found!");
        } else {
            System.out.println(byBrand);
        }

        return byBrand;

    }

    public void checkType () {
       Set<String> types = new HashSet<>();

       for (Device device : byBrand) {

           String[] deviceCont =  device.getString().split(", ");
           String type = deviceCont[0].split(" ")[0].replace(":", "");

           types.add(type);

       }

       if (types.size() == 1) {
           System.out.println("One type");
       } else if (types.size() > 1) {
           System.out.println("More types");
       } else {
           System.out.println("No types found");
       }
    }



}
