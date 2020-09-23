
public class SolutionC {

    public static int maxProfit(int[] prices) {
        return maxProfitHelp(prices, 0, prices.length-1);
    }

    // [7,1,5,3,6,4]
    // [7,6,4,3,1,5,3,16,4]
    // [1,2,3,4,5,6]
    // [7,6,4,3,1]
    // identify tracts of decreasing values and spikes
    public static int maxProfitHelp(int[] prices, int buy, int sell) {
        int tradeProfit = 0;

        if (buy >= sell) {
            return tradeProfit;
        } else {
            for (int i = buy; i < prices.length; i++) {
                for (int j = sell; j > i; j--) {

                    if (prices[j] - prices[i] > 0) {
                        int newProfit = prices[j] - prices[i] + maxProfitHelp(prices, j + 1, sell);
                        if (newProfit > tradeProfit) {
                            tradeProfit = newProfit;
                        }
                    }
                }
            }
        }

        return tradeProfit;
    }

    public static void main(String[] args) {
        // [7,1,5,3,6,4]

        int[] testArray = {7,1,5,3,6,4};
        int length = maxProfit(testArray);

        System.out.println("benchmark");
    }
}
