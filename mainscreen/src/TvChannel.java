public abstract class TvChannel {
    String channelname ;
    String  language;
    String Catagery;
    int price;

    public TvChannel(String channelname, String language, String catagery, int price) {
        this.channelname = channelname;
        this.language = language;
         this.Catagery = catagery;
         this.price=price;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCatagery() {
        return Catagery;
    }

    public void setCatagery(String catagery) {
        Catagery = catagery;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
