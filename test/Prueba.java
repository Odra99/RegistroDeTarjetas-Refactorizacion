
import java.util.Calendar;
import java.util.concurrent.Delayed;




public class Prueba {
    public static void main(String[] args) {
        Calendar tiempo1 = Calendar.getInstance();
        System.out.println(tiempo1.getTime());
        System.out.println(tiempo1.getTimeInMillis());
        System.out.println(tiempo1.getFirstDayOfWeek());
        System.out.println(tiempo1.getWeekYear());
        System.out.println(tiempo1.getCalendarType());
        
        Calendar tiempo2 = Calendar.getInstance();
        System.out.println(tiempo2.getTime());
        System.out.println(tiempo2.getTimeInMillis()-tiempo1.getTimeInMillis());
 }
}
