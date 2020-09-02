1. store in hashmap in memory
   - 数据量有限
   - 掉电没
   - 不能distributed，除非consistent hashing
   - 读写快
   - 实现容易
2. index, composite index, unique index
   - second index, 加速query，
   - composite index，多个attribute sort
   - unique index 唯一index query
3. 数据库：DBMS+File
   - all size(row) are the same
   - all size(col) are the same
   - table schema: 每个attribute的type都是固定长度，int, varchar(max size), float ...
    - 这里max size就是固定最大size，这样col row都对齐了
  - Enum
    - int enum：0，1，2，3...代表不同自定义类型
      - 添加只能append，不能在enum定义之间插入，因为定义中的更改数据库并不知道
      - 删除时可以在要删的定义type后面加个deprecate
    - string enum：直接通过string代表不同类型
      - 唯一坏处是长度空间有一定的浪费
4. database design
   - sevice design
     - user flow API
     - core object
     - object relationship
     - wrap up
   - Data storage Design
     - user flow API (Sql query)
     - Entity (table)
     - Entity Relationship
     - sql query
5. 对应关系：
   - 1：1 合并成一个表
   - 1：n n的里面做FK
   - n：n 额外建立一张表