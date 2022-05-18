public abstract class Device implements Comparable{

    private String brand;
    private int price;

    public Device(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }


    public String toString() {
        return  this.brand  + ", " + this.price + " lv;";

    }
    public String getString() {
        return toString();
    }


    public String printBaseDevice(String keyWord, String middleWord) {
        return keyWord + ": " + this.brand + ", " + middleWord + ", " + this.price + " lv;";
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
