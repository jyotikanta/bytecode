package interviews.prep.company.epam;
import java.util.*;

public class TripTicketSequencer {
    public static void main(String[] args) {
        List<String> tripTickets = Arrays.asList("KOL-BOM", "BOM-DEL", "HYD-KOL");
        List<String> sortedTickets = sortTickets(tripTickets);

        for (String ticket : sortedTickets) {
            System.out.print(ticket + " ");
        }
    }

    public static List<String> sortTickets(List<String> tickets) {
        Map<String, String> map = new HashMap<>();
        Set<String> arrivals = new HashSet<>();

        // Populate map and set of arrival cities
        for (String ticket : tickets) {
            String[] parts = ticket.split("-");
            String departure = parts[0];
            String arrival = parts[1];
            map.put(departure, arrival);
            arrivals.add(arrival);
        }

        // Find the starting city (a city that is not an arrival)
        String start = null;
        for (String departure : map.keySet()) {
            if (!arrivals.contains(departure)) {
                start = departure;
                break;
            }
        }

        // Follow the chain from the start city
        List<String> result = new ArrayList<>();
        while (start != null) {
            String next = map.get(start);
            if (next != null) {
                result.add(start + "-" + next);
            }
            start = next;
        }

        return result;
    }
}
