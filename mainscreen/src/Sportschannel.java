public class Sportschannel extends TvChannel {
    int additionfee = 40;
    public Sportschannel(String channelname, String language, String catagery, int price) {
        super(channelname, language, catagery, price);
    }
    @Override
    public int getPrice() {
        return super.getPrice() + additionfee;
    }

}
