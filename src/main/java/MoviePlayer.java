/**
 * Represents a type of product, a movie player
 *
 * @author Shanaz Ramsaroop
 */
public class MoviePlayer extends Product implements MultimediaControl {
    /**
     * The screen of this movie player.
     */
    Screen screen;
    /**
     * The monitor type of this movie player.
     */
    MonitorType monitorType;
    //setting type to visual
    private static final ItemType type = ItemType.VISUAL;

    /**
     * Class constructor specifying the manufacturer, name, screen and monitor type
     * <p> of this movie player
     *
     * @param manufacturer this movie player's manufacturer
     *
     * @param monitorType this movie player's monitor type
     *
     * @param name this movie players' name
     *
     * @param screen this movie player's screen
     */
    public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer, type);
        this.screen = screen;
        this.monitorType = monitorType;
    }

    /**
     * Displays "Playing movie" if the user presses play on the movie player
     */
    @Override
    public void play() {
        System.out.println("Playing movie");
    }

    /**
     * Displays "Stopping movie" if the user presses stop on the movie player
     */
    @Override
    public void stop() {
        System.out.println("Stopping movie");
    }

    /**
     * Displays "Previous movie" if the user presses previous on the movie player
     */
    @Override
    public void previous() {
        System.out.println("Previous movie");
    }

    /**
     * Displays "Next movie" if the user presses next on the movie player
     */
    @Override
    public void next() {
        System.out.println("Next movie");
    }

    /**
     * Displays the movie player's monitor type and screen type
     *
     * @return a string containing the movie player's monitor type and screen type
     */
    public String toString() {
        System.out.print(super.toString());
        return (screen.toString() + "\nMonitor Type: " + monitorType.toString());
    }

}

