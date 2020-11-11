package emailapp;

public class EmailApp {

    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        System.out.println(em1.showInfo());
/*
* console output:
New Worker: John Smith. Department Codes:
1 for Sales
2 for Development
3 for Accounting
0 for none
Enter department code:
2
DISPLAY NAME: John Smith
DEPARTMENT: dev
COMPANY EMAIL: john.smith@dev.aeycompany.com
PASSWORD: SDUQ0YSKO5
MAILBOX CAPACITY: 500mb
* */

        /*
         * the following is used to show the usage of
         * changing the password, setting the mailbox
         * capacity, and defining an alternate email address.
         * */
//        // show the usage of setPassword().
//        em1.setPassword();
//        System.out.println(em1.showInfo());
//        // show the usage of setAlternateEmail().
//        em1.setAlternateEmail("xxx@northeastern.edu");
//        System.out.println(em1.showInfo());
//        // show the usage of setMailboxCapacity().
//        em1.setMailboxCapacity(10);
//        System.out.println(em1.showInfo());
    }
}
