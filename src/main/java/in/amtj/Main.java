package in.amtj;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10000; i++) scenarioInfinite();
    }

    static void scenarioInfinite() throws IOException {
        int[][] usersQualityPrice = Users.generateUniformUsers();
        int[][] plansQualityPrice1 = Plans.generatePlansWithR(3, 0.75);
        int[][] plansQualityPrice2 = Plans.generatePlansWithR(3, 0.25);
        int[][] plansQualityPrice  = new int[6][2];

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                plansQualityPrice[i][0] = plansQualityPrice1[i][0];
                plansQualityPrice[i][1] = plansQualityPrice1[i][1];
            }
            else {
                plansQualityPrice[i][0] = plansQualityPrice2[i - 3][0];
                plansQualityPrice[i][1] = plansQualityPrice2[i - 3][1];
            }
        }

        int[] usersPerPlan = MapUsersPlans.generateMap(usersQualityPrice, plansQualityPrice, 6);
        int[] usersPerTelcom = new int[2];
        int[] revenuePerTelcom = new int[2];
        int[] qualityUsedPerTelcom = new int[2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                usersPerTelcom[i] = usersPerTelcom[i] + usersPerPlan[i * 3 + j];
                revenuePerTelcom[i] = revenuePerTelcom[i] + plansQualityPrice[i * 3 + j][1] * usersPerPlan[i * 3 + j];
                qualityUsedPerTelcom[i] = qualityUsedPerTelcom[i] + plansQualityPrice[i * 3 + j][0] * usersPerPlan[i * 3 + j];
            }
        }

        FileWriter fw = new FileWriter("0.txt", true);
        fw.write(usersPerTelcom[0] + "\t");
        fw.write(revenuePerTelcom[0] + "\t");
        fw.write(qualityUsedPerTelcom[0] + "\t");
        fw.write(usersPerTelcom[1] + "\t");
        fw.write(revenuePerTelcom[1] + "\t");
        fw.write(qualityUsedPerTelcom[1] + "\n");
        fw.close();

    }

    static void scenario2() throws IOException {
        int users = 100000;
        double alpha = -5;
        int[][] usersQualityPrice = Users.generateSkewedUsers();
        int[][] plansQualityPrice1 = Plans.generatePlans(3, 2);
        int[][] plansQualityPrice2 = Plans.generatePlans(3, 1);
        int[][] plansQualityPrice3 = Plans.generatePlans(3, 0.5);
        int[][] plansQualityPrice4 = Plans.generatePlans(3, 0.25);
        int[][] plansQualityPrice  = new int[12][2];

        for (int i = 0; i < 12; i++) {
            if (i < 3) {
                plansQualityPrice[i][0] = plansQualityPrice1[i][0];
                plansQualityPrice[i][1] = plansQualityPrice1[i][1];
            }
            else if (i < 6) {
                plansQualityPrice[i][0] = plansQualityPrice2[i - 3][0];
                plansQualityPrice[i][1] = plansQualityPrice2[i - 3][1];
            }
            else if (i < 9) {
                plansQualityPrice[i][0] = plansQualityPrice3[i - 6][0];
                plansQualityPrice[i][1] = plansQualityPrice3[i - 6][1];
            }
            else {
                plansQualityPrice[i][0] = plansQualityPrice4[i - 9][0];
                plansQualityPrice[i][1] = plansQualityPrice4[i - 9][1];
            }
        }

        int[] usersPerPlan = MapUsersPlans.generateMap(usersQualityPrice, plansQualityPrice, 12);
        int[] usersPerTelcom = new int[4];
        int[] revenuePerTelcom = new int[4];
        int[] qualityUsedPerTelcom = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                usersPerTelcom[i] = usersPerTelcom[i] + usersPerPlan[i * 3 + j];
                revenuePerTelcom[i] = revenuePerTelcom[i] + plansQualityPrice[i * 3 + j][1] * usersPerPlan[i * 3 + j];
                qualityUsedPerTelcom[i] = qualityUsedPerTelcom[i] + plansQualityPrice[i * 3 + j][0] * usersPerPlan[i * 3 + j];
            }
        }

        FileWriter fw = new FileWriter("0.txt", true);
        fw.write(usersPerTelcom[0] + "\t");
        fw.write(revenuePerTelcom[0] + "\t");
        fw.write(qualityUsedPerTelcom[0] + "\t");
        fw.write(usersPerTelcom[1] + "\t");
        fw.write(revenuePerTelcom[1] + "\t");
        fw.write(qualityUsedPerTelcom[1] + "\t");
        fw.write(usersPerTelcom[2] + "\t");
        fw.write(revenuePerTelcom[2] + "\t");
        fw.write(qualityUsedPerTelcom[2] + "\t");
        fw.write(usersPerTelcom[3] + "\t");
        fw.write(revenuePerTelcom[3] + "\t");
        fw.write(qualityUsedPerTelcom[3] + "\n");
        fw.close();

    }

    static void scenario1() throws IOException {
        int users = 100000;

        File file = new File("C:\\Users\\Toji\\Desktop\\telecom-services-simulation\\input\\1");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        System.out.print("Enter α(number of quality consious customers percentage): ");
        double alpha = Double.parseDouble(bufferedReader.readLine()) / 100;
        System.out.println((int) (alpha * 100) + "%");

        if (alpha > 1 || alpha < 0) {
            System.out.println("Invalid α, please enter α again: ");
            return;
        }

//        double[] eqm = EQM.findEQM(alpha);
//        System.out.println(eqm[0]);
//        System.out.println(eqm[1]);

//        double[] eqm = EQM.findEQM(0.9, 0.9);
//        System.out.println("P/K = " + eqm[0]);
//        System.out.println("Q   = " + eqm[1]);

        System.out.print("Enter number of telecos: ");
        int telecos = Integer.parseInt(bufferedReader.readLine());
        System.out.println(telecos);
        int[] capacity = new int[telecos];
        int availableCapacity = 100;
        System.out.println("Total capacity is 100.");

        for (int i = 1; i <= telecos; i++) {
            System.out.print("Enter capacity for telecom " + i + ": ");
            capacity[i - 1] = Integer.parseInt(bufferedReader.readLine());
            System.out.println(capacity[i - 1]);
            availableCapacity = availableCapacity - capacity[i - 1];
        }

        if (availableCapacity < 0) {
            System.out.println("Entered capacities are wrong. Please try again.");
            System.out.println("Total capacity is 100.");
            return;
        }

        System.out.print("Enter number of plans for each telecom: ");
        int plans = Integer.parseInt(bufferedReader.readLine());
        System.out.println(plans);
        int totalPlans = telecos * plans;
        int[][] plansQualityPrice = new int[totalPlans][2];

        for (int i = 0; i < telecos; i++) {
            for (int j = 0; j < plans; j++) {
                System.out.print("Enter quality of plan " + (j + 1) + " for telecom " + (i + 1) + ": ");
                plansQualityPrice[i * telecos + j][0] = Integer.parseInt(bufferedReader.readLine());
                System.out.println(plansQualityPrice[i * telecos + j][0]);
                System.out.print("Enter price of plan " + (j + 1) + " for telecom " + (i + 1) + ": ");
                plansQualityPrice[i * telecos + j][1] = Integer.parseInt(bufferedReader.readLine());
                System.out.println(plansQualityPrice[i * telecos + j][1]);
            }
        }

        int[][] usersQualityPrice = Users.generateUsers(users, alpha);
        int[] usersPerPlan = MapUsersPlans.generateMap(usersQualityPrice, plansQualityPrice, totalPlans);
        int[] usersPerTelcom = new int[telecos];

        for (int i = 0; i < telecos; i++) {
            for (int j = 0; j < plans; j++) {
                usersPerTelcom[i] = usersPerTelcom[i] + usersPerPlan[i * telecos + j];
            }

            System.out.println("Users for telecom " + i + " are: " + usersPerTelcom[i]);
        }
    }


}
