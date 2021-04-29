package task.find;

import java.util.Objects;

public class Team {

    private String firstEmployeeID;
    private String secondEmployeeID;

    public Team(String firstEmployeeID, String secondEmployeeID) {
        this.firstEmployeeID = firstEmployeeID;
        this.secondEmployeeID = secondEmployeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team that = (Team) o;
        if(firstEmployeeID.equals(that.firstEmployeeID) && secondEmployeeID.equals(that.secondEmployeeID)){
            return true;
        }
        else{
            return firstEmployeeID.equals(that.secondEmployeeID) && secondEmployeeID.equals(that.firstEmployeeID);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstEmployeeID, secondEmployeeID);
    }

    @Override
    public String toString() {
        return
                "firstEmployeeID='" + firstEmployeeID + '\'' +
                ", secondEmployeeID='" + secondEmployeeID + '\'' ;
    }
}
