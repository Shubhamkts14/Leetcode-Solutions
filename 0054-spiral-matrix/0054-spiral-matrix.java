class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        spiralOrderHelper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, result);
        return result;
    }

    private void spiralOrderHelper(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, List<Integer> result) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return;
        }
        for (int j = colStart; j <= colEnd; j++) {
            result.add(matrix[rowStart][j]);
        }
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            result.add(matrix[i][colEnd]);
        }
        if (rowStart < rowEnd) {
            for (int j = colEnd - 1; j >= colStart; j--) {
                result.add(matrix[rowEnd][j]);
            }
        }
        if (colStart < colEnd) {
            for (int i = rowEnd - 1; i > rowStart; i--) {
                result.add(matrix[i][colStart]);
            }
        }
        spiralOrderHelper(matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1, result);
    }
}
