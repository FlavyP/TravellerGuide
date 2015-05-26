package traveller.model;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A class representing a date with a day, a month and a year.
 * 
 * @author Flavian Popa
 * @author Gytis Kuosaitis
 * @author Julius Jurgauskas
 * @author Mihaela Diaconescu
 * @version 1.0
 */

public class MyDate
{
   private int year;
   private int month;
   private int day;

   /**
    * Three-argument constructor.
    * @param day the date's day
    * @param month the date's month
    * @param year the date's year
    */
   public MyDate(int year, int month, int day)
   {
      this.year = year;
      this.month = month;
      this.day = day;
   }

   /**
    * No-argument constructor.
    */
   public MyDate()
   {
      year = today().getYear();
      month = today().getMonth();
      day = today().getDay();
   }

   /**
    * Gets the date's day.
    * @return the date's day
    */
   public int getDay()
   {
      return day;
   }

   /**
    * Sets the date's day.
    * @param day what the date's day will be set to
    */
   public void setDay(int day)
   {
      this.day = day;
   }

   /**
    * Gets the date's month.
    * @return the date's month
    */
   public int getMonth()
   {
      return month;
   }

   /**
    * Sets the date's month.
    * @param month what the date's month will be set to
    */
   public void setMonth(int month)
   {
      this.month = month;
   }

   /**
    * Gets the date's year.
    * @return the date's year
    */
   public int getYear()
   {
      return year;
   }

   /**
    * Sets the date's year.
    * @param year what the date's year will be set to
    */
   public void setYear(int year)
   {
      this.year = year;
   }

   /**
    * Gets a new MyDate object set to today's date.
    * @return new MyDate object set to today's date.
    */
   public static MyDate today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();

      int currentDay;
      int currentMonth;
      int currentYear;
      currentDay = currentDate.get(GregorianCalendar.DATE);
      currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      currentYear = currentDate.get(GregorianCalendar.YEAR);

      return new MyDate(currentYear, currentMonth, currentDay);
   }

   public boolean isBefore(MyDate date)
   {
      if (year < date.year)
         return true;
      if (year == date.year && month < date.month)
         return true;
      if (year == date.year && month == date.month && day < date.day)
         return true;
      else
         return false;
   }

   /**
    * Makes a copy of a date.
    * @return a copy of that date
    */
   public MyDate copy()
   {
      return new MyDate(year, month, day);
   }

   /**
    * Gets the number of days between the two MyDate objects.
    * @param date1 first date.
    * @param date2 second date.
    * @return number of days between two dates.
    */
   public static int numberOfDays(MyDate date1, MyDate date2)
   {
      java.util.Calendar cal1 = new java.util.GregorianCalendar();
      java.util.Calendar cal2 = new java.util.GregorianCalendar();

      cal1.set(date1.getYear(), date1.getMonth(), date1.getDay());
      cal2.set(date2.getYear(), date2.getMonth(), date2.getDay());

      return daysBetween(cal1.getTime(), cal2.getTime());
   }

   /**
    * Gets the number of days between the two Date objects.
    * @param d1 first date.
    * @param d2 second date.
    * @return number of days between two dates.
    */
   public static int daysBetween(Date d1, Date d2)
   {
      return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
   }
   
   /**
    * Returns a string representation of the date.
    * @return a string representation of the date in the format: "day / month / year"
    */
   public String toString()
   {

      if (month < 10 && day < 10)
      {
         return year + "-0" + month + "-0" + day;
      }

      else if (month < 10)
      {
         return year + "-0" + month + "-" + day;
      }

      else if (day < 10)
      {
         return year + "-" + month + "-0" + day;
      }

      else
      {
         return year + "-" + month + "-" + day;
      }
   }
}
