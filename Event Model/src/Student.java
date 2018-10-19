/** Event Model
 * @author Muneeb Nasir
 * @version 1.1
 *
 */
import java.util.Date;
import java.util.EventObject;
import java.util.Observer;

public class Student implements CourseListener {
    private String name;
    private Date midterm;

    public Student(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    /*
       The method is linked with teh set Midterm & assignment Announcement
       @param date, Date. The Midterm Date
    */
    public void study(Date date){
        this.midterm = date;
        System.out.println(name + " : Doh! I have to study hard for my midterm/assignment on " + this.midterm);
    }

    /*
        The method is linked with teh Postpone Midterm Announcement
        @param date, Date. The new Midterm Date
     */
    public void party(Date date){
        this.midterm = date;
        System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
    }

    @Override
    public void midtermAnnounced(CourseEvent event)
    {
        this.study(event.getMidtermDate());
    }

    @Override
    public void midtermPostponed(CourseEvent event)
    {
        this.party(event.getMidtermDate());
    }

    @Override
    public void assignmentPosted(CourseEvent event)
    {
        this.study(event.getAssignmentDeadline());
    }
}
