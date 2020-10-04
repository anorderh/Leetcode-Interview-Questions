/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/3/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * - The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 *              :Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 *           :Output: true
 *
 * Example 2:
 *
 *              :Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 *          :Output: false
 *
 * Explanation:
 *      Same as Example 1, except with the 5 in the top left corner being
 *      modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Note:
 *
 *      A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *      Only the filled cells need to be validated according to the mentioned rules.
 *      The given board contain only digits 1-9 and the character '.'.
 *      The given board size is always 9x9.
 */

import java.util.HashSet;

class SolutionK {
    public boolean isValidSudoku(char[][] board) {

        // using 2 StringBuilders for rows & columns and Strings[] to store 9 boxes
        StringBuilder rowString = new StringBuilder();
        StringBuilder columnString = new StringBuilder();
        String[] squareString = { "", "", "", "", "", "", "", "", ""};
        int SSIndex = 0; // square string index, for telling which box to insert into

        for (int i = 0; i < board.length; i++) {
            SSIndex = (i/3) * 3; // rows 0,1,2 -> box 0, rows 3, 4, 5 -> box 3, rows 6, 7, 8 -> box 6

            for (int j = 0; j < board[i].length; j++) {
                // adding row and column values to respective StringBuilder
                rowString.append(board[i][j]);
                columnString.append(board[j][i]);

                // if statement increment SSIndex when column passes multiple of 3, meaning moved into next box
                if (j % 3 == 0 && j != 0) {
                    SSIndex++;
                }

                // assigning respective String "box" in String[] w/ current char
                squareString[SSIndex] += board[i][j];
            }

            // if statement validating current held row and column are valid Sudoku groupings
            // if validation successful, allocates new StringBuilders and compiler collects garbage
            if (!isValidGroup(rowString.toString()) || !isValidGroup(columnString.toString())) {
                return false;
            }
            rowString = new StringBuilder();
            columnString = new StringBuilder();
        }

        // for loop for validating all 'boxes' held in String[] squareString
        for (int i = 0; i < squareString.length; i++) {
            if (!isValidGroup(squareString[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * isValidGroup() takes in String input and uses a HashSet to verify the String has no duplicates. If present, false
     * is returned. If not present, current char is added to HashSet for further chars' validation.
     *
     * @param input                                                     input String to be examined
     * @return                                                          boolean identifying if duplicates present
     */
    public boolean isValidGroup (String input) {
        HashSet<Character> charRegistry = new HashSet<Character>();

        for (int i = 0; i < input.length(); i++) {
            if (charRegistry.contains(input.charAt(i)) && input.charAt(i) != '.') {
                return false;
            }
            charRegistry.add(input.charAt(i));
        }

        return true;
    }
}