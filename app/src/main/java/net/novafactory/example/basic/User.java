package net.novafactory.example.basic;

import android.graphics.drawable.Drawable;

/**
 * @author nova
 */
public class User {
    private final Drawable profile;
    private final String firstName;
    private final String lastName;

    public User(Drawable profile, String firstName, String lastName) {
        this.profile = profile;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Drawable getProfile() {
        return profile;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}