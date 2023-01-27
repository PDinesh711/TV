public class kidschannel extends  TvChannel{
    int additionfee=55;
    public kidschannel(String channelname, String language,
                       String catagery, int price) {
        super(channelname, language, catagery, price);
    }
    @Override
    public int getPrice() {
        return super.getPrice() + additionfee;
    }

}
