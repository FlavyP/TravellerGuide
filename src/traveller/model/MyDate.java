package traveller.model;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;



public class MyDate implements Serializable
{
   private int year;
   private int month;
   private int day;

  
   public MyDate(int year, int month, int day)
   {
      this.year = year;
      this.month = month;
      this.day = day;
   }

   public MyDate()
   {
      year = today().getYear();
      month = today().getMonth();
      day = today().getDay();
   }

  
   public int getDay()
   {
      return day;
   }

   
   public void setDay(int day)
   {
      this.day = day;
   }

  
   public int getMonth()
   {
      return month;
   }

   
   public void setMonth(int month)
   {
      this.month = month;
   }

   
   public int getYear()
   {
      return year;
   }

   
   public void setYear(int year)
   {
      this.year = year;
   }

  
   public static MyDate today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();

      int currentDay;
      int currentMonth;
      int currentYear;
      currentDay = currentDate.get(GregorianCalendar.DATE);
      currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      currentYear = currentDate.get(GregorianCalendar.YEAR);

//      return new MyDate(currentDay, currentMonth, currentYear);
      return new MyDate(currentYear, currentMonth, currentDay);
   }

 
   public boolean isLeapYear()
   {
      if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   
   public int daysInMonth(int month)
   {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12)
      {
         return 31;
      }

      else if (month == 2 && isLeapYear() == true)
      {
         return 29;
      }

      else if (month == 2 && isLeapYear() == false)
      {
         return 28;
      }

      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
         return 30;
      }

      return 0;
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

   
   public boolean is4DaysBefore(MyDate date)
   {

      int pday = date.day;
      int pmonth = date.month;
      int pyear = date.year;

      if (this.day == (pday - 4) && (pday - 4) > 0 && this.month == pmonth && this.year == pyear)
      {
         return true;
      }

      else if (pday - 4 <= 0)
      {
         pmonth = pmonth - 1;
         if (pmonth <= 0)
         {
            pyear = pyear - 1;
            pmonth = 12;
         }

         pday = (daysInMonth(pmonth) - (4 - date.day));

      }

      if (this.day == pday && this.month == pmonth && this.year == pyear)
      {
         return true;
      }

      return false;
   }

   
   public boolean is2DaysAfter(MyDate date)
   {
      int returnDay = date.day;
      int returnMonth = date.month;
      int returnYear = date.year;
      returnDay = returnDay + 2;

      if (this.day == (returnDay)
            && (returnDay) <= daysInMonth(returnMonth)
            && this.month == returnMonth && this.year == returnYear)
      {
         return true;
      }

      else if (returnDay> daysInMonth(returnMonth))
      {

         returnMonth = returnMonth + 1;
         returnDay = returnDay - daysInMonth(returnMonth - 1);

         if (returnMonth > 12)
         {
            returnMonth = 1;
            returnYear = returnYear + 1;
         }

      }

      if (this.day == returnDay && this.month == returnMonth && this.year == returnYear)
      {
         return true;
      }

      return false;

   }
   
   
   public MyDate copy()
   {
      return new MyDate(year, month, day);
   }

   
   public String toString()
   {
      
      if(month < 10 && day < 10)
      {
         return year + "-0" + month + "-0" + day;
      }
      
      else if(month < 10)
      {
         return year + "-0" + month + "-" + day;
      }
      
      else if(day < 10)
      {
         return year + "-" + month + "-0" + day;
      }
      
      else
      {
         return year + "-" + month + "-" + day;
      }
   }
   
   public static int numberOfDays(MyDate date1, MyDate date2)
   {
      java.util.Calendar cal1 = new java.util.GregorianCalendar();
      java.util.Calendar cal2 = new java.util.GregorianCalendar();
      
      cal1.set(date1.getYear(), date1.getMonth(), date1.getDay());
      cal2.set(date2.getYear(), date2.getMonth(), date2.getDay());
      
      return daysBetween(cal1.getTime(),cal2.getTime());
   }
   
   public static int daysBetween(Date d1, Date d2)
   {
      return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
   }
}
