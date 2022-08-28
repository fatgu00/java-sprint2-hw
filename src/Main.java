
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();


        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                monthlyReport.record();
            } else if (userInput == 2) {
                yearlyReport.record();
            } else if (userInput == 3) {
                   for (Integer years:yearlyReport.year.keySet()) {
                       ArrayList<YearlyReport.DataForYear> value = yearlyReport.year.get(years);
                       for (YearlyReport.DataForYear values : value) {
                           for (Integer month : monthlyReport.month.keySet()) {
                               if (values.is_expense == false) {
                                   if (month == values.month) {
                                       if (monthlyReport.totalIncome(month)==values.amount){
                                           System.out.println("Проверка прошла успешна.Ошибок не выявленно!");
                                       }
                                       else {
                                           System.out.println("Ошибка в месяце под номером " + values.month);
                                       }
                                   }
                               } else {
                                   if (month==values.month){
                                       if(monthlyReport.totalExpens(month)==values.amount){
                                           System.out.println("Проверка прошла успешна.Ошибок не выявленно!");
                                       }else {
                                           System.out.println("Ошибка в месяце под номером " + values.month);
                                       }
                                   }
                               }
                           }
                       }
                   }

            }
            else if (userInput == 4) {

                for (Integer month:monthlyReport.month.keySet()){
                    if (month==1){
                        System.out.println("Январь");
                    }
                    else if (month==2){
                        System.out.println("Февраль");
                    }
                    else if (month==3){
                        System.out.println("Март");
                    }
                    System.out.print("Самый прибыльный товар: "); monthlyReport.maxProfit(month);
                    System.out.print("Самая большая трата: ") ; monthlyReport.maxExpens(month);
                }
            }
            else if (userInput == 5) {
                System.out.println("Рассматриваемый год: " + yearlyReport.year.keySet());
                yearlyReport.profitOfMonth();
                System.out.println("Средний расход за все месяца в году: " + yearlyReport.avgExpenses());
                System.out.println("Средний доход  за все месяца в году: " + yearlyReport.avgIncome());
            }
            else {
                System.out.println("Такай команды нет. ");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}

