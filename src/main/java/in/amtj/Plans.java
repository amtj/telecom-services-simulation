package in.amtj;

import java.util.Random;

public class Plans {

    static int[][] generatePlans(int plans, double beta) {
        int[][] output = new int[plans][2];
        int offset = 100 / plans;
        Random random1 = new Random();
        Random random2 = new Random();

        if(beta >= 1) {
            for (int i = 0; i < plans; i++) {
                int randomK = random1.nextInt(offset) + 1 + (i * offset);
                double randomR = ((double) (random2.nextInt(offset) + 1 + (i * offset))) / 100;

                int P = (int) (randomK * randomR);

                if (P == 0) P = 1;
                output[i][1] = P;
                output[i][0] = randomK;
            }
        }
        else {
            for (int i = 0; i < plans; i++) {
                int randomK = random1.nextInt(offset) + 1 + (i * offset);
                double randomQ = ((double) (random2.nextInt(offset) + 1 + (i * offset))) / 100;
                double R = beta * randomQ;

                int P = (int) (randomK * R);

                if (P == 0) P = 1;
                output[i][1] = P;
                output[i][0] = randomK;
            }
        }

        return output;
    }

    static int[][] generatePlansWithR(int plans, double R) {
        int[][] output = new int[plans][2];
        int offset = 100 / plans;
        Random random1 = new Random();

        for (int i = 0; i < plans; i++) {
            int randomK = random1.nextInt(offset) + 1 + (i * offset);

            int P = (int) (randomK * R);

            if (P == 0) P = 1;
            output[i][1] = P;
            output[i][0] = randomK;
        }

        return output;
    }
}
