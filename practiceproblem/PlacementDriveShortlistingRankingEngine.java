package practiceproblem;

import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }
        double compositeScore() {

            return (cgpa * 5) + codingScore;
        }
       
        public int compareTo(Candidate other) {
            return Double.compare(
                other.compositeScore(),
                this.compositeScore());}}
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted =
                new Candidate[candidates.length];
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            Candidate c = candidates[i];
            if (Candidate.isEligible(c.cgpa) ||
                Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count] = c;
                count++;
            }
        }
        Candidate[] finalShortlisted =
                Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalShortlisted);
        String result = "";
        for (int i = 0; i < finalShortlisted.length; i++) {
            Candidate c = finalShortlisted[i];
            result = result +
                     (i + 1) + ". " +
                     c.name + " (" +
                     c.compositeScore() + ")";
            if (i < finalShortlisted.length - 1) {
                result = result + " | ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}