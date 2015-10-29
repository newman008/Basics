package designModes;

// Product
class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough)     { this.dough = dough; }
    public void setSauce(String sauce)     { this.sauce = sauce; }
    public void setTopping(String topping) { this.topping = topping; }
}

// Abstract Builder
abstract class PizzaBuilder {
    protected Pizza pizza;
    public Pizza getPizza() {return pizza;}
    public void createNewPizzaProduct() { pizza = new Pizza(); }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
  public void buildDough()   { pizza.setDough("cross"); }
  public void buildSauce()   { pizza.setSauce("mild"); }
  public void buildTopping() { pizza.setTopping("ham+pineapple"); }
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
  public void buildDough()   { pizza.setDough("pan baked"); }
  public void buildSauce()   { pizza.setSauce("hot"); }
  public void buildTopping() { pizza.setTopping("pepperoni+salami"); }
}

/* "Director" */
class Waiter {
  private PizzaBuilder pizzaBuilder;

  public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
  public Pizza getPizza() { return pizzaBuilder.getPizza(); }

  public void constructPizza() {
    pizzaBuilder.createNewPizzaProduct();
    pizzaBuilder.buildDough();
    pizzaBuilder.buildSauce();
    pizzaBuilder.buildTopping();
  }
}

public class Builder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Waiter waiter = new Waiter(); // create Director
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder(); // create ConcreteBuilder
        
        waiter.setPizzaBuilder(hawaiian_pizzabuilder);
        waiter.constructPizza();
        
        Pizza pizza = waiter.getPizza();
    }

}
