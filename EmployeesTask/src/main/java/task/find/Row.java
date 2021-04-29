package task.find;

import task.find.DateRange;

public class Row {
    private final String employeeId;
    private final String projectId;
    private DateRange dateRange;

    public Row(String employeeId, String projectId,  String startDate, String endDate) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.dateRange = new DateRange(startDate, endDate);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public DateRange getDateRange() {
        return dateRange;
    }


}
