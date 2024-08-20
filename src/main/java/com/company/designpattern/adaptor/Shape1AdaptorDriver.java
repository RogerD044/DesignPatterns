package com.company.designpattern.adaptor;

public class Shape1AdaptorDriver {
    // Target interface
    interface Shape {
        void drawShape();
        void resizeShape();
    }

    // Adaptee class
    class Rectangle {
        public void draw() {
            System.out.println("Drawing Rectangle");
        }

        public void resize() {
            System.out.println("Resizing Rectangle");
        }
    }

    // Adapter class
    class ShapeAdapter implements Shape {
        // HAS A relation
        private Rectangle rectangle;

        public ShapeAdapter(Rectangle rectangle) {
            this.rectangle = rectangle;
        }

        @Override
        public void drawShape() {
            rectangle.draw();
        }

        @Override
        public void resizeShape() {
            rectangle.resize();
        }
    }

    // Client code
    public class Main {
        public void main(String[] args) {
            // Creating a Rectangle object
            Rectangle rectangle = new Rectangle();

            // Creating an adapter object to use Rectangle as Shape
            Shape shapeAdapter = new ShapeAdapter(rectangle);

            // Using the adapter to draw and resize the shape
            shapeAdapter.drawShape();
            shapeAdapter.resizeShape();
        }
    }

}
