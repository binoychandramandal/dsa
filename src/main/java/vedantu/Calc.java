package vedantu;

public class Calc {
    public static void main(String[] args) {

        double medicinePrincipal = 3000000;
        double bankingPrincipal = 4000000;
        System.out.println(format(durationAmount(medicinePrincipal, 3, bankingPrincipal, 2.4, 12)));

    }

    static double durationAmount(double medicine, double medicineIr, double banking, double bIr, int tenure) {
        int i = 1;
        double initialPrincipal = medicine + banking;
        double interest = 0;
        double totalInterest = 0;
        System.out.println("Initial principal-> " + format( initialPrincipal));
        while (i++ <= tenure) {
            System.out.println(format(interest) + " : Monthly-> " + format(getSimpleInterest(interest, 2.4)));
            interest += getSimpleInterest(interest, 2.4);
            interest += getMonthlyMedicineInterest(medicine, medicineIr);
            interest += getMonthlyBankingInterest(banking, bIr);
        }
        System.out.println("Interest-> " + format(interest));
        return initialPrincipal + interest;
    }

    static String format(Double input) {
        return String.format("%,.2f", input);
    }

    static double getMonthlyBankingInterest(double banking, double bIr) {
        double bankingMonthlyI = getSimpleInterest(banking, bIr);
        return bankingMonthlyI;
    }

    static double getMonthlyMedicineInterest(double medicine, double medicineIr) {
        double medicineMonthlyI = getSimpleInterest(medicine, medicineIr);
        return medicineMonthlyI;
    }

    static double getSimpleInterest(double principal, double ir) {
        return (principal * ir) / 100;
    }
}
