/**
 * Represents a screen
 *
 * @author Shanaz Ramsaroop
 */
public class Screen implements ScreenSpec {
    /**
     * The resolution of this screen.
     */
    private final String resolution;
    /**
     * The refresh rate of this screen.
     */
    private final int refreshRate;
    /**
     * The response time of this screen.
     */
    private final int responseTime;

    /**
     * Class constructor specifying the resolution, refresh rate, and response time of this screen
     *
     * @param rate the refresh rate of this screen
     *
     * @param resolution the resolution of this screen
     *
     * @param time the respose time of this screen
     */
    public Screen(String resolution, int rate, int time) {
        this.resolution = resolution;
        this.refreshRate = rate;
        this.responseTime = time;
    }

    /**
     * Gets the resolution of this Screen.
     *
     * @return this Screen's resolution.
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Gets the refresh rate of this Screen.
     *
     * @return this Screen's refresh rate.
     */
    public int getRefreshRate() {
        return refreshRate;
    }

    /**
     * Gets the response time of this Screen.
     *
     * @return this Screen's response time.
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * Displays the screen's resolution, refresh rate, and response time
     *
     * @return a string containing the screen's resolution, refresh rate, and response time
     */
    public String toString() {

        return ("Screen:" + "\nResolution: " + resolution + "\nRefresh rate: "
                + refreshRate + "\nResponse time: " + responseTime);
    }
}