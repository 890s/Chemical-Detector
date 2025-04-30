import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DigitMatcherRunner
{
    // added in activity 4 part a
    // returns the first digit in the file
    public static ArrayList<Digit> getTestDigits (String testDigitsFilePath) throws IOException
{

    ArrayList<Digit> testDigits = new ArrayList<>();
    Scanner s = new Scanner(new File(testDigitsFilePath));
    while (s.hasNext()) {
        String[] values = s.nextLine().split(",");
        int label = Integer.parseInt(values[0]);
        int[] pixels = new int[784];
        for (int i = 0; i < 784; i++) {
            pixels[i] = Integer.parseInt(values[i + 1]) == 0 ? 0 : 1;
        }
        testDigits.add(new Digit(label, pixels));
    }
    s.close();
    return testDigits;
}


    public static void main(String[] args) throws IOException
    {
        // Test Activity 5 part a
        System.out.println("Activity 5 - Rank Digits by Similarity");
        DigitMatcher digitCollection = new DigitMatcher("C:\\Users\\200448984\\IdeaProjects\\KNN Lab\\src\\train_new.csv");
        ArrayList<Digit> testDigits = getTestDigits("C:\\Users\\200448984\\IdeaProjects\\KNN Lab\\src\\small.csv");
        int mostSimilarCount = 0;
        int kNearestCount = 0;
// this counter isn't necessary in order to run the algorithm, but it's here to demonstrate that the algorithm is running.
// you can change this value to try to see how accurate k-nearest neighbors is with a different k-value.
        int k = 5;
        int j = 0;
        System.out.println("__________");
        for(Digit d: testDigits){
            int mostSimilarLabel = digitCollection.kNearestNeighbors(d,k);
            int kNearestLabel = digitCollection.weightedKNearestNeighbors(d,k);

            if(d.getLabel() == mostSimilarLabel)
                mostSimilarCount++;
            if(d.getLabel() == kNearestLabel)
                kNearestCount++;

            if(j%300 == 0) {
                System.out.print(".");
            }
            j++;
        }
        System.out.println();
        System.out.println("KNN's accuracy = " +
                (double)mostSimilarCount/testDigits.size());
        System.out.println("Weighted KNN's accuracy with k = " + k + " = " +
                (double)kNearestCount/testDigits.size());
    }
}
