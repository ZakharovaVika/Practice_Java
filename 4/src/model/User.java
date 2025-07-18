package model;

import annotations.JsonField;

public class User {
    @JsonField(name = "userId")
    private int id;

    @JsonField(name = "userName")
    private String name;

    @JsonField(name = "userEmail")
    private String email;

    private String internalNotes; // Это поле не будет сериализовано

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.internalNotes = "Private info";
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", internalNotes='" + internalNotes + '\'' +
                '}';
    }

}
