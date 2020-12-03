/**
 * Represents the multimedia controls of a product
 *
 * @author Shanaz Ramsaroop
 */
public interface MultimediaControl {
    /**
     * Displays "Playing" if the user presses play
     */
    public void play();

    /**
     * Displays "Stopping" if the user presses stop
     */
    public void stop();

    /**
     * Displays "Previous" if the user presses previous
     */
    public void previous();

    /**
     * Displays "Next" if the user presses next
     */
    public void next();
}