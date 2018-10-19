/** Event Model
 * @author Muneeb Nasir
 * @version 1.1
 *
 */
import java.util.EventObject;
import java.util.Date;

public class CourseEvent extends EventObject {

    private Date midtermDate;
    private Date assignmentDeadline;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CourseEvent(Object source) {
        super(source);
    }

    public Date getAssignmentDeadline() {
        return assignmentDeadline;
    }

    public void setAssignmentDeadline(Date assignmentDeadline) {
        this.assignmentDeadline = assignmentDeadline;
    }

    public Date getMidtermDate() {
        return midtermDate;
    }

    public void setMidtermDate(Date midtermDate) {
        this.midtermDate = midtermDate;
    }


}
