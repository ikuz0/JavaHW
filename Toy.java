public class Toy {
    private int id;
    private String toyName;
    private int remainder;
    private int dRate;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyname(String toyName) {
        this.toyName = toyName;
    }

    public int getAmountRemaining() {
        return remainder;
    }

    public void setAmountRemaining(int remainder) {
        this.remainder = remainder;
    }

    public int getDropRate() {
        return dRate;
    }

    public void setDropRate(int dRate) {
        this.dRate = dRate;
    }

    public Toy() {
    }

    public Toy(int id, String toyName, int remainder, int dRate) {
        this.id = id;
        this.toyName = toyName;
        this.remainder = remainder;
        this.dRate = dRate;
    }

    public void printToyInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Toy id: %d\nToy Name: %s\nThe remaining amount: %d\nChance of dropping: %d%%\n\n",
                this.getId(), this.getToyName(), this.getAmountRemaining(), this.getDropRate()));
        System.out.print(sb);
    }
}
