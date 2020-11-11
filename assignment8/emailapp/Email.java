package emailapp;

import java.util.Scanner;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    private String firstName;
    private String lastName;
    private String departmet;
    private StringBuilder employeeEmail;
    private String alternateEmail;

    private String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    private int passwordSetNumber = passwordSet.length();
    private String password;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.print("New Worker: " + firstName + " " + lastName +". ");

        // complete new employee's information
        this.departmet = SetDepartment();
        this.password = randomPassword(defaultPasswordLength);

        // the following code is creating email
        employeeEmail = new StringBuilder(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@");
        // if the employee has a department, email address should include it
        if (!this.departmet.equals("")) {
            employeeEmail.append(this.departmet + ".");
        }
        // append company suffix
        employeeEmail.append(companySuffix);
    }

    // Ask for the department
    private String SetDepartment() {
        String dep = "";

        // hint information.
        System.out.println( "Department Codes:"
                + "\n1 for Sales"
                + "\n2 for Development"
                + "\n3 for Accounting"
                + "\n0 for none"
                + "\nEnter department code: ");

        // read the department code.
        Scanner sc = new Scanner(System.in);
        int departmentCode = sc.nextInt();

        // determine the department according the input department code.
        switch (departmentCode) {
            case 1:
                dep = "sal";
                break;
            case 2:
                dep = "dev";
                break;
            case 3:
                dep = "acc";
                break;
            case 0:
                break;
            default:
                // if the code is not valid.
                System.out.println("Please enter a correct department code.");
                return SetDepartment();
        }

        return dep;
    }

    // Generate a random password
    private String randomPassword(int length) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; ++i) {
            int randomIndex = (int) (Math.random() * passwordSetNumber);
            sb.append(passwordSet.charAt(randomIndex));
        }
        return sb.toString();
    }

    // Have set methods to change the password
    public void setPassword() {
        System.out.println("Please enter your current password:");
        Scanner sc = new Scanner(System.in);

        // wrongCount is used to count the times a person inputs
        // a wrong password.
        int wrongCount = 0;
        SET_PASSWORD:
            // if a person tries 5 times but the password are all wrong,
            // he/she has to wait until the next day to change the password.
            while (wrongCount < 5) {
                String inputPassword = sc.nextLine();
                // if the password the person input is correct,
                // then he/she is able to set a new one.
                if (inputPassword.equals(password)) {
                    while (true) {
                        System.out.println("Please enter your new password:");
                        String newPassword1 = sc.nextLine();
                        System.out.println("Please enter your new password again:");
                        String newPassword2 = sc.nextLine();
                        // check, the new password, because sometimes people
                        // may set a wrong password accidentally. For instance,
                        // when I am setting my password, I may unintentionally
                        // press twice on one keyboard, so the password is not
                        // the one I want. However, if we have double check,
                        // such things will not happen.
                        if (newPassword1.equals(newPassword2)) {
                            password = newPassword1;
                            System.out.println("You have successfully change your password.");
                            // pay attention!!!, if I just use "break;", I just jump out
                            // the inner loop, but could not jump out the outer loop. So I
                            // use while with label.
                            break SET_PASSWORD;
                        } else {
                            System.out.println("The two input passwords must be consistent.");
                        }
                    }
                } else {
                    // the password is not correct, the person has to try again.
                    wrongCount += 1;
                    if (wrongCount < 5) {
                        // hint, today's remaining times.
                        System.out.println("The password you input is wrong. You can try "
                                + (5 - wrongCount) + " more times today:");
                    }
                    else {
                        System.out.println("Please change your password tomorrow.");
                    }
                }
            }
    }

    // Have set methods to set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Have set methods to define an alternate email address
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder("");
        sb.append("DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n");
        sb.append("DEPARTMENT: " + this.departmet + "\n");
        sb.append("COMPANY EMAIL: " + this.employeeEmail + "\n");
        if (this.alternateEmail != null) {
            sb.append("ALTERNATE EMAIL: " + this.alternateEmail + "\n");
        }
        sb.append("PASSWORD: " + this.password + "\n");
        sb.append("MAILBOX CAPACITY: " + this.mailboxCapacity + "mb\n");
        return sb.toString();
    }
}
