public class Luxury extends AutoCamper {

    private double tankSize;
    Luxury() {
        super();
        super.price = 500; //TODO Find  ud af hvilken Standard
        this.tankSize = 150; //TODO Find ud af hvilken Standard
        //TODO Insert into DB
    }

    @Override
    public boolean isAvalible() {
        return super.isAvalible();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public boolean isTankIsfull() {
        return super.isTankIsfull();
    }

    @Override
    public int getAutoCamperNo() {
        return super.getAutoCamperNo();
    }

    @Override
    public void setAvalible(boolean avalible) {
        super.setAvalible(avalible);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setTankIsfull(boolean tankIsfull) {
        super.setTankIsfull(tankIsfull);
    }

    @Override
    public void setAutoCamperNo(int autoCamperNo) {
        super.setAutoCamperNo(autoCamperNo);
    }

    public double getPrice() {
        return price;
    }

    public double getTankSize() {
        return tankSize;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTankSize(double tankSize) {
        this.tankSize = tankSize;
    }

    @Override
    public String toString() {
        return "\nLuxury{" +
                "price=" + price +
                ", tankSize=" + tankSize +
                ", isAvalible=" + isAvalible +
                ", description='" + description + '\'' +
                ", tankIsfull=" + tankIsfull +
                ", autoCamperNo=" + autoCamperNo +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
