package com.company.designpattern.facade;

public class ComputerFacadeDriver {
    // Subsystem classes
    class CPU {
        public void start() {
            System.out.println("CPU started");
        }

        public void shutdown() {
            System.out.println("CPU shutdown");
        }
    }

    class Memory {
        public void load() {
            System.out.println("Memory loaded");
        }

        public void clear() {
            System.out.println("Memory cleared");
        }
    }

    class HardDrive {
        public void readData() {
            System.out.println("Data read from hard drive");
        }

        public void writeData() {
            System.out.println("Data written to hard drive");
        }
    }

    // Facade class
    class ComputerFacade {
        private CPU cpu;
        private Memory memory;
        private HardDrive hardDrive;

        public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.hardDrive = new HardDrive();
        }

        public void startComputer() {
            cpu.start();
            memory.load();
            hardDrive.readData();
            System.out.println("Computer started");
        }

        public void shutdownComputer() {
            cpu.shutdown();
            memory.clear();
            hardDrive.writeData();
            System.out.println("Computer shutdown");
        }
    }

    // Client code
    public class Main {
        public void main(String[] args) {
            // Using the facade to start and shutdown the computer
            ComputerFacade computerFacade = new ComputerFacade();
            computerFacade.startComputer();
            System.out.println("------------------------------------------------");
            computerFacade.shutdownComputer();
        }
    }

}
