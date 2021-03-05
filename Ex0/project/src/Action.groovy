public class Action {
   public  String product
    public Double price,  amount
    public Boolean buy

    Action(String product, Double price, Double amount, Boolean buy) {
        this.product = product
        this.price = price
        this.amount = amount
        this.buy = buy
    }

    @Override
    String toString() {
        //, System.lineSeparator, (price*amount).round(2).toString(), System.lineSeparator
        return this.buy?
                String.format("### BUY %s ### %n%.2f%n", this.product, (price*amount).round(2) )
                :  String.format("\$\$\$ CELL  %s \$\$\$ %n%.2f%n" , this.product,  (price*amount).round(2))
    }
}
