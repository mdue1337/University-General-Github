public class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount = 0;  // devices in the last non-empty row
        int totalBeams = 0;

        for (String row : bank) {
            // Count number of '1's in this row
            int currCount = 0;

            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '1') currCount++;
            }

            // If this row has devices, calculate beams
            if (currCount > 0) {
                totalBeams += prevCount * currCount;
                prevCount = currCount; // move to next non-empty row
            }
        }

        return totalBeams;
    }
}