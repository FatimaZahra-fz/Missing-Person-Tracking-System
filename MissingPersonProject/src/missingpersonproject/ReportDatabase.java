
package missingpersonproject;

import java.util.HashMap;

public class ReportDatabase {

    private HashMap<String, Report> reports;

    public ReportDatabase() {
        reports = new HashMap<>();
    }

    public void addReport(Report report) {
        reports.put(report.getPerson().getId(), report);
    }

    public Report searchById(String id) {
        return reports.get(id);
    }

    public HashMap<String, Report> getAllReports() {
        return reports;
    }
}