import java.sql.*;
public abstract class  AutoCamper {
    boolean isAvalible;
    String description;
    boolean tankIsfull;
    int autoCamperNo;
    String photoPath;
    double price;


    public AutoCamper() {
        this.isAvalible = true;
        this.description = "Auto";
        this.tankIsfull = true;
        autoCamperNo = 0; //TODO SP Hvor man finder MaxId no og indsætter her.
    }


    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public boolean isAvalible() {
        return isAvalible;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTankIsfull() {
        return tankIsfull;
    }

    public int getAutoCamperNo() {
        return autoCamperNo;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }

    public void setDescription(String description) {

        this.description = description;
        int id = this.autoCamperNo;
        //updateDescrip(description,""+id );
    }

    public void setTankIsfull(boolean tankIsfull) {
        this.tankIsfull = tankIsfull;
    }

    public void setAutoCamperNo(int autoCamperNo) {
        this.autoCamperNo = autoCamperNo;
    }

    public String getPhotoPath() {
        return photoPath;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AutoCamper{" +
                "isAvalible=" + isAvalible +
                ", description='" + description + '\'' +
                ", tankIsfull=" + tankIsfull +
                ", autoCamperNo=" + autoCamperNo +
                ", photoPath='" + photoPath + '\'' +
                ", price=" + price +
                '}';
    }
    public void updateDescrip(String Description, String Id)
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con =
                    DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbAutocamper", "sa", "password");
            PreparedStatement ps = con.prepareStatement("EXECUTE dbo.updateDescription @description = ?, @Id = ? ");
            ps.setString(1, Description);
            ps.setString(2, Id );

        } catch (Exception e) {
            e.printStackTrace();
        }


        //public AutoCamper();
    }

    public int addAutoCamper(String Price, String Description, String Type)
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con =
                    DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbAutocamper", "sa", "password");
                            PreparedStatement ps = con.prepareStatement("EXECUTE dbo.addAutoCamper @price = ?, @Description = ?, @type = ?");
            ps.setString(1, Price);
            ps.setString(2, Description);
            ps.setString(3,Type);

            ResultSet rs = ps.executeQuery();
            int Id = rs.getInt(1);

            return Id;
        } catch (Exception e) {
            e.printStackTrace();
        } return 0;


    //public AutoCamper();
}
}
