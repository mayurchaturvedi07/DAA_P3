import java.util.Scanner;

public class EggDrop {

    public static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int result = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    dp[i][j] = Math.min(dp[i][j], result);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of eggs: ");
        int n = scanner.nextInt();

        System.out.print("Enter number of floors: ");
        int k = scanner.nextInt();

        long startTime = System.nanoTime();
        int result = eggDrop(n, k);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000000;  // Convert time to milliseconds

        System.out.println("Minimum number of trials in worst case with " + n + " eggs and " + k + " floors is " + result);
        System.out.println("Time taken to run the code: " + duration + " milliseconds");
    }
}