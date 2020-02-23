package dates;

public class DateOperations {
    /*     LocalDateTime localDateTime = LocalDateTime.of(2020, 02, 13, 6, 39, 02);

        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        System.out.println(localDate.toString());
        System.out.println(localTime.toString());

        String time = "2020/02/01/13/23/34";

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR, 4)
                .appendLiteral('/')
                .appendValue(ChronoField.MONTH_OF_YEAR, 2)
                .appendLiteral('/')
                .appendValue(ChronoField.DAY_OF_MONTH, 2)
                .appendLiteral('/')
                .appendValue(ChronoField.HOUR_OF_DAY)
                .appendLiteral('/')
                .appendValue(ChronoField.MINUTE_OF_HOUR)
                .appendLiteral('/')
                .appendValue(ChronoField.SECOND_OF_MINUTE)
                .toFormatter();

        LocalDateTime localDateTime1 = LocalDateTime.parse(time, formatter);
        System.out.println(localDateTime1);
*/
    //LOCALTIME
    /*LocalTime time = LocalTime.of(6, 39);

        System.out.println("hour" + time.getHour() +" "+ "minute" + time.getMinute() +" "+ " seconds:" + time.getSecond());

        System.out.println(time.toString());

        String stringTime = time.toString();

        LocalTime newTime = LocalTime.parse(stringTime);

        System.out.println("newTime " + newTime );

        String time2 = "17-45";

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.HOUR_OF_DAY,2)
                .appendLiteral('-')
                .appendValue(ChronoField.MINUTE_OF_HOUR)
                .toFormatter();
        LocalTime localTime2 = LocalTime.parse(time2, formatter);

        System.out.println(localTime2);*/

    /*  LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime oneHourLater = now.plusHours(3);
        System.out.println(oneHourLater);

        LocalTime tenMinutesAgo = now.minusMinutes(10);
        System.out.println(tenMinutesAgo);

        LocalTime fiveSecondsLater = now.plus(5, ChronoUnit.SECONDS);
        System.out.println(fiveSecondsLater);

        LocalTime definedTime = LocalTime.of(11, 44, 10);
        System.out.println(definedTime);*/
    //LocalDate

/*   LocalDate date = LocalDate.of(2020,2,1);
        System.out.println(date);

        System.out.println(date.toString());
        String dateString = date.toString();

        LocalDate date1 = LocalDate.parse(dateString);
        System.out.println(date1);

        String newDate = "2020/10/20";
        System.out.println(newDate);

        LocalDate newDAte1 = LocalDate.parse(newDate.replace("/","-"));
        System.out.println(newDAte1);


        LocalDate newDate2 = LocalDate.parse(newDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(newDate2);*/
/*     LocalDate today = LocalDate.now();
        LocalDate tommorow = today.plusDays(1);

        LocalDate twoYearsEgo = today.minusYears(2);
        LocalDate threeMonthLater = today.plus(3, ChronoUnit.MONTHS);
        LocalDate threeMOthEgo = today.minusMonths(3);

        System.out.println(today);
        System.out.println(tommorow);
        System.out.println(twoYearsEgo);
        System.out.println(threeMonthLater);
        System.out.println(threeMOthEgo);
*/
//DATE
/*      Date now = new Date();
        System.out.println(now);
    addOneMinute(now);
        System.out.println(now);

}
    static Date addOneMinute(Date date) {
        date.setTime(date.getTime() + 1_000 * 60);
        return date;
    }
*/

}
