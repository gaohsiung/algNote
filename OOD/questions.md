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
   - 
4. put
   - 找bucket by key
   - 在相应bucket里找对应item
   - 有就update，没有就create
   - 
5. get
   - 找bucket
   - 在相应bucket里找对应item
   - 有就返回，没有返回null