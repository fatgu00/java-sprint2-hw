
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MonthlyReport {


    private String readFileContentsOrNull(String path) {
        try {
            path="G:\\Git\\dev\\java-sprint2-hw-main\\resources\\" + path;

            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }

    }


    HashMap<Integer, ArrayList<MonthData>> month;


    void record() {
        month = new HashMap<>();

        for (int i = 1; i < 4; i++) {

             String path = "m.20210" + i + ".csv";

             ArrayList<MonthData> monthData = new ArrayList<>();
             String fileContents = readFileContentsOrNull(path);
             String[] lines = fileContents.split("\n");
             for (int g = 1; g<lines.length;g++) {
                 String line = lines[g];
                 String[] lineContents = line.split(",");
                 monthData.add(new MonthData(lineContents[0],Boolean.parseBoolean(lineContents[1]),Integer.parseInt(lineContents[2]),Integer.parseInt(lineContents[3])));
             }
             month.put(i,monthData);

        }

    }


    void maxProfit(Integer strings){

        int maxFalse = 0;
            ArrayList<MonthData> value = month.get(strings);
            String name = "";
            for (MonthData sum : value) {
                int sumFalse = 0 ;
                if (sum.is_expense == false) {
                    sumFalse = sum.sum_of_one * sum.quantity;
                    if (maxFalse < sumFalse) {
                        maxFalse = sumFalse ;
                        name = sum.item_name;
                    }

                }

            }


        System.out.println(name + " " + maxFalse);
    }

    void maxExpens(Integer strings){

        int maxTrue = 0;
            ArrayList<MonthData> value = month.get(strings);
            String name = "";
            for (MonthData sum : value) {
                int sumTrue =0;
                if (sum.is_expense == true) {
                    sumTrue = sum.sum_of_one * sum.quantity;
                    if (maxTrue < sumTrue) {
                        maxTrue = sumTrue;
                        name = sum.item_name;
                    }
                }
        }

        System.out.println(name + " " + maxTrue);
    }

    int totalIncome(Integer string){

            ArrayList<MonthData> value = month.get(string);
            int sum = 0;
            for (MonthData val: value){
                int multiply = 0;
                if (val.is_expense==false){
                    multiply=val.sum_of_one*val.quantity;
                    sum+=multiply;
                }

            }
        return sum;
    }
    int totalExpens(Integer strings){
            ArrayList<MonthData> value = month.get(strings);
            int sum = 0;
            for (MonthData val: value){
                int multiply = 0;
                if (val.is_expense==true){
                    multiply=val.sum_of_one*val.quantity;
                    sum+=multiply;
                }

            }
        return sum;
    }




    public class MonthData {


        public String item_name;
        public boolean is_expense;
        public int quantity;
        public int sum_of_one;



        public MonthData(String item_name,
                         boolean is_expense,
                         int quantity,
                         int sum_of_one) {
            this.item_name = item_name;
            this.is_expense = is_expense;
            this.quantity = quantity;
            this.sum_of_one = sum_of_one;

        }

    }

}


