import java.util.Scanner;

public class DepositCalculator {

    double calculateDepositWithCapitalization(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateDepositSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount + depositAmount * yearRate * depositPeriod;
        return round(pay, 2);
    }

    double round(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculatePercentages() {
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double resultOfDeposit = 0;

        if (action == 1) {
            resultOfDeposit = calculateDepositSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            resultOfDeposit = calculateDepositWithCapitalization(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultOfDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePercentages();
    }

}
