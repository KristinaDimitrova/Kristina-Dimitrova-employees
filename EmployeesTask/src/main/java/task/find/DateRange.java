package task.find;

import org.ocpsoft.prettytime.nlp.PrettyTimeParser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateRange {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public DateRange(String start, String end) {
        this.startDate = convertStringToLocalDate(start);
        if(end.equalsIgnoreCase("null")){
            this.endDate = LocalDate.now();
        }
        else{
            this.endDate = convertStringToLocalDate(end);
        }
    }

    private LocalDate convertStringToLocalDate(String date) {
        List<Date> parse = new PrettyTimeParser().parse(date);
        return parse
                .get(0)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


    public long commonDays(DateRange otherDateRange) {
        LocalDate biggerStartDate = biggerStartDate(otherDateRange.startDate);
        LocalDate smallerEndDate = smallerEndDate(otherDateRange.endDate);
        return DAYS.between(biggerStartDate, smallerEndDate);
    }

    private LocalDate biggerStartDate(LocalDate otherStartDate){
        if(this.startDate.compareTo(otherStartDate) < 0){
            return otherStartDate;
        }
        return this.startDate;
    }

    private LocalDate smallerEndDate(LocalDate otherEndDate){
        if(this.startDate.compareTo(otherEndDate) < 0){
            return otherEndDate;
        }
        return this.startDate;
    }


}
