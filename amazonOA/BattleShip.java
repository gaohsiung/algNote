import java.util.*;

public class BattleShip {
    public static String solution(int N, String S, String T) {
        int sink = 0;
        int hit = 0;
        Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));
        String[] ships = S.split(",");
        for (String ship : ships) {
            Set<String> shipComponents = new HashSet<>();
            char top = ship.charAt(0);
            char left = ship.charAt(1);
            char bottom = ship.charAt(3);
            char right = ship.charAt(4);
            for (char i = top; i <= bottom; i++) {
                for (char j = left; j <= right; j++) {
                    shipComponents.add("" + i + j);
                }
            }
            if (hits.containsAll(shipComponents)) {
                sink++;
            } else {
                for (String com : shipComponents) {
                    if (hits.contains(com)) {
                        hit++;
                        break;
                    }
                }
            }
    
        }
    
        return "" + sink + "," + hit;
    
    }
}
