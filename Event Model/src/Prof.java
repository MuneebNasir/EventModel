/** SYSC 3101 Event Model
 * @author Muneeb Nasir
 * @version 1.1
 *
 */
import java.util.*;
import java.util.Date;
import java.util.Observable;

public class Prof
{
    private String name;
    private Date midtermDate;
    private List<CourseListener> courseListeners;

    public Prof(String name)
    {
        this.name = name;
        this.courseListeners = new ArrayList<CourseListener>();
    }

    public Date getMidterm() {
        return this.midtermDate;
    }

    public String getName() {
        return this.name;
    }

    /*
        Set Midterm Date Event
        @param date, Date. The Midterm Date
     */
    public void setMidterm(Date date)
    {
        this.midtermDate = date;
        //the prof creates the event and sends it
        CourseEvent event = new CourseEvent(this);
        event.setMidtermDate(date);

        for (CourseListener cl: courseListeners)
        {
            cl.midtermAnnounced(event);
        }

    }

    /*
        Postpone Midterm Event
        @param new_Date, Date. The new date set for the Midterm
     */
    public void postponeMidterm(Date new_Date)
    {
        this.midtermDate = new_Date;
        CourseEvent event = new CourseEvent(this);
        event.setMidtermDate(new_Date);

        for(CourseListener cl: courseListeners)
        {
            cl.midtermPostponed(event);
        }

    }

    /*
        Assignment Posted Event.
        @param assignment_Date, Date. The deadline for the assignment
     */
    public void assignmentPost(Date assignment_Date)
    {
        this.midtermDate = assignment_Date;
        CourseEvent event = new CourseEvent(this);
        event.setAssignmentDeadline(assignment_Date);

        for(CourseListener cl: courseListeners)
        {
            cl.assignmentPosted(event);
        }

    }

    public synchronized void addListner(CourseListener c_New)
    {
        courseListeners.add(c_New);
    }

    public synchronized void removeListner(CourseListener c_Remove)
    {
        courseListeners.remove(c_Remove);
    }






    public static void main(String[] args)
    {
        Prof p = new Prof("Babak");
        Student s = new Student("Homer");
        Student s2 = new Student("Bart");
        TeachingAssistant ta = new TeachingAssistant("Michael");


        p.addListner(s);
        p.addListner(s2);
        p.addListner(ta);

        Date midterm = new Date();
        p.setMidterm(midterm);
        System.out.println("-------------------------------------------------");
        p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
        System.out.println("-------------------------------------------------");
        p.assignmentPost(new Date(midterm.getTime() + 2000000000));


    }

}
