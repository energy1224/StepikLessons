package Student;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ball = sc.nextInt();
        int time = sc.nextInt();
        Trial.setPassingScore(ball);
        StrongTrial.setTimeLimit(time);
        Trial[] trials = new Trial[sc.nextInt()];
        for (int i = 0; i < trials.length; i++) {
            int trial = sc.nextInt();
            if (trial == 1) {
                trials[i] = new Trial();
            } else if (trial == 2) {
                trials[i] = new LightTrial();
            } else {
                trials[i] = new StrongTrial();
            }
            trials[i].setSurname(sc.next());
            trials[i].setScore01(sc.nextInt());
            trials[i].setScore02(sc.nextInt());
            if (trials[i] instanceof StrongTrial) {
                ((StrongTrial) trials[i]).setPassingTime(sc.nextInt());
            }
        }
        for (int i = 0; i < trials.length; i++) {
            System.out.println(trials[i]);

        }
        System.out.println();
        for (int i = 0; i < trials.length; i++) {
            if (trials[i].isPassed())
                System.out.println(trials[i]);
        }

    }
}

    class Trial {

        private static int passingScore;
        private String surname;
        private int score01;
        private int score02;

        public Trial() {
        }

        public Trial(String surname) {
            this.surname = surname;
//        this.score01=0;
//        this.score02=0;
        }

        public Trial(String surname, int score01, int score02) {
            this.surname = surname;
            this.score01 = score01;
            this.score02 = score02;
        }

        public static int getPassingScore() {
            return passingScore;
        }

        public static void setPassingScore(int passingScore) {
            Trial.passingScore = passingScore;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getScore01() {
            return score01;
        }

        public void setScore01(int score01) {
            this.score01 = score01;
        }

        public int getScore02() {
            return score02;
        }

        public void setScore02(int score02) {
            this.score02 = score02;
        }

        boolean isPassed() {
            return passingScore <= score01 && passingScore <= score02;
        }

        @Override
        public String toString() {
            return surname + ";" + score01 + ";" + score02;
        }
    }

    class LightTrial extends Trial {

        public LightTrial(String surname, int score01, int score02) {
            super(surname, score01, score02);
        }

        public LightTrial() {
        }

        @Override
        public int getScore01() {
            return super.getScore01();
        }

        @Override
        public void setScore01(int score01) {
            super.setScore01(score01);
        }

        @Override
        public int getScore02() {
            return super.getScore02();
        }

        @Override
        public void setScore02(int score02) {
            super.setScore02(score02);
        }

        @Override
        boolean isPassed() {

            return LightTrial.getPassingScore() < LightTrial.super.getScore01() + LightTrial.super.getScore02();

        }
    }

    class StrongTrial extends Trial {

        private static int timeLimit;

        private int passingTime;

        public StrongTrial(String surname, int score01, int score02, int passingTime) {
            super(surname, score01, score02);
            this.passingTime = passingTime;
        }

        public StrongTrial() {
        }

        @Override
        public String toString() {
            return super.toString() + ";" + passingTime;
        }

        public static int getTimeLimit() {
            return timeLimit;
        }

        public static void setTimeLimit(int timeLimit) {
            StrongTrial.timeLimit = timeLimit;
        }

        public int getPassingTime() {
            return passingTime;
        }

        public void setPassingTime(int passingTime) {
            this.passingTime = passingTime;
        }

        @Override
        boolean isPassed() {
            return super.isPassed() && timeLimit > passingTime;
        }
    }


