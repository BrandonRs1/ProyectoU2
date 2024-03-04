import java.util.Calendar;

public class Date {
    static Calendar Hour = Calendar.getInstance();
    static Calendar Date = Calendar.getInstance();

    private String day;
    private String month;
    private String year;
    private String publishDate;

    public String currentDate() {
        int hour, minut, segs, day, month, year;

        hour = Hour.get(Calendar.HOUR_OF_DAY);
        minut = Hour.get(Calendar.MINUTE);
        segs = Hour.get(Calendar.YEAR);

        day = Date.get(Calendar.DATE);
        month = Date.get(Calendar.MONTH);
        year = Date.get(Calendar.YEAR);

        String date = "Date: " + day + "/" + month + "/" + year + "\t\t";
        String hours = "Hour: " + hour + ":" + minut + ":" + segs;

        return date + hours;
    }

    public String publishYear(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
        publishDate = day + "/" + month + "/" + year;
        return publishDate;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getPublishDateS() {
        return publishDate;
    }

    public String getYear() {
        return year;
    }

    public void setBirthDay(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String birthDay() {
        String birth;
        birth = day + "/" + month + "/" + year;
        return birth;
    }

}