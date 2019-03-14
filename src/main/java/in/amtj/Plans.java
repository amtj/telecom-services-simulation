package in.amtj;

import java.util.Random;

public class Plans {

    static int[][] generatePlans(int plans, double beta) {
        int[][] output = new int[plans][2];
        double QOffset = 0.20;
        int priceOffset = 100 / plans;
        Random random = new Random();

        for (int i = 0; i < plans; i++) {
            double Q = (random.nextDouble() * 0.2) + (i + 1) * QOffset;
            double R = beta * Q / (1 - beta);

            int randomP = random.nextInt(33) + 1;
            output[i][1] = randomP + priceOffset * (i + 1);
            output[i][0] = (int) ((double) output[i][1] / R);
        }

        return output;
    }
}
