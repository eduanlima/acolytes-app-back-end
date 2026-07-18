package br.com.posterius.acolyteapp.entities.user;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private String role;

    private Role(String role) {
        this.role = role;
    }
}
