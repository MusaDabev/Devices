public class Parser {
    public static Device getObjectFromRow(String row) {
        int index = row.indexOf(" ");
        String keyWord = row.substring(0, index);
        switch(keyWord) {
            case "Tablet:": return createTablet(row);
            case "Phone:": return createPhone(row);
            default : return null;
        }
    }

    private static Telephone createPhone(String row) {
        String[] parts = row.split(", ");
        String brand = parts[0].split(" ")[1];
        int cameraNumber = Integer.parseInt(parts[1].replace(" cam.", ""));
        int reliese = Integer.parseInt(parts[2]);
        int price = Integer.parseInt(parts[3].replace(" lv;", ""));
        return new Telephone (brand, price, cameraNumber, reliese);
    }

    private static Tablet createTablet(String row) {
        String[] parts = row.split(", ");
        String brand = parts[0].split(" ")[1];
        String color = parts[1];
        float diagonal = Float.parseFloat(parts[2].replace(" cm", ""));
        int price = Integer.parseInt(parts[3].replace(" lv;", ""));
        return new Tablet(brand, color, diagonal, price);
    }

}
