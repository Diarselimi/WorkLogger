package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateService {

    private final Date date;

    public DateService(Date date) {
        this.date = date;
    }

    public String toFormat(String format)
    {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(this.date);
    }

    public Date fromFormat(String dateTime)
    {
        return new Date();
    }

    /**
     * Get a diff between two dates
     * @param date the oldest date
     * @return the diff value, in the provided unit
     */
    public long getDiff(Date date) {
        long diffInMillies = date.getTime() - this.date.getTime();
        return TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
