package model;

/**
 * This class is handling data for review entity
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class Review {

    private int id;
    private String text;
    private String username;
    private String email;


    public Review(int id, String text, String username, String email) {
        this.id = id;
        this.text = text;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "<table balign=\"center\", border=\"1\">" +
                "<td>" + text + "</td>" +
                " </table>";
    }
}
