import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadAssistant assistant = new CadAssistant();
        while (true) {
            System.out.println("Введите сумму за квадратный метр(end для выхода)"); //  в среднем 100_000
            String input = scanner.nextLine();
            if (input.equals("end")) break;

            System.out.println(assistant.printDeals(Integer.parseInt(input)));
        }
    }

}
