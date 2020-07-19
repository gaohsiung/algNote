# HashMap
1. Bucket structure, Bucket[]
2. hash function: 找bucket，必须O(1)
   - 生成的值尽可能分散, %bucket size
   -  使用31: 
   -  "abc" -> [(int)  * 31^0 + (int) b * 31 + (int) c * 31^2 + ...+...] % bucket size
   -  ASCII码
   -  List不会作为hashmap的key，长度未知，不好做hash function
   -  溢出：只保留32位，高位都drop
3. HashCode() && equals()
   - HashCode() : [(int)  * 31^0 + (int) b * 31 + (int) c * 31^2 + ...+...]
   - equals()
   - 两者要同时overload，何时？
     - 当key有更加unique的id时，可以overload，保证每次断电前后hashcode唯一确定，而不会因为每次分配不同的reference而不同的hashcode
     - 不同线程相同的object，由于reference不同，所以hashcode不同，但实际上是相同的object，需要根据object的id改写hashcode和equals
4. put
   - 用hashcode找bucket by key
   - 用equals在相应bucket里找对应item
   - 有就update，没有就create
5. get
   - 找bucket
   - 在相应bucket里找对应item
   - 有就返回，没有返回null
6. expand
   - load factor > 0.75
   - rehash
   - TreeMap不需要expand，实现是BST
   - 一般不删除bucket，因为在临界值会震荡，来回expand和remove。remove可以size远小于expand的size。e.g. dynamic table
7. implement mymap -> java hashmap
   - constructor
   - put/get/remove
   - Average O(1)
   - generic
   - support 'null' as key
   - bucket 使用arraylist，swap方法保证remove O(1)，因为不关心顺序
```java
class MyMap<K,V> {

    private static class Cell<K, V> {
        private K key;
        private V val;   

        public Cell<K, V>(K key, V val) {
            this.key = key;
            this.val = val;
        }
        //getter
        //setter
        @Override
        public int hashcode() {
            if (this.key == null) {
                return 0;
            }
            return this.key.hashcode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Cell<K, V>)) {
                return false;
            }
            Cell<K, V> that = (Cell<K, V>) o;
            return that == null ? false : (this.getKey() == null ? that.getKey() == null : that.getKey().equals(this.getKey()));
        }
    }
    private static final double LOAD_FACTOR = 0.75d;
    private int capcity = 256;
    private int size;
    private List<Cell<K, V>>[] buckets;

    public MyMap() {
        this(256);
    }
    public MyMap(int capacity) {
        if (capacity <= 0) throw IllegalArgumentException();
        this.capcity = capacity;
        this.buckets = new ArrayList<Cell<K,V>>[this.capacity];
        this.size = 0;
    }
    public void put(K key, V val) {
        int idx = hashFunction(key);
        List<Cell<K,V>> bucket = this.buckets[idx];
        if (bucket == null) {
            bucket = new ArrayList<>();
            this.buckets[idx] = bucket; // put it in
        }
        Cell<K,V> insertMe = new Cell(key, val);
        for (Cell cell: bucket) {
            if (cell.equals(insertMe)) {
                cell.setVal(val);
                return;
            }
        }
        bucket.add(insertMe);
        this.size++;
        if(this.size >= this.capacity * LOAD_FACTOR) {
            rehashing();
        }
        return;
    }
    private int hashFunction(K key) {
        return key == null ? 0:Math.abs(key.hashcode() % this.capacity); //return 0是stable在range里
    }
    public V get(K key) {
        int idx = hashFunction(key);
        List<Cell<K,V>> bucket = buckets[idx];
        if (bucket == null) {
            return null;
        }
        Cell<K,V> getMe = new Cell<K,V>(key, null);
        for (Cell cell: bucket) {
            if (cell.equals(getMe)) {
                return cell.getVal();
            }
        }
        return null;
    }
    public boolean remove(K key) {
        int idx = hashFunction(key);
        List<Cell<K,V>> bucket = buckets[idx];
        if (bucket == null) {
            return false;
        }
        Cell<K, V> removeMe = new Cell<K,V>(key, null);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).equals(removeMe)) {
                swap(bucket, i, bucket.size() - 1);
                bucket.remove(bucket.size()  -1);
                this.size--;
                return true;
            }
        }
        return false;
    }
    private void rehashing() {
        this.capacity *= 2;
        List<Cell<K, V>>[] newBuckets = new List<>[this.capacity];
        for(List<Cell<K, V>> bucket: buckets) {
            if (bucket == null) continue;
            for(Cell c: bucket) {
                int idx = hashFunction(c.getKey());
                if (newBuckets[idx] == null) {
                    newBuckets[idx] = new ArrayList<>();
                }
                newBuckets[idx].add(c);

            }
        }
        this.buckets = newBuckets;
    }
}
```
8. iterator
   - EntrySet
9. MultiMap<Integer, String> <==> HashMap<Integer, List<String>>
   - MultiMap.put(5, "a");
   - MultiMap.put(5, "b");
   - MultiMap.get(5); // ["a", "b"]
   - asMap -> HashMap<K, List<V>>
   - size
10. Distributed hashMap <==> distributed cache
   - in memory
   - consistent hashing with sharding
