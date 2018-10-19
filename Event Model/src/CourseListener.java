/** Event Model CourseListener Interface
 * @author Muneeb Nasir
 * @version 1.1
 *
 */
import java.util.EventListener;
import java.util.EventObject;

public interface CourseListener
{
    void midtermAnnounced(CourseEvent e);

    void midtermPostponed(CourseEvent e);

    void assignmentPosted(CourseEvent e);
}
