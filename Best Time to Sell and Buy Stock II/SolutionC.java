
public class SolutionC {

    // function being tested calling helper function
    public static int maxProfit(int[] prices) {
        return maxProfitHelp(prices, 0);
    }

    // example arrays to use:
    // [7,1,5,3,6,4]
    // [7,6,4,3,1,5,3,16,4]
    // [1,2,3,4,5,6]
    // [7,6,4,3,1]

    /**
     * the "Brute force" approach, processes each possible profit made by selling at every index and stores
     * largest profit trade. if trades are possible with reamining days, function recurses and calculates further
     *
     * @param prices
     * @param buy                                       index used for identifying potential trade's start
     * @return                                          int representing profit calculated
     */
    public static int maxProfitHelp(int[] prices, int buy) {
        int tradeProfit = 0;

        if (buy >= prices.length) {
            return tradeProfit;
        } else {
            for (int i = buy; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {

                    if (prices[j] - prices[i] > 0) {
                        int newProfit = prices[j] - prices[i] + maxProfitHelp(prices, j + 1);
                        if (newProfit > tradeProfit) {
                            tradeProfit = newProfit;
                        }
                    }
                }
            }
        }

        return tradeProfit;
    }

    // main method testing the maxProfit function with a pre-existing array
    public static void main(String[] args) {

        int[] testArray = {7,6,4,3,1};
        int length = maxProfit(testArray);

        System.out.println("benchmark");
    }
}
