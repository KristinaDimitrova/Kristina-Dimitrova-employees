package task.find;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Searcher{

    private static final HashMap<Team, HashMap<String, Long>> helperMap = new HashMap<>();

    public static void findTeamLongestWorkedTogether(ArrayList<Row> rows){
        groupTeams(rows);
        Team team = null ;
        long maxDays = 0;
        for(Map.Entry<Team, HashMap<String, Long>> entry : helperMap.entrySet()){
            HashMap<String, Long> mapOfProjectIdAndDaysWorkedTogether = entry.getValue();
            Collection<Long> days  = mapOfProjectIdAndDaysWorkedTogether.values();
            long sum = 0;
            for(Long daysPerProject : days){
                sum += daysPerProject;
            }
            if(sum > maxDays){
                maxDays = sum;
                team = entry.getKey();
            }
        }
        printTeam(team, maxDays);
    }

    private static void printTeam(Team team, Long days){
        HashMap<String, Long> projectsAndHoursOfTheTeam = helperMap.get(team);
        System.out.println("The couple employees who the longest time has been worked together on common projects is : \t" + team);
        for(Map.Entry<String, Long> entry : projectsAndHoursOfTheTeam.entrySet()){
            System.out.println("\t Project id : "+entry.getKey() + "  -  "+ entry.getValue()+ " days");
        }
        System.out.println("They worked together for a total of "+ days +" days.");
    }

    private static void groupTeams(ArrayList<Row> rows){
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            for (int j = i+1; j <rows.size() ; j++) {
                Row otherRow = rows.get(j);
                if(row.getProjectId().equals(otherRow.getProjectId())){
                    Team team = new Team(row.getEmployeeId(), otherRow.getEmployeeId());
                    if(!helperMap.containsKey(team)){
                        helperMap.put(team, new HashMap<>());
                    }
                    helperMap.get(team).put(row.getProjectId(), row.getDateRange().commonDays(otherRow.getDateRange()));
                }
            }
        }
    }
}
