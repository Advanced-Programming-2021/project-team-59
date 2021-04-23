public class Spell extends Card {

    public Spell(String name, Type type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nSpell" +
                "\nType: " + this.getType() +
                "\nDescription: " + this.getDescription();
    }
}
