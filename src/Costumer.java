public class Costumer {
    String userName;
    String firstName;
    String lastName;
    String driverlicencenNo;
    String password;
    int timesReserved;
    String email;
    String adress;
    String city;
    String zipcode;
    double currentdept;
    boolean depositpaid;
    int costumerId;

    public Costumer(String userName, String firstName, String lastName, String driverlicencenNo, String password, String email, String adress, String city, String zipcode, int costumerId) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverlicencenNo = driverlicencenNo;
        this.password = password;
        this.timesReserved = 0;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.zipcode = zipcode;
        this.currentdept = 0;
        this.depositpaid = false;
        this.costumerId = costumerId; //TODO find max in SQL
        //TODO insert into DB
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDriverlicencenNo() {
        return driverlicencenNo;
    }

    public void setDriverlicencenNo(String driverlicencenNo) {
        this.driverlicencenNo = driverlicencenNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimesReserved() {
        return timesReserved;
    }

    public void setTimesReserved(int timesReserved) {
        this.timesReserved = timesReserved;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getCurrentdept() {
        return currentdept;
    }

    public void setCurrentdept(double currentdept) {
        this.currentdept = currentdept;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public int getCostumerId() {
        return costumerId;
    }
}
