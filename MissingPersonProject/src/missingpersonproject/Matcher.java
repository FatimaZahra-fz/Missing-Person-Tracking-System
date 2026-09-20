
package missingpersonproject;

public class Matcher {

    public boolean isMatch(Person p1, Person p2) {

        return p1.getName().equalsIgnoreCase(p2.getName()) &&
                p1.getAge() == p2.getAge() &&
                p1.getIdentificationMark().equalsIgnoreCase(
                        p2.getIdentificationMark()
                );
    }
}