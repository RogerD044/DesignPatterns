package com.company.designpattern.adaptor;

public class Shape2AdaptorDriver {

    // Target interface (client expects this)
    interface Shape {
        void draw();
    }

    // Legacy class with incompatible interface
    class LegacyShape {
        public void legacyDraw() {
            System.out.println("Drawing legacy shape");
        }
    }

    // Adapter class using composition (Object Adapter)
    class LegacyShapeAdapter implements Shape {

        // HAS A relation
        private LegacyShape legacyShape;

        public LegacyShapeAdapter(LegacyShape legacyShape) {
            this.legacyShape = legacyShape;
        }

        @Override
        public void draw() {
            legacyShape.legacyDraw(); // Translate draw() to legacyDraw()
        }
    }

    // Client using the adapter
    public class Client {

        public void main(String[] args) {
            LegacyShape legacyShape = new LegacyShape();
            Shape shape = new LegacyShapeAdapter(legacyShape);
            shape.draw();
        }
    }

}
