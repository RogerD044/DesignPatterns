package com.company.designpattern.bridge;

public class BridgeDriver {
    // Abstraction (what to draw)
    interface Shape {
        void draw();
    }

    // Implementations (how to draw)
    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a circle");
        }
    }

    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a square");
        }
    }

    // Abstraction (how to fill)
    interface Color {
        void fill();
    }

    // Implementations (specific colors)
    class RedColor implements Color {
        @Override
        public void fill() {
            System.out.println("Filling with red color");
        }
    }

    class BlueColor implements Color {
        @Override
        public void fill() {
            System.out.println("Filling with blue color");
        }
    }

    // Concrete Abstraction - combines shape and color (uses bridge)
    class ColoredShapeBridge {
        // Possible to extend any shape
        private Shape shape;

        // Possible to extend ant implementation
        private Color color;

        public ColoredShapeBridge(Shape shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public void draw() {
            color.fill(); // Use bridge to delegate to color implementation
            shape.draw(); // Use bridge to delegate to shape implementation
        }
    }

    // Client (uses ColoredShape to combine functionalities)
    public class Client {

        public void main(String[] args) {
            Shape circle = new Circle();
            Shape square = new Square();

            Color red = new RedColor();
            Color blue = new BlueColor();

            ColoredShapeBridge redCircle = new ColoredShapeBridge(circle, red);
            ColoredShapeBridge blueSquare = new ColoredShapeBridge(square, blue);

            redCircle.draw(); // Output: Filling with red color, Drawing a circle
            blueSquare.draw(); // Output: Filling with blue color, Drawing a square
        }
    }

}
