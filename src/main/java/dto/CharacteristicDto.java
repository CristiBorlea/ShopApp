package dto;

public class CharacteristicDto {
    private String name;
    private String value;

    /**
     * This class is handling data for characteristics
     *
     * @author Cristi Borlea
     * @version 1.0
     */
    public CharacteristicDto() {

    }

    public CharacteristicDto(String name, String value) {
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

    @Override
    public String toString() {
        return "<table balign=\"center\", border=\"1\">" +
                "<td>" + name + "</td>" +
                "<td>" + value + "</td>" +
                " </table>";
    }
}
