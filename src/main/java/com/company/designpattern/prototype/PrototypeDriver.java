package com.company.designpattern.prototype;

public class PrototypeDriver {
    // Prototype interface
    interface Shape extends Cloneable {
        Shape clone();

        void draw();
    }

    // Concrete prototype 1
    class Circle implements Shape {
        private String color;
        private int x;
        private int y;
        private int radius;

        public Circle(String color, int x, int y, int radius) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        @Override
        public Shape clone() {
            return new Circle(this.color, this.x, this.y, this.radius);
        }

        @Override
        public void draw() {
            System.out.println("Drawing Circle: Color=" + color + ", x=" + x + ", y=" + y + ", radius=" + radius);
        }
    }

    // Concrete prototype 2
    class Rectangle implements Shape {
        private String color;
        private int x;
        private int y;
        private int width;
        private int height;

        public Rectangle(String color, int x, int y, int width, int height) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public Shape clone() {
            return new Rectangle(this.color, this.x, this.y, this.width, this.height);
        }

        @Override
        public void draw() {
            System.out.println("Drawing Rectangle: Color=" + color + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height);
        }
    }

    // Client code
    public class Main {
        public void main(String[] args) {
            Shape circlePrototype = new Circle("Red", 100, 100, 50);
            Shape rectanglePrototype = new Rectangle("Blue", 200, 200, 100, 50);

            // Cloning the prototypes
            Shape clonedCircle = circlePrototype.clone();
            Shape clonedRectangle = rectanglePrototype.clone();

            // Drawing cloned shapes
            clonedCircle.draw();
            clonedRectangle.draw();
        }
    }

}
