public class Leetcode06 {

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[][] matrix = new char[numRows][s.length()];
        boolean dirDown = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            if (row == 0 || row == numRows - 1) {
                dirDown = !dirDown;
            }
            matrix[row][i] = s.charAt(i);
            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (matrix[i][j] != '\u0000') {
                    ans += matrix[i][j];
                }
            }
        }
        return ans;
    }

    public static String convert2(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        boolean backward = true;
        int index = 0;
        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0 || index == numRows - 1) {
                backward = !backward;
            }

            if (backward) {
                index--;
            } else {
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(rows[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
        ;
    }
}
