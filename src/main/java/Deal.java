public class Deal implements Comparable<Deal> {
    private final Integer length;
    private final Integer width;
    private final Integer price;

    public Deal(int length, int width, int price) {
        this.length = length;
        this.width = width;
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Цена: " + price +
                " Длинна участка: " + length +
                " Ширина участка: " + width;
    }

    @Override
    public int compareTo(Deal o) {
        return this.price.compareTo(o.getPrice());
    }
}
