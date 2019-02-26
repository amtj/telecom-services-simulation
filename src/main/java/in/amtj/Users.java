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
}
