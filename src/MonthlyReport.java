
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MonthlyReport {


    HashMap<Integer, ArrayList<MonthData>> month;
    String path=null;
    void record(ReadFileContents readFileContents) {
        month = new HashMap<>();

        for (int i = 1; i < 4; i++) {

                path = "m.20210" + i + ".csv";

             ArrayList<MonthData> monthData = new ArrayList<>();
             String fileContents = readFileContents.readFileContentsOrNull(path);
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
                if (sum.isExpense == false) {
                    sumFalse = sum.sumOfOne * sum.quantity;
                    if (maxFalse < sumFalse) {
                        maxFalse = sumFalse ;
                        name = sum.itemName;
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
                if (sum.isExpense == true) {
                    sumTrue = sum.sumOfOne * sum.quantity;
                    if (maxTrue < sumTrue) {
                        maxTrue = sumTrue;
                        name = sum.itemName;
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
                if (val.isExpense==false){
                    multiply=val.sumOfOne*val.quantity;
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
                if (val.isExpense==true){
                    multiply=val.sumOfOne*val.quantity;
                    sum+=multiply;
                }

            }
        return sum;
    }

    public class MonthData {

        public String itemName;
        public boolean isExpense;
        public int quantity;
        public int sumOfOne;

        public MonthData(String itemName,
                         boolean isExpense,
                         int quantity,
                         int sumOfOne) {
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;

        }

    }

}


