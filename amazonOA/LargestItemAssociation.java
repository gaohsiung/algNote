import java.util.*;
class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}

public class LargestItemAssociation {
    List<String> largestItemAssociation(List<PairString> itemAssociation) {
		// WRITE YOUR CODE HERE
		//corner case:
		List<String> res = new ArrayList<>();
		if (itemAssociation == null || itemAssociation.size() == 0) return res;
		
		UnionFind uf = new UnionFind();

		Map<String, Node> items = new HashMap<>();
		//Key is String,(item1, item2...) value is correspoinding Node	
		
		//processing input & build graph
		for(PairString pair : itemAssociation){
		    if(!items.containsKey(pair.first)){
		        items.put(pair.first, new Node(pair.first));
		    }
		    if(!items.containsKey(pair.second)){
		        items.put(pair.second, new Node(pair.second));
		    }
		    Node firstNode = items.get(pair.first);
		    Node secondNode = items.get(pair.second);
		    uf.union(firstNode, secondNode);
		}
		
		Node maxNode = null;
		
		for(String str: items.keySet()){
		    Node node = items.get(str);
		    if(maxNode == null) maxNode = node;
		    else if(node.size > maxNode.size) maxNode = node;
		}

		for(String str : items.keySet()){
            Node node = items.get(str);
		    if(uf.getRoot(node) == maxNode){
		        res.add(node.val);
		    }
		}
		Collections.sort(res);
		return res;
	}
    // METHOD SIGNATURE ENDS
    public static void main(final String[] args) {
		final PairString p1 = new PairString("Item1", "Item2");
		final PairString p2 = new PairString("Item3", "Item4");
		final PairString p3 = new PairString("Item4", "Item5");
		final List<PairString> list = Arrays.asList(p1, p2, p3);
		
		final PairString p21 = new PairString("item3","item4");
		final PairString p22 = new PairString("item1","item2");			
		final PairString p23 = new PairString("item5","item6");
		final PairString p24 = new PairString("item4","item5");
		final PairString p25 = new PairString("item2","item7");
		final PairString p26 = new PairString("item7","item8");
		final PairString p27 = new PairString("item2","item3");
		final PairString p28 = new PairString("item6","item7");
		final PairString p29 = new PairString("item0","item2");
		final List<PairString> list2 = Arrays.asList(p21, p22, p23, p24, p25, p26, p27, p28, p29);
        LargestItemAssociation l = new LargestItemAssociation();
		System.out.println(l.largestItemAssociation(list));
		System.out.println(l.largestItemAssociation(list2));
	}
}


class UnionFind{
    public UnionFind(){
        
    }
    
    public Node getRoot(Node p){
        Node cur = p;
        while(cur.parent != cur){
            cur.parent = cur.parent.parent;
            cur = cur.parent;
        }
        p.parent = cur;
        return cur;
    }
    
    public boolean find(Node p, Node q){
        return getRoot(p) == getRoot(q);
    }
    
    public void union(Node p, Node q){
        Node pRoot = getRoot(p);
        Node qRoot = getRoot(q);
        
        if(pRoot.compareTo(qRoot) > 0){
            qRoot.parent = pRoot;
            pRoot.size += qRoot.size;
        } else {
            pRoot.parent = qRoot;
            qRoot.size += pRoot.size;
        }

        return;
    } 
    
}


class Node implements Comparable<Node>{
    public Node parent;
    public String val;
    public int size;
    public Node (String val){
        this.val = val;
        this.size = 1;
        this.parent = this;
    }
    
    @Override
    public int compareTo(Node that){
        return (this.size == that.size) 
                ? this.val.compareTo(that.val)
                : this.size - that.size;
    }
    
}
