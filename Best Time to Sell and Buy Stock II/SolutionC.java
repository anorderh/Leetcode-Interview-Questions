/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 *          Input: [7,1,5,3,6,4]
 *          Output: 7
 *          Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 *          Input: [1,2,3,4,5]
 *          Output: 4
 *          Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 *          Input: [7,6,4,3,1]
 *          Output: 0
 *          Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Constraints:
 *
 *          1 <= prices.length <= 3 * 10 ^ 4
 *          0 <= prices[i] <= 10 ^ 4
 */

public class SolutionC {

    // function being tested calls a helper function
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
     * largest profit trade. if trades are possible with remaining days, function recurses and calculates further
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
