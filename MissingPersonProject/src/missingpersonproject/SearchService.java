
package missingpersonproject;

import java.util.Map;

public class SearchService {

    private Matcher matcher;

    public SearchService() {
        matcher = new Matcher();
    }

    public MatchResult findMatch(Person person, ReportDatabase db) {

        for (Map.Entry<String, Report> entry : db.getAllReports().entrySet()) {

            Person other = entry.getValue().getPerson();

            if (!person.getId().equals(other.getId())) {

                if (matcher.isMatch(person, other)) {
                    return new MatchResult(person, other);
                }
            }
        }

        return null;
    }
}