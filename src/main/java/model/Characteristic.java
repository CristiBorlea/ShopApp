package model;

/**
 * This class is handling data for characteristic entity
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class Characteristic {

    private String name;
    private String value;

    public Characteristic(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
