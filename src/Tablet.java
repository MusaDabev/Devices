public class Tablet extends Device{
    private String color;
    private float diagonal;

    private final String KEYWORD = "Tablet";

    public Tablet(String brand, String color, float diagonal, int price) {

        super(brand, price);
        this.color = color;
        this.diagonal = diagonal;
    }


    @Override
    public int compareTo(Object comparestu) {
        int comparage = ((Device)comparestu).getPrice();
        return comparage-this.getPrice();
        //return this.getPrice()-comparage;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public String toString() {
        String middleWord = this.getColor() +  ", " + this.getDiagonal() + " cm";
        return super.printBaseDevice(KEYWORD, middleWord);
    }
}
