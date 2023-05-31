import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, Map<String, TripInfo>> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkIns.get(id);
        String startStation = checkInInfo.stationName;
        int startTime = checkInInfo.time;

        TripInfo tripInfo = trips.computeIfAbsent(startStation, k -> new HashMap<>())
                .computeIfAbsent(stationName, k -> new TripInfo());

        tripInfo.totalTime += t - startTime;
        tripInfo.count++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        TripInfo tripInfo = trips.get(startStation).get(endStation);
        return (double) tripInfo.totalTime / tripInfo.count;
    }

    private static class CheckInInfo {
        String stationName;
        int time;

        public CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class TripInfo {
        int totalTime;
        int count;
    }
}
