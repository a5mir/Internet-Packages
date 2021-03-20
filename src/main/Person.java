package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private final StringProperty speed = new SimpleStringProperty(this, "speed", "");
    private final StringProperty data = new SimpleStringProperty(this, "data", "");
    private final StringProperty duration = new SimpleStringProperty(this, "speed", "");
    private final IntegerProperty id = new SimpleIntegerProperty(this, "speed", 0);

    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty adress = new SimpleStringProperty(this, "adress", "");

    public Person() {
    }

    private static int next_id = 0;

    public Person(String speed, String data, String duration, String firstName, String lastName, String adress) {
        this.speed.set(speed);
        this.data.set(data);
        this.duration.set(duration);
        this.id.set(++this.next_id);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.adress.set(adress);
    }

    public String getSpeed() {
        return speed.get();
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public String getDuration() {
        return duration.get();
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

}
