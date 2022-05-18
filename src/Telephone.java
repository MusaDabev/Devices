public class Telephone extends Device{
    private int cameraNumber;
    private int releaseYear;

    private final String KEYWORD = "Phone";

    public Telephone(String brand, int price, int cameraNumber, int releaseYear ) {
        super(brand, price);
        this.cameraNumber = cameraNumber;
        this.releaseYear = releaseYear;
    }

    @Override
    public int compareTo(Object comparestu) {
        int comparage = ((Device)comparestu).getPrice();
        return comparage-this.getPrice();
       // return this.getPrice()-comparage;

    }

    public int getCameraNumber() {
        return cameraNumber;
    }

    public void setCameraNumber(int cameraNumber) {
        this.cameraNumber = cameraNumber;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String toString() {
        String middleWord = this.getCameraNumber() +  " cam., " + this.getReleaseYear();
        return super.printBaseDevice(KEYWORD, middleWord);
    }
}
