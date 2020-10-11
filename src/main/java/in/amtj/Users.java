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

        for (int i = 0; i < users; i++) {
            double randomQ = random.nextDouble();
            double R = alpha * randomQ + 1;
            int randomK = random.nextInt(100) + 1;
            int P = (int) (randomK * R);

            output[i][0] = randomK;
            output[i][1] = P;
        }

        return output;
    }

    static int[][] generateUniformUsers() {
        int[][] output = new int[100000][2];

        for (int i = 0; i < 100; i++) {
            double R = ((double)(100 - i)) / 100;

            for (int K = 1; K <= 100; K++) {
                for (int foo = 0; foo < 10; foo++) {
                    int bar = i * 1000 + (K - 1) * 10 + foo;
                    output[bar][0] = K;
                    output[bar][1] = (int) Math.ceil(R * K);
                }
            }
        }

        return output;
    }

    static int[][] generateSkewedUsers() {
        int[][] output = new int[100000][2];

        for (int i = 0; i < 50; i++) {


            for (int K = 1; K <= 100; K++) {
                for (int foo = 0; foo < 10; foo++) {
                    double R = ((double)(100 - i)) / 100;

                    if (foo % 2 != 0) {
                        R = R / 4;
                    }

                    int bar = i * 1000 + (K - 1) * 10 + foo;
                    output[bar][0] = K;
                    output[bar][1] = (int) Math.ceil(R * K);
                }
            }
        }

        for (int i = 50; i < 100; i++) {
            double R = ((double)(100 - i)) / 100;

            for (int K = 1; K <= 100; K++) {
                for (int foo = 0; foo < 10; foo++) {
                    int bar = i * 1000 + (K - 1) * 10 + foo;
                    output[bar][0] = K;
                    output[bar][1] = (int) Math.ceil(R * K);
                }
            }
        }

        return output;
    }
}
