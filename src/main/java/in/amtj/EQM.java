package in.amtj;

class EQM {

    static double[] findEQM(double alpha) {
        double slopeDemand;
        if (alpha >= 0.5) slopeDemand = alpha / (alpha - 1);
        else slopeDemand = (alpha - 1) / alpha;

        double slopeSupply;
        if (alpha >= 0.5) slopeSupply = alpha / (1 - alpha);
        else slopeSupply = (1 - alpha) / alpha;

        double c1 = 1 / slopeDemand; // default intercept on y-axis for demand graph is set to 1
        double c2 = 0 / slopeSupply; // default intercept on y-axis for supply graph is set to 0

        double[] output = new double[2];

        // R = P/K
        if (alpha >= 0.5) output[0] = ((c1 - c2) / 2) * (alpha / (alpha - 1));
        else output[0] = ((c1 - c2) / 2) * ((alpha - 1) / alpha);

        output[1] = -(c1 + c2) / 2; // Q

        return output;
    }
}
