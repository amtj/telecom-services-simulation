package in.amtj;

import java.util.Random;

class Users {

    static int[][] generateUsers(int users, double alpha) {
        int[][] output = new int[users][2];
        Random random = new Random();
        int qualityUsers = (int) (alpha * users);
        int priceUsers = users - qualityUsers;

        for (int i = 0; i < users; i++) {
            int random1 = random.nextInt(100) + 1;
            int random2 = random.nextInt(100) + 1;

            output[i][0] = Math.max(random1, random2);
            output[i][1] = Math.min(random1, random2);

            if ((qualityUsers <= 0 && output[i][1] > 50) || (priceUsers <= 0 && output[i][1] <= 50)) {
                i--;
            }
            else {
                if (output[i][0] > 50) qualityUsers--;
                else priceUsers--;
            }
        }

        return output;
    }

    static int[][] generateUsersFromDemand(int users, double alpha) {
        int[][] output = new int[users][2];
        Random random = new Random();
        int qualityUsers = (int) (alpha * users);
        int priceUsers = users - qualityUsers;

        for (int i = 0; i < users; i++) {
            double randomQ = random.nextDouble();
            double R = (alpha / (alpha - 1)) * randomQ + 1;
            int randomK = random.nextInt(100) + 1;
            int P = (int) (randomK * R);

            output[i][0] = randomK;
            output[i][1] = P;

            if ((qualityUsers <= 0 && output[i][1] > 50) || (priceUsers <= 0 && output[i][1] <= 50)) {
                i--;
            }
            else {
                if (output[i][0] > 50) qualityUsers--;
                else priceUsers--;
            }
        }

        return output;
    }
}
