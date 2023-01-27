import java.io.Serializable;

public class subscrition implements Serializable {
    private int installfee; // fixed fee :100rs/tv
    private  int nbtv ;
    private subscriber subscriber;
    private subscriptioncycle cycle;
    private String datee;
    private int totalfee;

    public subscrition(int nbtv, subscriber subscriber, subscriptioncycle cycle, String datee) {
        this.nbtv = nbtv;
        this.subscriber = subscriber;
        this.cycle = cycle;
        this.datee = datee;
        this.installfee = nbtv*100; /// installation fee //
    }

    public int getNbtv() {
        return nbtv;
    }

    public void setNbtv(int nbtv) {
        this.nbtv = nbtv;
    }

    public subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public subscriptioncycle getCycle() {
        return cycle;
    }

    public void setCycle(subscriptioncycle cycle) {
        this.cycle = cycle;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public int getTotalfee() {
        totalfee = installfee +1500;
        return totalfee;
    }


    @Override
    public String toString() {
        return "subscrition{" +
                "installfee=" + installfee +
                ", nbtv=" + nbtv +
                ", subscriber=" + subscriber +
                ", cycle=" + cycle +
                ", today='" + datee +
                '}';
    }

}
