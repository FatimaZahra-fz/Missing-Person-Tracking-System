
package missingpersonproject;

public class Person {

    private String id;
    private String name;
    private int age;
    private String city;
    private String identificationMark;

    public Person(String id, String name, int age, String city, String identificationMark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.identificationMark = identificationMark;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getIdentificationMark() {
        return identificationMark;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", City: " + city +
                ", Mark: " + identificationMark;
    }
}