import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileContents {

    public String readFileContentsOrNull(String path) {
        try {
            path="G:\\Git\\dev\\java-sprint2-hw-main\\resources\\" + path;
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    int readFileForMonthlyReport(MonthlyReport monthlyReport){
        if (monthlyReport.path == null){
            System.out.println("Месячные отчеты не считаны. Пожалуста считайте отчет");
            return 1;
        }
        else return 0;
    }
    int readFileForYearlyReport(YearlyReport yearlyReport){
        if(yearlyReport.path==null){
            System.out.println("Годовой отчет не считаны. Пожалуста считайте отчет");
            return 1;
        }
        else return 0;
    }
}
