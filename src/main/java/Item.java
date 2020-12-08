/**
 * Represents an item that the user enters
 *
 * @author Shanaz Ramsaroop
 */
public interface Item {

  /**
   * Sets the product id of this item.
   *
   * @param id This item's id.
   */
  public void setId(int id);

  /**
   * Sets the manufacturer of this item.
   *
   * @param manufacturer This item's manufacturer.
   */
  public void setManufacturer(String manufacturer);

  /**
   * Sets the name of this item.
   *
   * @param name This item's name.
   */
  public void setName(String name);

  /**
   * Gets the product id of this item.
   *
   * @return this item's product id.
   */
  public int getId();

  /**
   * Gets the name of this item.
   *
   * @return this item's name.
   */
  public String getName();

  /**
   * Gets the manufacturer of this item.
   *
   * @return this item's manufacturer.
   */
  public String getManufacturer();

}