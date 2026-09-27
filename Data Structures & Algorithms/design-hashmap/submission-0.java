class MyHashMap {

    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<Pair>[] buckets;
    int SIZE = 10000;

    public MyHashMap() {

        buckets = new ArrayList[SIZE];

        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {

        int index = key % SIZE;

        for (Pair p : buckets[index]) {

            if (p.key == key) {
                p.value = value;
                return;
            }
        }

        buckets[index].add(new Pair(key, value));
    }

    public int get(int key) {

        int index = key % SIZE;

        for (Pair p : buckets[index]) {

            if (p.key == key) {
                return p.value;
            }
        }

        return -1;
    }

    public void remove(int key) {

        int index = key % SIZE;

        for (int i = 0; i < buckets[index].size(); i++) {

            if (buckets[index].get(i).key == key) {
                buckets[index].remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */