public class moviechannel extends  TvChannel{
    int additionfee =60;
    public moviechannel(String channelname, String language, String catagery, int price) {
        super(channelname, language, catagery, price);
    }
    @Override
    public int getPrice() {
        return super.getPrice() + additionfee;
    }

}
