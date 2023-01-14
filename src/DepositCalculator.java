import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double Scale = Math.pow(10, places);//для названия переменных рекомендую использовать нижний верблюжий регистр
        return Math.round(value * Scale) / Scale;
    }

    void calculateDeposit() {
        int period;//Прекрасный пример использования отступов. 4 пробела - золотой стандарт)
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();/*переменную amount советую объявить в начале тела метода вместе с остальными
        переменными: period и action */
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();/*Соглашусь использование 2-ух дополнительных пробелов делает код более читабельным,
         но тем не менее я бы рекомендовал разделять логически завершенные куски кода пустой строкой.*/
        System.out.println ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        }else if (action == 2) {//рекомендую добавить пробел перед else
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }//У идеи есть функция форматирования кода. Выделяешь код, затем исользуешь комбинацию клавиш Ctrl+Alt+L (для винды)
}//Полезная штука для автоматического расставления пропущенных пробелов и отступов