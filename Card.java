public class Card {
    private String name;
    private String description;
    private Boolean isOccupied;
    private Boolean isAttackPosition;
    private Boolean isSelected;
    private Type type;


    public Card(String name, Type type) {
        setName(name);
        setType(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public void setAttackPosition(Boolean attackPosition) {
        isAttackPosition = attackPosition;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public Boolean getAttackPosition() {
        return isAttackPosition;
    }

}
