import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private int gradeLevel;
    private List<Double> scores;

    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public List<Double> getScores() {
        return this.scores.stream()
                .map(score -> Math.round(score * 100.0) / 100.0)
                .collect(Collectors.toList());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGradeLevel(int gradeLevel) {
        if (gradeLevel >= 9 && gradeLevel <= 12) this.gradeLevel = gradeLevel;
        else throw new RuntimeException("Grade Level should be 9-12");
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }

    public double getMean() {
        double average = 0;
        for (double score : scores) {
            average += score;
        }
        return Math.round((average * 100.0) / (scores.size())) / 100.0;
    }

    public double getMedian() {
        List<Double> sortedList = this.scores;
        Collections.sort(sortedList);

        double middleIndexDouble = scores.size() / 2.0;
        int middleIndex = (int) middleIndexDouble;
        if (middleIndexDouble % 2 == 0) {
            double median = ((sortedList.get(middleIndex)) + sortedList.get(middleIndex - 1)) / 2;
            return Math.round(median);
        } else {
            double median = sortedList.get(middleIndex);
            return Math.round(median * 100.0) / 100.0;
        }
    }

    public List<Double> getMode() {
        List<Double> modes = new ArrayList<>();
        if (this.scores == null || this.scores.isEmpty()) {
            return modes;
        }

        Map<Double, Integer> counts = new HashMap<>();
        for (Double score : this.scores) {
            counts.put(score, counts.getOrDefault(score, 0) + 1);
        }
        int maxCount = 0;
        for (int count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxCount) {
                modes.add(entry.getKey());
            }
        }

        if (modes.size() == this.scores.size()) {
            System.out.println("No mode in scores");
            return Collections.emptyList();
        }

        return modes;
    }

    public double getMin() {
        if (this.scores == null || this.scores.isEmpty()) {
            System.out.println("No min in scores");
            return -1;
        }
        List<Double> sortedScores = this.scores;
        Collections.sort(sortedScores);
        double min = scores.getFirst();
        return Math.round(min * 100) / 100.0;

    }

    public double getMax() {
        if (this.scores == null || this.scores.isEmpty()) {
            System.out.println("No min in scores");
            return -1;
        }

        double max = 0;
        for (double score : this.scores) {
            if (max < score) {
                max = score;
            }
        }
        return Math.round(max * 100.0) / 100.0;
    }

    public double getRange() {
        return this.getMax() - this.getMin();
    }

    public double getPopulationStandardDeviation() {
        double mean = this.getMean();
        double sumOfMeanMinusStdDevSquared = 0;
        for (double score : scores) {
            double meanMinusStdDevSquared = Math.pow(score - mean, 2);
            sumOfMeanMinusStdDevSquared += meanMinusStdDevSquared;
        }
        return Math.sqrt(sumOfMeanMinusStdDevSquared/this.scores.size());
    }

    public double getSampleStandardDeviation() {
        double mean = this.getMean();
        double sumOfMeanMinusStdDevSquared = 0;
        for (double score : scores) {
            double meanMinusStdDevSquared = Math.pow(score - mean, 2);
            sumOfMeanMinusStdDevSquared += meanMinusStdDevSquared;
        }
        return Math.sqrt(sumOfMeanMinusStdDevSquared/(this.scores.size() - 1));
    }

}