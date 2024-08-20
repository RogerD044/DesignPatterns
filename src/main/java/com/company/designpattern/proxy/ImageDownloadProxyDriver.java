package com.company.designpattern.proxy;

public class ImageDownloadProxyDriver {
    // Subject interface
    interface Image {
        void display();
    }

    // Real subject
    class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image from disk: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Proxy
    class ImageProxy implements Image {
        private String filename;

        // Proxy HAS A Real Image
        private RealImage realImage;

        public ImageProxy(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            // Proxy, Can add authentication (access restrictor) to not reach RealImage class

            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }


    public void drive() {
        // Using real image
        Image realImage = new RealImage("test.jpg");
        realImage.display();

        // Using proxy
        Image proxyImage = new ImageProxy("test.jpg");
        proxyImage.display();
    }


}
