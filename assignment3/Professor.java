public class Professor {
    //required parameters, each Professor has firstName, lastName and an id variable
    private String firstName;
    private String lastName;
    private int id;

    //optional parameters
    private int age;
    private String phone;
    private String address;
    private String email;

    public Professor(String firstName, String lastName, int id, int age, String phone, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Id:" + id + ", Name:" + firstName + " " + lastName);
        if (age > 0) {
            sb.append(", Age:" + age);
        }
        if (phone != null) {
            sb.append(", Phone:" + phone);
        }
        if (email != null) {
            sb.append(", Email:" + email);
        }
        if (address != null) {
            sb.append(", Address:" + address);
        }
        return sb.toString();
    }

    public static class Builder{
        //required parameters, each Professor has firstName, lastName and an id variable
        private String firstName;
        private String lastName;
        private int id;

        //optional parameters
        private int age;
        private String phone;
        private String address;
        private String email;

        public Builder(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        /* pay attention, the return type is Builder, because a Builder
        * could call the Build method. "return this" means return a
        * Builder type object */
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        /* call the Professor's constructor. it doesn't matter if we do not add optional
        * parameters, they would be given default values */
        public Professor Build() {
            return new Professor(firstName, lastName, id,  age, phone, address, email);
        }
    }
}
