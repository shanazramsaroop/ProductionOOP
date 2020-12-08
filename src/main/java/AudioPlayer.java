import java.util.ArrayList;

/**
 * Represents a type of product, an audio player
 *
 * @author Shanaz Ramsaroop
 */
public class AudioPlayer extends Product implements MultimediaControl {

  /**
   * The supported audio formats of this audio player.
   */
  String supportedAudioFormats;
  /**
   * The supported playlist formats of this audio player.
   */
  String supportedPlaylistFormats;
  //setting type to audio
  private static final ItemType type = ItemType.AUDIO;

  /**
   * Class constructor specifying the manufacturer, name, supportedAudioFormats and
   * supportedPlaylistFormats
   * <p> of this audio player
   *
   * @param manufacturer             This audio player's manufacturer
   * @param name                     This audio player's name.
   * @param supportedAudioFormats    This audio player's supported audio format.
   * @param supportedPlaylistFormats This audio player's supported playlist formats.
   */
  public AudioPlayer(String manufacturer, String name, String supportedAudioFormats,
      String supportedPlaylistFormats) {

    super(manufacturer, name, type);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
    testMultimedia();
  }

  /**
   * Displays "Playing" if the user presses play on the audio player
   */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  /**
   * Displays "Stoppping" if the user presses stop on the audio player
   */
  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * Displays "Previous" if the user presses previous on the audio player
   */
  @Override
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * Displays "Next" if the user presses next on the audio player
   */
  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * Displays the audio player's supported audio formats and supported playlist formats
   *
   * @return a string containing the audio player's supported audio formats and supported playlist
   * formats
   */
  public String toString() {
    System.out.print(super.toString());
    return ("\nSupported Audio Formats: " + this.supportedAudioFormats
        + " \nSupported Playlist Formats: "
        + this.supportedPlaylistFormats);
  }

  /**
   * Adds an audio player and a movie player to an array list named productList of type
   * MultimediaControl
   */
  public static void testMultimedia() {

    //create a new instance of audio player
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");

    //create a new instance of a screen
    Screen newScreen = new Screen("720x480", 40, 22);

    //create a new instance of a movie player
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,

        MonitorType.LCD);

    //create an arraylist of type MultimediaControl
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();

    //add the new audio player to productList
    productList.add(newAudioProduct);

    //add the new movie player to productList
    productList.add(newMovieProduct);

    //for loop for iterating through the productList
    for (MultimediaControl p : productList) {

      System.out.println(p);

      p.play();

      p.stop();

      p.next();

      p.previous();

    }

  }
}