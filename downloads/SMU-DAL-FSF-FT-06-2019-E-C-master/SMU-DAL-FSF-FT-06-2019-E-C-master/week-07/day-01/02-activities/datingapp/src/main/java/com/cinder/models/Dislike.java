package com.cinder.models;

public class Dislike {

    private int id;
    private int personId;

    public Dislike() { }

    public Dislike(int id, int personId) {
        this.id = id;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
