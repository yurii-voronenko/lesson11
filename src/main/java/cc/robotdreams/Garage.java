package cc.robotdreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Garage
{
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Static
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static final public String CONST_GREEN     = "green";
    static final public String CONST_CAR       = "car";
    static final public String CONST_BICYCLE   = "bicycle";
    static private int counter = 0;

    static public Garage create(byte[] name) {
        return new Garage(name);
    }

    static public Garage create(String name) {
        return new Garage(name);
    }

    static public int getCount() {
        return counter;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Object
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    final public int number;
    final public String name;
    final private List<Vehicle> items = new ArrayList<>();

    public Garage() {  // void
        this("Default");
    }

    public Garage(byte[] name) {
        this(new String(name));
    }

    public Garage(String name) {
        System.out.println("Create garage object \"" + name + "\"");
        this.name = name;
        this.number = ++ Garage.counter;
    }

    protected Garage add(char[] itemName) { // add(byte[])
        return add(new String(itemName));
    }

    protected Garage add(String itemName) { // add(String)
        this.items.add(new Vehicle(itemName));
        return this; // Object
    }

    public List<String> getItems() {
        return this.items.stream().map(i -> i.name).collect(Collectors.toList());
    }

    public List<String> filterItems(String textContains) {
        return this.getItems().stream().filter(
                item -> item.toLowerCase().contains(textContains)
        ).collect(Collectors.toList());
    }

    public List<String> getOnlyGreen() {
        return this.filterItems(CONST_GREEN);
    }

    public List<String> getOnlyCars() {
        return this.filterItems(CONST_CAR);
    }

    public List<String> getOnlyBicycles() {
        return this.filterItems(CONST_BICYCLE);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " number " + this.number + " <" + this.name + "> : " + this.getItems();
    }
}
