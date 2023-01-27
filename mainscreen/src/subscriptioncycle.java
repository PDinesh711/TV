import java.io.Serializable;

public class subscriptioncycle implements Serializable {
    private String startdate ;
    private  String enddate;

    public subscriptioncycle(String startdate, String enddate) {
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "subscriptioncycle{" +
                "startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                '}';
    }
}

