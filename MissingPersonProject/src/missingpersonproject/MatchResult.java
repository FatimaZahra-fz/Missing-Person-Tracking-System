
package missingpersonproject;

public class MatchResult {

    private Person missingPerson;
    private Person foundPerson;

    public MatchResult(Person missingPerson, Person foundPerson) {
        this.missingPerson = missingPerson;
        this.foundPerson = foundPerson;
    }

    public Person getFoundPerson() {
        return foundPerson;
    }

    public void displayMatch() {

        System.out.println("\n===== MATCH FOUND =====");

        System.out.println("Missing Person:");
        System.out.println(missingPerson);

        System.out.println("\nFound In Another City:");
        System.out.println(foundPerson);

        System.out.println("=======================");
    }
}