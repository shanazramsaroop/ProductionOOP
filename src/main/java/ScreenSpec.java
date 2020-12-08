/**
 * Represents the specifications of a product's screen
 *
 * @author Shanaz Ramsaroop
 */
public interface ScreenSpec {

  /**
   * Gets the resolution of this screen.
   *
   * @return this screen's resolution.
   */
  public String getResolution();

  /**
   * Gets the refresh rate of this screen.
   *
   * @return this screen's refresh rate.
   */
  public int getRefreshRate();

  /**
   * Gets the response time of this screen.
   *
   * @return this screen's response time.
   */
  public int getResponseTime();

}