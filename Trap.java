public class Trap extends Card {

    public Trap(String name, Type type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nTrap" +
                "\nType: " + this.getType() +
                "\nDescription: " + this.getDescription();
    }
}
