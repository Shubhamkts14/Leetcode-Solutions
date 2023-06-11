import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SnapshotArray {
    private List<TreeMap<Integer, Integer>> snapshots;
    private int snapId;

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0); // Initialize with snap_id 0 and value 0
            snapshots.add(map);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        snapshots.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> map = snapshots.get(index);
        // Find the closest previous snapshot id
        Integer prevSnapId = map.floorKey(snapId);
        return map.get(prevSnapId);
    }
}