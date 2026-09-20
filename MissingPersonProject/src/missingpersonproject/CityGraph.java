
package missingpersonproject;

import java.util.*;

public class CityGraph {

    private HashMap<String, ArrayList<String>> graph;

    public CityGraph() {

        graph = new HashMap<>();
    }

    public void addCity(String city) {

        graph.putIfAbsent(
                city.toLowerCase().trim(),
                new ArrayList<>()
        );
    }

    public void connectCities(
            String city1,
            String city2
    ) {

        city1 = city1.toLowerCase().trim();

        city2 = city2.toLowerCase().trim();

        graph.get(city1).add(city2);

        graph.get(city2).add(city1);
    }

    public String findRoute(
            String start,
            String destination
    ) {

        start = start.toLowerCase().trim();

        destination = destination.toLowerCase().trim();

        if (!graph.containsKey(start)
                || !graph.containsKey(destination)) {

            return "City not found";
        }

        Queue<String> queue =
                new LinkedList<>();

        HashSet<String> visited =
                new HashSet<>();

        HashMap<String, String> parent =
                new HashMap<>();

        queue.add(start);

        visited.add(start);

        while (!queue.isEmpty()) {

            String current =
                    queue.poll();

            if(current.equals(destination)){

                break;
            }

            for(String nextCity :
                    graph.get(current)){

                if(!visited.contains(nextCity)){

                    visited.add(nextCity);

                    parent.put(
                            nextCity,
                            current
                    );

                    queue.add(nextCity);
                }
            }
        }

        if(!visited.contains(destination)){

            return "No route found";
        }

        ArrayList<String> path =
                new ArrayList<>();

        String current =
                destination;

        while(current != null){

            path.add(
                    0,
                    capitalize(current)
            );

            current =
                    parent.get(current);
        }

        return String.join(
                " -> ",
                path
        );
    }

    private String capitalize(
            String text
    ){

        return text.substring(0,1)
                .toUpperCase()
                + text.substring(1);
    }
}