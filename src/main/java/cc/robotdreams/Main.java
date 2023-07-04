package cc.robotdreams;

public class Main
{
    public static void main(String[] args) {
        Garage garageHome = new Garage("Home");
        garageHome.add("Black car");
        garageHome.add("Green car")
                .add("Red car")
                .add("Yellow car")
                .add("Green bicycle");
        System.out.println(garageHome);
        System.out.println(garageHome.filterItems(Garage.CONST_GREEN));
        System.out.println(garageHome.getOnlyCars());
        System.out.println(garageHome.getOnlyBicycles());
        //garage.getItems().add("Plane");
        //System.out.println(garage.getItems());


        //Garage garageWork = Garage.create("Work");
        //garageWork.add("Yellow car");
        //System.out.println(garageWork);
//
        //System.out.println("Program was creating "+ Garage.getCount() + " objects of " + Garage.class + " during execution");


        // garageHome <--- Obj addr = 0x01
        // garage     <--- Obj addr = 0x01

        addGarageItems(garageHome);
        System.out.println(garageHome);



    }

    public static void addGarageItems(Garage garage) {
        // garage = new Garage();
        // garage     <--- Obj addr = 0x02
        garage.add("New car");
        garage.add("Modern car");
    }
}