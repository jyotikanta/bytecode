package interviews.prep.company.epam;

//LISKOV violation
class Rectangle {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

public class Main {
    public static void modifyRectangle(Rectangle rectangle) {
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        if (rectangle.getArea() != 20) {
            System.out.println("Unexpected behavior: Area should be 20, but it's " + rectangle.getArea());
        } else {
            System.out.println("Expected behavior: Area is 20");
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3, 3);
        Square square = new Square(3);

        System.out.println("Testing with Rectangle:");
        modifyRectangle(rectangle);

        System.out.println("\nTesting with Square:");
        modifyRectangle(square);
    }
}
