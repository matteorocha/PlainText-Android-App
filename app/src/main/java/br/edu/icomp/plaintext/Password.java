package br.edu.icomp.plaintext;

public class Password {
    private int id;
    private final String name;
    private final String login;
    private final String password;
    private final String notes;

    public Password(int id, String name, String login, String password, String notes) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.notes = notes;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getNotes() { return notes; }

    // Setters
    public void setId(int id) { this.id = id; }
}
