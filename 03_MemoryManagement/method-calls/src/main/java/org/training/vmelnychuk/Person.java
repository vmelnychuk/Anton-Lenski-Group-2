package org.training.vmelnychuk;



public class Person {
    private static final String DEFAULT_NAME = "Anonymous";
    private static final int DEFAULT_NUMBER = 42;
    private String name;
    private int favoriteNumber;
    public Person() {
        this.name = DEFAULT_NAME;
        this.favoriteNumber = DEFAULT_NUMBER;
    }
    public Person(String name, int favoriteNumber) {
        this.name = name;
        this.favoriteNumber = favoriteNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " { name='" + name + '\'' +
                ", favoriteNumber=" + favoriteNumber +
                '}';
    }
}
