package model;

import security.Autenticable;

abstract public class User implements Autenticable {
    String name;
    String email;
    String password;
    boolean isActive;

    public User(String name, String email, String password, boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    @Override
    public boolean authenticate(String email,String password) {
        return this.password.equals(password) && this.email.equals(email) && isActive;
    }

    @Override
    public void setPassword(String password) {

    }
}
