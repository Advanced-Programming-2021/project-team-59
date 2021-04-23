public class Monster extends Card {

    int attackPower;
    int defencePower;
    int level;

    public Monster(String name, Type type) {
        super(name, type);
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {

        return "Name: " + this.getName() +
                "\nLevel: " + level +
                "\nType: " + this.getType() +
                "\nATK: " + attackPower +
                "\nDEF: " + defencePower +
                "\nDescription: " + this.getDescription();
    }

}
