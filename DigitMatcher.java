import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class DigitMatcher
{
    /* ArrayList holding the dataset of digits */
    private ArrayList<Digit> digits;

    /*
     * Constructor
     * Initializes the digits array with digits from a file
     * @param file containing the digits
     */
    public DigitMatcher(String filePath) throws IOException
    {
        digits = new ArrayList<Digit>();
        int size = 784;
        Scanner s = new Scanner(new File(filePath));
        while (s.hasNext())
        {
            String line = s.nextLine();
            int label = Integer.parseInt(line.split(",")[0]);
            String[] pixels = Arrays.copyOfRange(line.split(","), 1, 784);
            digits.add(new Digit(label, pixels));
        }
        s.close();
    }

    public Digit getDigits(int position)
    {
        return digits.get(position);
    }

    public Digit findMostSimilar(Digit test) {
        double maximum = 0.0;
        Digit prediction = new Digit(0, new int[784]);
        for (int i=0;i< digits.size();i++) {
            double temp = digits.get(i).calculateSimilarity(test);
            if (temp >= maximum) {
                maximum = temp;
                prediction = digits.get(i);
            }
        }
        return prediction;
    }

    public ArrayList<Digit> findkMostSimilar(Digit test, int k) {
        ArrayList<Digit> results = new ArrayList<>();
        ArrayList<Digit> digitsCopy = new ArrayList<>();
        digitsCopy.addAll(digits);

        for (int i=0;i<k;i++) {
            results.add(findMostSimilar(test));
            digits.remove(findMostSimilar(test));
        }

        digits.clear();
        digits.addAll(digitsCopy);
        return results;
    }

    public int kNearestNeighbors (Digit test, int k)
    {
        ArrayList<Digit> kMostSimilar = findkMostSimilar(test, k);
        int[] count = new int[10];
        int max = 0;
        int maxIndex = 0;

        for (Digit digit: kMostSimilar) {
            count[digit.getLabel()] += 1;
        }

        for (int i=0;i<10;i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public int weightedKNearestNeighbors (Digit test, int k)
    {
        ArrayList<Digit> kMostSimilar = findkMostSimilar(test, k);
        double[] count = new double[10];
        double max = 0;
        int maxIndex = 0;

        for (Digit digit: kMostSimilar) {
            count[digit.getLabel()] += digit.calculateSimilarity(test);
        }

        for (int i=0;i<10;i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}

