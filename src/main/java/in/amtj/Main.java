package in.amtj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
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
        int[] userCount = MapUsersPlans.map(usersQualityPrice, plansQualityPrice, totalPlans);
        int[] userTelecos = new int[telecos];

        for (int i = 0; i < telecos; i++) {
            for (int j = 0; j < plans; j++) {
                userTelecos[i] = userTelecos[i] + userCount[i * telecos + j];
            }

            System.out.println("Users for telecom " + i + " are: " + userTelecos[i]);
        }
    }
}
