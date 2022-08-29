import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {

    HashMap<Integer,ArrayList<DataForYear>> year ;

    void record(MonthlyReport monthlyReport){
        year = new HashMap<>();
        String path = "y.2021.csv";
        ArrayList<DataForYear> dataForYears = new ArrayList<>();
        String fileContents = monthlyReport.readFileContentsOrNull(path);
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
                if (valuse.isExpense == false){
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
                if (vvv.isExpense == true){
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
                if (vfl.isExpense == false ) {
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

    public class DataForYear {
        int month;
        int amount;
        boolean isExpense;
        public String toString(){
            return month +" "+amount+" "+isExpense;
        }

        DataForYear(int month,int amount,boolean isExpense){
            this.month=month;
            this.amount=amount;
            this.isExpense=isExpense;
        }
    }
}
