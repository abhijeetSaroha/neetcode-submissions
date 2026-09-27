class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Create 9 sets for rows, columns and boxes
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Visit every cell
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Find which 3x3 box this cell belongs to
                int box = (row / 3) * 3 + (col / 3);

                // Check duplicate
                if (rows[row].contains(num)) {
                    System.out.println("Duplicate in row!");
                    return false;
                }

                if (cols[col].contains(num)) {
                    System.out.println("Duplicate in column!");
                    return false;
                }

                if (boxes[box].contains(num)) {
                    System.out.println("Duplicate in box!");
                    return false;
                }

                // Add number to all three
                rows[row].add(num);
                cols[col].add(num);
                boxes[box].add(num);
            }
        }

        return true;
    }
}
