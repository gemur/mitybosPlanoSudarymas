package logic;

import java.util.LinkedList;

public class Doctor {
    String email;
    String name;
    String lastName;
    String password;
    public static LinkedList<Doctor> doctors = new LinkedList<Doctor>();

    public Doctor(String email, String password, String name, String lastName){
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        doctors.addLast(this);
    }
    public Doctor(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return this.email + " " + this.password + " " + this.name + " " + this.lastName;
    }
}
