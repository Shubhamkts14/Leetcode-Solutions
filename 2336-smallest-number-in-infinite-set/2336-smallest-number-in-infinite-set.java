class SmallestInfiniteSet {
    private HashSet<Integer> isPresent;
    private PriorityQueue<Integer> addedIntegers;
    private int currentInteger;
    
    public SmallestInfiniteSet() {
        this.isPresent = new HashSet<>();
        this.addedIntegers = new PriorityQueue<>();
        this.currentInteger = 1;
    }
    
    public int popSmallest() {
        int answer;
        // If there are numbers in the min-heap, 
        // top element is lowest among all the available numbers.
        if (!this.addedIntegers.isEmpty()) {
            answer = this.addedIntegers.poll();
            this.isPresent.remove(answer);
        } 
        // Otherwise, the smallest number of large positive set 
        // denoted by 'currentInteger' is the answer.
        else {
            answer = this.currentInteger;
            this.currentInteger += 1;
        }
        return answer;
    }
    
    public void addBack(int num) {
        if (this.currentInteger <= num || this.isPresent.contains(num)) {
            return;
        }
        // We push 'num' in the min-heap if it isn't already present.
        this.addedIntegers.add(num);
        this.isPresent.add(num);
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */