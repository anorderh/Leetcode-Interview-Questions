/**
 *  NAME: Anthony Norderhaug
 *  DATE: 10/6/2020
 *  COLLEGE: San Diego State University
 *  GITHUB: https://github.com/anorderh
 *
 *       LEETCODE PROMPT
 *  --------------------------
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 *      Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *      Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 *      Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 *      Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Example 3:
 *
 *      Input: matrix = [[1]]
 *      Output: [[1]]
 *
 * Example 4:
 *
 *      Input: matrix = [[1,2],[3,4]]
 *      Output: [[3,1],[4,2]]
 */

class SolutionL {

    /**
     * rotate() takes in a 2D array (representing a matrix) and with reference to its depiction as an image, rotates
     * the matrix 90 degrees clockwise. This is accomplished by swapping all elements w/ inverse indices to convert
     * Rows --> Columns (transposing) and then reversing each row (flipping)
     *
     * @param matrix                                     input 2D array to be rotated
     */
    public void rotate(int[][] matrix) {
        int placeholder;

        /*
        turn all rows into columns by swapping
        elements w/ inverse-indexed elements
        */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                /*
                inner loop counter initialized with 'i' to prevent loops
                from iterating over element already swapped
                */
                if (i != j) {
                    placeholder = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = placeholder;
                }
            }
        }

        /*
        reverse each row, reordering matrix's columns
        matrix's 1st column ---> matrix's last column
        */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                // swapping every element results in same array
                // swapping only half results in reverse
                    // odd-numbered lengths exclude middle element, which doesn't move in reversal
                placeholder = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = placeholder;
            }
        }

    }
}
