public class Digit {
    private int label;
    private int[][] grid;
    private double similarity;

    public Digit(int labe, String[] pixels)
    {
        label = labe;
        constructGrid(pixels);
        similarity = 0.0;
    }

    public Digit(int labe, int[] pixels)
    {
        label = labe;
        constructGrid(pixels);
        similarity = 0.0;
    }

    private void constructGrid(String[] pixels) {
        int[][] image = new int[28][28];
        for (int i=0;i<pixels.length;i++) {
            if (Integer.parseInt(pixels[i])==1) {
                image[i/28][i%28] = 1;
            }
        }
        grid = image;
    }

    private void constructGrid(int[] pixels) {
        int[][] image = new int[28][28];
        for (int i=0;i<pixels.length;i++) {
            if (pixels[i]==1) {
                image[i/28][i%28] = 1;
            }
        }
        grid = image;
    }

    public String toString() {
        String output = "";
        for (int[] row:grid) {
            for (int i:row) {
                if (i==0) {
                    output += " ";
                } else if (i==1) {
                    output += ".";
                }
            }
            output += "\n";
        }
        return output;
    }

    public int getLabel() {
        return label;
    }

    public int[][] getGrid() { return grid; }

    public double calculateSimilarity (Digit other)
    {
        int[][] grid1 = getGrid();
        int[][] grid2 = other.getGrid();
        double count = 0;
        for (int i=0;i<28;i++) {
            for (int j=0;j<28;j++) {
                if (grid1[i][j]==grid2[i][j]) {
                    count++;
                }
            }
        }
        return count/784;
    }
}
