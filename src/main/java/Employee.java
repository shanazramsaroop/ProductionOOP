/**
 * Represents an employee that entered a production record
 *
 * @author Shanaz Ramsaroop
 */
public class Employee {

    /**
     * The name of this employee.
     */
    StringBuilder name;
    /**
     * The username of this employee.
     */
    String username;
    /**
     * The password of this employee.
     */
    String password;
    /**
     * The email address of this employee.
     */
    String email;

    /**
     * Class constructor specifying the employee's name and password
     */
    Employee(String name, String password) {
        //this.name = name;
        if (!checkName(name)) {
            setUsername(name);
            setEmail(name);
        } else {
            this.username = "default";
            this.email = "user@oracleacademy.Test";
        }
        if (isValidPassword(password)) //if password is valid
            this.password = password;
        else
            this.password = "pw";

        reverseString(password);
    }

    /**
     * Sets the username field to the first initial of the first name and then the last name of this production record.
     *
     * @param name This Production record's production number.
     */
    private void setUsername(String name) {
        char c = ' ';
        String username = "";
        name.toLowerCase();

        int endOfFirst = 0;
        int length = name.length();
        for (int i = 0; i < length; i++) {
            if (name.charAt(i) == c) {
                endOfFirst = i + 1;
            }
        }
        username += name.charAt(0);
        for (int i = endOfFirst; i < length; i++)
            username += name.charAt(i);
        this.username = username.toLowerCase();
    }

    /**
     * Checks if the name contains a space.
     *
     * @param name This Production record's production number.
     *
     * @return if the name contains a space
     */
    public boolean checkName(String name) {
        char c = ' ';
        boolean noSpace = true;
        int i = 0;
        int length = name.length();
        for (noSpace = true; i < length; i++) {
            if (name.charAt(i) == c) {
                noSpace = false;
            }
        }
        return noSpace;
    }

    /**
     * Sets the email field to the first name, then a period, then the last name followed by @oracleacademy.Test
     *
     * @param name This Production record's production number.
     */
    private void setEmail(String name) {
        char c = ' ';
        int i;
        String email = "";
        name.toLowerCase();
        int length = name.length();
        for (i = 0; i < length; i++) {
            if (name.charAt(i) == c)
                email = email + ".";
            else
                email = email + name.charAt(i);
        }
        email = email.toLowerCase() + "@oracleacademy.Test";
        this.email = email;
    }

    /**
     * Checks to see if the password contains a lowercase letter, uppercase letter, and a special character
     *
     * @param password This Production record's production number.
     */
    private boolean isValidPassword(String password) {
        boolean hasLower = false, hasUpper = false, hasSpecialChar = false;
        int i;
        int length = password.length();
        for (i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch))
                hasUpper = true;
            else if (Character.isLowerCase(ch))
                hasLower = true;
            else if (ch == '"' || ch == '!' || ch == '@' || ch == '&' || ch == '$' || ch == '#' || ch == '%' || ch == '^' || ch == '*')
                hasSpecialChar = true;

        }
        if (hasLower == true && hasUpper == true && hasSpecialChar == true)
            return true;
        else
            return false;
    }

    /**
     * Displays the employee details, such as their name, username, email and password
     *
     * @return a string containing the product number, name, serial number and production date
     */
    public String toString() {
        return "\nEmployee Details\nName:" + this.name + "\nUsername:" + this.username + "\nEmail:" + this.email +
                "\nInitial Password:" + this.password;
    }

    /**
     * reverses the order of the text stored for the database password.
     *
     * @param pw the password of this employee
     *
     * @return the reversed password
     */
    public String reverseString(String pw) {

        if(pw.isEmpty()){
            return pw;
        }

        else{
            return reverseString(pw.substring(1))+pw.charAt(0);
        }

    }

}
