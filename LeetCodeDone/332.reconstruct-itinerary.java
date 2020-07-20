import java.util.*;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // c.c.
        Collections.sort(tickets, new Comparator<List<String>>(){
            @Override
            public int compare(List<String> l1, List<String> l2) {
                if(!(l1.get(0).equals(l2.get(0)))) {
                    return l1.get(0).compareTo(l2.get(0));
                }
                return l1.get(1).compareTo(l2.get(1));
            }
        });
        List<String> path = new LinkedList<>();
        boolean[] whichTicketIsUsed = new boolean[tickets.size()];
        if(dfs("JFK", 0, tickets, path, whichTicketIsUsed)) {
            return path;
        } else {
            return new LinkedList<String>();
        }
    }

    private boolean dfs(String cur, int ticketsUsed, List<List<String>> tickets, 
                        List<String> path, boolean[] whichTicketIsUsed) {
        path.add(cur);
        if(ticketsUsed == tickets.size()) {
            return true;
        }
        for(int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            if (ticket.get(0).equals(cur) && !whichTicketIsUsed[i]) {
                whichTicketIsUsed[i] = true;
                if (dfs(ticket.get(1), ticketsUsed+1, tickets, path, whichTicketIsUsed)) {
                    return true;
                }
                whichTicketIsUsed[i] = false;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        // String[][] arr = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},
        //                                 {"ATL","JFK"},{"ATL","SFO"}};
        String[][] arr = new String[][]{{"MUC","LHR"},{"JFK","MUC"},
                                        {"SFO","SJC"},{"LHR","SFO"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] array : arr) {
            list.add(Arrays.asList(array));
        }
        System.out.println(list);
        System.out.println("result:");
        System.out.println(sol.findItinerary(list));

    }
}
// @lc code=end

