/** SYSC 3101 Event Model
 * @author Muneeb Nasir
 * @version 1.1
 *
 */
import java.util.Date;
import java.util.Observer;

public class TeachingAssistant  implements CourseListener {
    private String name;
    private Date midterm;

    public TeachingAssistant(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    /*
        The method is linked with teh set Midterm Announcement
        @param date, Date. The Midterm Date
     */
    public void proctor(Date date){
        this.midterm = date;
        System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
    }

    /*
        The method is linked with teh Postpone Midterm Announcement
        @param date, Date. The new Midterm Date
     */
    public void postpone(Date date){
        this.midterm = date;
        System.out.println(name + " : Now the midterm is on " + this.midterm);
    }

    /*
        This method was added by me to link with the assignment date.
        The method is linked with the Assignment Posted Announcement.
        @param assignment_Date, Date. The deadline for the assignment
     */
    public void mark(Date date){
        this.midterm = date;
        System.out.println(name + " : The posted assignment marking begins after " + this.midterm);
    }

    @Override
    public void midtermAnnounced(CourseEvent event)
    {
        this.proctor(event.getMidtermDate());
    }

    @Override
    public void midtermPostponed(CourseEvent event)
    {
        this.postpone(event.getMidtermDate());
    }


    @Override
    public void assignmentPosted(CourseEvent event)
    {
        this.mark(event.getAssignmentDeadline());
    }


}
