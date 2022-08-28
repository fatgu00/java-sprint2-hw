import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class YearlyReport {


    private String readFileContentsOrNull(String path) {
        try {
            path="G:\\Git\\dev\\java-sprint2-hw-main\\resources\\" + path;
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
    HashMap<Integer,ArrayList<DataForYear>> year ;


    void record(){
        year = new HashMap<>();
        String path = "y.2021.csv";
        ArrayList<DataForYear> dataForYears = new ArrayList<>();
        String fileContents = readFileContentsOrNull(path);
        String[] lines = fileContents.split("\n");
        for (int g = 1; g<lines.length;g++) {
            String line = lines[g];
            String[] lineContents = line.split(",");
            dataForYears.add(new DataForYear(Integer.parseInt(lineContents[0]),Integer.parseInt(lineContents[1]),Boolean.parseBoolean(lineContents[2])));
        }
        year.put(2021,dataForYears);

    }


    int avgExpenses(){
        int avg = 0;
        for (Integer years:year.keySet()){
            ArrayList<DataForYear> value = year.get(years);
            int expens = 0;
            for (DataForYear valuse:value){
                if (valuse.is_expense == false){
                    expens += valuse.amount;
                }

            }
            avg = expens/(value.size()/2);
        }
        return avg;
    }

    int avgIncome(){
        int avg = 0;
        for (Integer years:year.keySet()){
            ArrayList<DataForYear> value = year.get(years);
            int expens = 0;
            for (DataForYear vvv:value){
                if (vvv.is_expense == true){
                    expens += vvv.amount;
                }

            }
            avg = expens/(value.size()/2);
        }
        return avg;
    }
    ArrayList<DataForYear> truee= new ArrayList<>();
    ArrayList<DataForYear> falese = new ArrayList<>();
    void profitOfMonth(){

        for (Integer years:year.keySet()){

            ArrayList<DataForYear> value = year.get(years);

            for (DataForYear vfl:value) {
                if (vfl.is_expense == false ) {
                    falese.add(vfl);
                }
                else {
                    truee.add(vfl);
                }
            }
            int profit = 0;
            for (DataForYear fales:falese){
                for (DataForYear tree:truee){
                    if (fales.month == tree.month){
                        profit=fales.amount-tree.amount;
                        if (tree.month == 1){
                            System.out.println("Профит за январь "+profit);
                        }
                        if (tree.month == 2){
                            System.out.println("Профит за февраль "+profit);
                        }
                        if (tree.month == 3){
                            System.out.println("Профит за март "+profit);
                        }
                    }
                }
            }

        }

    }
    void dataValidation(){
        falese.get(1);

    }

    public class DataForYear {
        int month;
        int amount;
        boolean is_expense;
        public int getAmount() {
            return amount;
        }
        public String toString(){
            return month +" "+amount+" "+is_expense;
        }

        DataForYear(int month,int amount,boolean is_expense){
            this.month=month;
            this.amount=amount;
            this.is_expense=is_expense;
        }
    }
}
