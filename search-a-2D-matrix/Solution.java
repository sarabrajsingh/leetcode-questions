class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;

        if(row == 0) {
            return false;
        }

        int col = matrix[0].length;

        int left = 0; // beginning of the matrix
        int right = row * col - 1; // last element in the matrix
        int pivot_idx, pivot_elem; // our two pointer & helper vars

        while(left <= right) {
            pivot_idx = left + (right - left) / 2;
            int row_idx = pivot_idx / col;
            int col_idx = pivot_idx % col;
            pivot_elem = matrix[row_idx][col_idx]; // this is what i don't understand
            if(target == pivot_elem) {
                return true;
            } else {
                if (target < pivot_elem) {
                    right = pivot_idx - 1;
                } else {
                    left = pivot_idx + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 10));
    }
}