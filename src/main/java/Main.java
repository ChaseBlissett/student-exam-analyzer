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

        Student test = new Student();
        List<Double> testScores = new ArrayList<>();
        testScores.add(1.0);
        testScores.add(1.0);
        testScores.add(2.0);
        testScores.add(2.0);
        testScores.add(3.0);
        test.setScores(testScores);
        System.out.println(test.getMode());

    }

}
