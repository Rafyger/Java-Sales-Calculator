public class SalesCalculator {

    public static double computeIncome(double salesAmount) {
        double baseSalary = 5000;
        double commission = 0;

        double tier1Max = 5000;
        double tier2Max = 10000;
        double tier3Max = Double.MAX_VALUE;

        double rateTier1 = 0.08;
        double rateTier2 = 0.10;
        double rateTier3 = 0.12;

        if (salesAmount <= tier1Max) {
            commission = salesAmount * rateTier1;
        } else if (salesAmount <= tier2Max) {
            commission = (tier1Max * rateTier1) + ((salesAmount - tier1Max) * rateTier2);
        } else {
            commission = (tier1Max * rateTier1) + ((tier2Max - tier1Max) * rateTier2) + ((salesAmount - tier2Max) * rateTier3);
        }

        return baseSalary + commission;
    }

    public static void main(String[] args) {
        System.out.println("Sales Amount | Monthly Income");
        System.out.println("------------------------------");
        for (double sales = 1000; sales <= 20000; sales += 1000) {
            double income = computeIncome(sales);
            System.out.printf("$%,10.2f | $%,10.2f\n", sales, income);
        }
    }
}
