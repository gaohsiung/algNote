# Builder Pattern
1. immutable class
2. optional fields
3. Create -> builder -> User
4. Update -> User -> Builder -> new User
```java
final class User {
    private String userName;
    private String pwd;
    private String nickName;
    private int age;
    private String email;

    
    private User(UserBuilder ub) {
        this.userName = ub.userName;
        this.pwd = ub.pwd;
        this.nickName = ub.nickName;
        this.age = ub.age;
        this.email = ub.email;
    }
    public UserBuilder toBuilder(){
        return new UserBuilder(this.userName, this.pwd).setNickName(this.nickName).setAge(this.age).setEmail(this.email);
    }

    private static class UserBuilder {
        private String userName; // required
        private String pwd; // required
        private String nickName;
        private int age;
        private String email;

        public UserBuilder(String userName, String pwd) {
            this.userName = userName;
            this.pwd = pwd;
        }
        public UserBuilder setNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }
        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
    public static void main(String[] args) {
        User user = new User.UserBuilder("name", "password").setEmail("abc@mail.com").build();
        user = new User.toBuilder().setEmail("def@mail.com").build();
    }
}
```
# Singleton
1. 全局唯一。e.g. Master-slave
2. construct 费劲。e.g. cache
3. 如果
```java
private static final Singleton instance = new Singleton();
```
不是lazy initialization。造成out of memory，资源浪费
4. synchronize
   - synchronize function
   - synchronize(this)锁class的一个instance，同一class不同instance不干扰
   - synchronize(Singleton.class)锁所有的class的instance，同一class不同instance互相锁
   - 这里Singleton保证一个class只有一个instance，所以synchronize(this)和synchronize(Singleton.class)意义一样
```java
public class Singleton {
    private static Singleton instance; // static 全局唯一
    private Singleton() {}
    public static Singleton getInstance() { // static 不用new就可以get
        if (instance == null) {
            synchronize(Singleton.class) { // synchronize(this)也是ok的
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
# Dependency Injection
1. 把dependency 的class的initialization从单一class剥离，所有dependent 的class在一个provider system里new
2. Guice，annotation,rpc, 
# Factory design
1. 动态绑定
```java
abstract class Shape {
    private String shapeName;

    abstract class draw();

    public String getName() {
        return this.name;
    }
}
public class Rectangle extends Shape {
    @override
    public void draw() {

    }
}
public class Circle extends Shape {}
public class Triangle extends Shape {}

class GraphApplication {
    public void draw(ShapeType type) {
        Shape shape = 
    }
}
```
# decorator
1. iterator
# observer
1. monitor, trigger。e.g. game engine
