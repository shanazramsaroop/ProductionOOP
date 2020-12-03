/**
 * Represents item types that can be used
 *
 * @author Shanaz Ramsaroop
 */
public enum ItemType {
    /**
     * audio type
     */
    AUDIO("AU"),
    /**
     * visual type
     */
    VISUAL("VI"),
    /**
     * audio mobile type
     */
    AUDIO_MOBILE("AM"),
    /**
     * visual mobile type
     */
    VISUAL_MOBILE("VM");
    /**
     * abbreviation given to each item type
     */
    public String code;

    /**
     * Enum constructor specifying the code of this item type
     */
    ItemType(String code) {
        this.code = code;
    }
}