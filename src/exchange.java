public class exchange {
    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private String GBP;
    private String JPY;
    private String EUR;

    public exchange(boolean success, int timestamp, String base, String date, String GBP, String JPY, String EUR) {
        this.success = success;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
        this.GBP = GBP;
        this.JPY = JPY;
        this.EUR = EUR;
    }

    @Override
    public String toString() {
        return "success = " + success + ", timestamp = " + timestamp + ", base = " + base + ", date = " + date + ", GBP = " + GBP + ", JPY = " + JPY + ", EUR = " + EUR;
    }
}