import java.util.Date;

/**
 * Represents production records that the user enters
 *
 * @author Shanaz Ramsaroop
 */
public class ProductionRecord {

  /**
   * The product number of this production record.
   */
  private int prodNum;
  /**
   * The product id of this production record.
   */
  private int prodID;
  /**
   * The serial number of this production record.
   */
  private String serialNum;
  /**
   * The date the production record was produced.
   */
  Date dateProduced = new Date();

  /**
   * Class constructor specifying the product id of this production record
   */
  ProductionRecord(int prodID) {

    this.prodID = prodID;

    this.prodNum = 0;

    this.serialNum = " ";

    this.dateProduced = new Date();

  }

  /**
   * Class constructor specifying the product id, serial number and production date of this product
   */
  ProductionRecord(int prodNum, int prodID, String serialNum, Date dateProduced) {

    this.prodNum = prodNum;

    this.prodID = prodID;

    this.serialNum = serialNum;

    this.dateProduced = dateProduced;

  }

  /**
   * Class constructor specifying the product of this production record
   */
  ProductionRecord(Product product) {

    this.prodNum = getProductionNum();

    this.prodID = getProductID();

    this.dateProduced = new Date();

    this.serialNum =
        product.manufacturer.substring(0, 3) + product.type.code + String.format("%05d", 0);

  }

  /**
   * Displays the product number, name, serial number and production date
   *
   * @return a string containing the product number, name, serial number and production date
   */
  public String toString() {

    return "Prod. Num: " + prodNum + " Product Name: " + prodID + " Serial Num: " + serialNum
        + " Date: " + dateProduced;

  }

  /**
   * Sets the production number of this production record.
   *
   * @param prodNum This Production record's production number.
   */
  public void setProductionNum(int prodNum) {
    this.prodNum = prodNum;
  }

  /**
   * Sets the product id of this production record.
   *
   * @param prodID This Production record's product id.
   */
  public void setProductID(int prodID) {
    this.prodID = prodID;
  }

  /**
   * Sets the serial number of this production record.
   *
   * @param serialNum This Production record's serial number.
   */
  public void setSerialNum(String serialNum) {
    this.serialNum = serialNum;
  }

  /**
   * Sets the production date of this production record.
   *
   * @param dateProduced This Production record's production date.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * Gets the production number of this production record.
   *
   * @return this production record's production number.
   */
  public int getProductionNum() {
    return this.prodNum;
  }

  /**
   * Gets the product id of this production record.
   *
   * @return this production record's product id.
   */
  public int getProductID() {
    return this.prodID;
  }

  /**
   * Gets the serial number of this production record.
   *
   * @return this production record's serial number.
   */
  public String getSerialNum() {
    return this.serialNum;
  }

  /**
   * Gets the production date of this production record.
   *
   * @return this production record's production date.
   */
  public Date getProdDate() {
    return dateProduced;
  }

}