/**
 * Represents a product that the user enters.
 *
 * @author Shanaz Ramsaroop
 */
public class Product implements Item {
    /**
     * The id of this product.
     */
    int id;
    /**
     * The item type of this product.
     */
    ItemType type;
    /**
     * The manufacturer of this product.
     */
    String manufacturer;
    /**
     * The name of this product.
     */
    String name;

    /**
     * Class constructor specifying the name, manufacturer and type of this product.
     */
    Product(String name, String manufacturer, ItemType type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    /**
     * Displays the product name, manufacturer and type.
     *
     * @return a string containing the name, manufacturer and type of the product.
     */
    public String toString() {
        return ("Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type);
    }

    /**
     * Sets the id of this Product.
     *
     * @param id This Product's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the type of this Product.
     *
     * @param type This Product's type.
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * Sets the name of this Product.
     *
     * @param name This Product's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the manufacturer of this Product.
     *
     * @param manufacturer This Product's new id.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the id type of this Product.
     *
     * @return this Product's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the item type of this Product.
     *
     * @return this Product's item type.
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Gets the first and last name of this Student.
     *
     * @return this Student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the manufacturer of this Product.
     *
     * @return this Product's manufacturer.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    class Widget extends Product {
        Widget(String name, String manufacturer, ItemType type) {
            super(name, manufacturer, type);
        }
    }

}
