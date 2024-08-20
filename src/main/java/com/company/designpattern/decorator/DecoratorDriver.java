package com.company.designpattern.decorator;


// Component interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete component
class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Main Decorator abstract class ( is a ) Pizza
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// Concrete decorator 1
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}

// Concrete decorator 2
class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.0;
    }
}
public class DecoratorDriver {
        public static void main(String[] args) {
            // Creating a basic pizza
            Pizza basicPizza = new BasicPizza();
            System.out.println("Description: " + basicPizza.getDescription());
            System.out.println("Cost: $" + basicPizza.getCost());

            // Adding cheese
            Pizza cheesePizza = new CheeseDecorator(basicPizza);
            System.out.println("Description: " + cheesePizza.getDescription());
            System.out.println("Cost: $" + cheesePizza.getCost());

            // Adding pepperoni
            Pizza pepperoniPizza = new PepperoniDecorator(basicPizza);
            System.out.println("Description: " + pepperoniPizza.getDescription());
            System.out.println("Cost: $" + pepperoniPizza.getCost());

            // Adding both cheese and pepperoni
            Pizza deluxePizza = new PepperoniDecorator(new CheeseDecorator(basicPizza));
            System.out.println("Description: " + deluxePizza.getDescription());
            System.out.println("Cost: $" + deluxePizza.getCost());
        }
}

