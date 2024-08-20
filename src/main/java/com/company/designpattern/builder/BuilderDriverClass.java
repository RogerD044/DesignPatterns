package com.company.designpattern.builder;

public class BuilderDriverClass {

    // Product class
    class Computer {
        // Required parameters
        private String processor;
        private String ram;

        // Optional parameters
        private String storage;
        private String graphicsCard;

        public Computer(String processor, String ram, String storage, String graphicsCard) {
            this.processor = processor;
            this.ram = ram;
            this.storage = storage;
            this.graphicsCard = graphicsCard;
        }

        // Getters for various components
        public String getProcessor() {
            return processor;
        }

        public String getRam() {
            return ram;
        }

        public String getStorage() {
            return storage;
        }

        public String getGraphicsCard() {
            return graphicsCard;
        }
    }

    // Builder interface
    interface ComputerBuilder {
        Computer build();
    }

    // Concrete builder
    class MyComputerBuilder implements ComputerBuilder {
        // Required parameters
        private String processor;
        private String ram;

        // Optional parameters
        private String storage = "500GB HDD";
        private String graphicsCard = "Integrated Graphics";

        public MyComputerBuilder(String processor, String ram) {
            this.processor = processor;
            this.ram = ram;
        }

        public MyComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public MyComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        @Override
        public Computer build() {
            return new Computer(processor, ram, storage, graphicsCard);
        }
    }

    // Director class (optional)
    class ComputerDirector {
        private ComputerBuilder computerBuilder;

        public ComputerDirector(ComputerBuilder computerBuilder) {
            this.computerBuilder = computerBuilder;
        }

        public Computer constructComputer() {
            return computerBuilder.build();
        }
    }

    // Client code
    public class Main {
        public void main(String[] args) {
            // Using builder to construct a computer
            ComputerBuilder computerBuilder = new MyComputerBuilder("Intel Core i7", "16GB DDR4").setStorage("1TB SSD");

            Computer computer = ((MyComputerBuilder) computerBuilder).setStorage("1TB SSD").setGraphicsCard("NVIDIA GeForce GTX 1650").build();

            // Output the details of the constructed computer
            System.out.println("Processor: " + computer.getProcessor());
            System.out.println("RAM: " + computer.getRam());
            System.out.println("Storage: " + computer.getStorage());
            System.out.println("Graphics Card: " + computer.getGraphicsCard());
        }
    }

}
