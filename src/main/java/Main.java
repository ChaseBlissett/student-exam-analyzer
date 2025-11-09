import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("pizza_boy");
        student.setGradeLevel(9);

        List<Double> scores = new ArrayList<>();
        double multiplier = 1.1;
        double sampleScore = 45;
        while (multiplier * sampleScore < 100) {
            scores.add(sampleScore);
            sampleScore *= multiplier;
        }

        student.setScores(scores);

        System.out.println("Scores:" + student.getScores());
        System.out.println("Mean: " + student.getMean());
        System.out.println("Median: " + student.getMedian());
        System.out.println("Mode: " + student.getMode());
        System.out.println("Min: " + student.getMin());
        System.out.println("Max: " + student.getMax());
        System.out.println("Range: " + student.getRange());
        System.out.println("Population Std.dev " + student.getPopulationStandardDeviationOfScores());
        System.out.println("Sample Std.dev " + student.getSampleStandardDeviationOfScores());
        System.out.println("Unusual scores: " + student.findUnusualScores());
        System.out.println("Is 100 unusual: " + student.isUnusualScore(93));

        // temporary test case
        Student test = new Student();
        List<Double> testScores = new ArrayList<>();
        testScores.add(1.0);
        testScores.add(1.0);
        testScores.add(2.0);
        testScores.add(2.0);
        testScores.add(3.0);
        test.setScores(testScores);
        System.out.println(test.getMode());
        System.out.println("min: " + test.getMin());
        System.out.println("max: " + test.getMax());
        System.out.println("range: " + test.getRange());
        System.out.println("mean: " + test.getMean());
        System.out.println("Population Std.dev: " + test.getPopulationStandardDeviationOfScores());
        System.out.println("Sample Std.dev: " + test.getSampleStandardDeviationOfScores());
        System.out.println("Unusual scores: " + test.findUnusualScores());
        System.out.println("Is 100 unusual: " + test.isUnusualScore(100));

    }

}
