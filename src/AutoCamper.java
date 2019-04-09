public abstract class  AutoCamper {
    boolean isAvalible;
    String description;
    boolean tankIsfull;
    int autoCamperNo;


    public AutoCamper() {
        this.isAvalible = true;
        this.description = "Auto";
        this.tankIsfull = true;
        autoCamperNo = 0; //TODO SP Hvor man finder MaxId no og indsætter her.
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
    }

    public void setTankIsfull(boolean tankIsfull) {
        this.tankIsfull = tankIsfull;
    }

    public void setAutoCamperNo(int autoCamperNo) {
        this.autoCamperNo = autoCamperNo;
    }

    @Override
    public String toString() {
        return "AutoCamper{" +
                "isAvalible=" + isAvalible +
                ", description='" + description + '\'' +
                ", tankIsfull=" + tankIsfull +
                ", autoCamperNo=" + autoCamperNo +
                '}';
    }


    //public AutoCamper();
}
