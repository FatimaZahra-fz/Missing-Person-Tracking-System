
package missingpersonproject;

public class SystemManager {

    private CityGraph cityGraph;
    private ReportDatabase database;
    private SearchService searchService;

    public SystemManager() {

        cityGraph = new CityGraph();

        database = new ReportDatabase();

        searchService = new SearchService();

        initializeCities();
    }

    private void initializeCities() {

        cityGraph.addCity("Lahore");
        cityGraph.addCity("Islamabad");
        cityGraph.addCity("Karachi");
        cityGraph.addCity("Peshawar");

        cityGraph.connectCities(
                "Lahore",
                "Islamabad"
        );

        cityGraph.connectCities(
                "Islamabad",
                "Peshawar"
        );

        cityGraph.connectCities(
                "Lahore",
                "Karachi"
        );
    }

    public CityGraph getCityGraph() {
        return cityGraph;
    }

    public ReportDatabase getDatabase() {
        return database;
    }

    public SearchService getSearchService() {
        return searchService;
    }
}