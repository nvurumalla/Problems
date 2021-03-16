package arrays;

import java.util.*;

public class WinGame {
    private static HashMap<Integer,Boolean> resultMap = new HashMap<>();
    private static Set<Integer> indexSet = new HashSet<>();

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        System.out.println("Input leap: " + leap + ", size: " + game.length);
        resultMap.clear();
        indexSet.clear();
        return canWin(leap, game, 0);
    }

    public static boolean canWin(int leap, int[] game, int index) {
        System.out.println("Inside canWin for index: " + index);
        if (indexSet.contains(index)) {
            return false;
        }
        indexSet.add(index);
        if (index == game.length-1 || index+leap >= game.length) {
            resultMap.put(index, true);
            return true;
        }

        if (resultMap.containsKey(index)) {
            return resultMap.get(index);
        }

        boolean canWin = false;
        if (game[index+1] == 0) {
            canWin = canWin(leap, game, index+1);
        }
        if (!canWin && leap!= 0 && game[index+leap] == 0) {
            canWin = canWin(leap, game, index+leap);
        }
        if (!canWin && index-1 >= 0 && game[index-1] == 0) {
            canWin = canWin(leap, game, index-1);
        }
        resultMap.put(index, canWin);
        return canWin;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
