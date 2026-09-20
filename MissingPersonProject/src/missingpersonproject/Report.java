
package missingpersonproject;

public class Report {

    private Person person;
    private String reporterName;

    public Report(Person person, String reporterName) {
        this.person = person;
        this.reporterName = reporterName;
    }

    public Person getPerson() {
        return person;
    }

    public String getReporterName() {
        return reporterName;
    }
}