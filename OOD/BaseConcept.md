1. 枚举特性即可抽象成一个interface或者abstract class
2. File filter
   - syntax tree
   - filter抽象成一个abstract class 来实现不同功能的filter
   - combine optr也可以抽象成一个interface
   - FilterTreeNode：是filter或者也是operator，如何handle？
```java
abstract class FilterBase {
    private FilterParam fp;
    public FilterBase(FiterParam fp) {
        this.fp = fp;
    }
    abstract boolean filter (File file);
}

final class SizeFilter extends FilterBase {
    public SizeFilter(FilterParam fp) {
        super(fp);
    }
    @override
    public boolean filter(File file) {
        return file.getSize() > this.fp.getSize();
    }
}

interface OperaterBase {
    abstract boolean combine(boolean b1, boolean b2);
}
final class AddOptr implements OperaterBase {
    @override
    public boolean combine(boolean b1, boolean b2) {
        return b1 && b2;
    }
}
final class OrOptr implements OperaterBase {
    @override
    public boolean combine(boolean b1, boolean b2) {
        return b1 || b2;
    }
}

final class FilterTreeNode {
    private FilterTreeNode left;
    private FilterTreeNode right;
    private final FilterBase filter;
    private final OperaterBase combineOptr;
    
    public FilterTreeNode(FilterBase filter) {
        this.filter = filter;
        this.combineOptr = null;
        this.left = null;
        this.right = null;
    }
    public FilterTreeNode(OperaterBase combineOptr, FilterTreeNode left, FilterTreeNode right) {
        this.combineOptr = combineOptr;
        this.filter = null;
        this.left = left;
        this.right = right;
    }
    public boolean isFilter() {
        return this.filter != null;
    }
    public boolean eval(File file) {
        if (isFilter()) {
            return this.filter.filter(file);
        }
        return combineOptr.combine(this.left.eval(file), this.right.eval(file));
    }
}
public class FilterSystem {
    public List<File> filter(List<File> files, FilterTreeNode root) {
        List<File> res = new LinkedList<>();
        for (File f: files) {
            if (root.eval(f)) {
                res.add(f);
            }
        }
        return res;
    }
}
```
3. 算术表达式
   - calculate tree
```java
interface Operator {
    abstract int calculate(int i1, int i2);
}
final class Add implements Operator {
    @override
    public int calculate(int i1, int i2) {
        return i1 + i2;
    }
}
final class Minus implements Operator {
    @override
    public int calculate(int i1, int i2) {
        return i1 - i2;
    }
}

final class ExpressionTreeNode {
    private Operator optr;
    private Integer value;
    private ExpressionTreeNode left;
    private ExpressionTreeNode right;

    public ExpressionTreeNode(Operator optr, ExpressionTreeNode left, ExpressionTreeNode right) {
        this.optr = optr;
        this.value = null;
        this.left = left;
        this.right = right;
    }
    public ExpressionTreeNode(Integer value) {
        this.optr = null;
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public boolean isValue() {
        return this.value != null;
    }
    public int evaluate() {
        if (this.isValue()) {
            return this.value;
        }
        return this.optr.calculate(evaluate(root.left), evaluate(root.right));
    }
}
```
4. polynominal表达式
   - 无括号优先级设定，直接使用1d array即可