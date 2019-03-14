package in.amtj;

class MapUsersPlans {

    static int[] generateMap(int[][] usersQualityPrice, int[][] plansQualityPrice, int totalPlans) {
        int[] userCount = new int[totalPlans];
        int maxQualityPlan = 0;

        for (int foo = 0; foo < totalPlans; foo++) {
            if (plansQualityPrice[foo][0] > plansQualityPrice[maxQualityPlan][0]) {
                maxQualityPlan = foo;
            }
        }

        for (int i = 0; i < usersQualityPrice.length; i++) {
            int plan = -1;

            if (usersQualityPrice[i][0] > 50) {
                for (int j = 0; j < totalPlans; j++) {
                    if (plansQualityPrice[j][0] >= usersQualityPrice[i][0]) {
                        if (plan == -1) {
                            plan = j;
                        }
                        else if (plansQualityPrice[j][1] < plansQualityPrice[plan][1]){
                            plan = j;
                        }
                    }
                }

                if (plan == -1) {
                    userCount[maxQualityPlan]++;
                }
                else {
                    userCount[plan]++;
                }
            }
            else {
                for (int j = 0; j < totalPlans; j++) {
                    if (plansQualityPrice[j][1] <= usersQualityPrice[i][1]) {
                        if (plan == -1) {
                            plan = j;
                        }
                        else if (plansQualityPrice[j][0] > plansQualityPrice[plan][0]){
                            plan = j;
                        }
                    }
                }

                if (plan != -1) userCount[plan]++;
            }
        }

        return userCount;
    }
}
