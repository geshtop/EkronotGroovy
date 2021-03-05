public class Shop {
    public Double totalSell =0.0;
    public Double totalBuy  =0.0;
    public ArrayList<Action> actions;

    Shop(){
        actions = new ArrayList<Action>();
    }

    def HandleCell (String product, Double price, Double amount) {
        def action = new Action(product, price, amount, false)
        this.totalSell += (price * amount)
        actions.add(action)
        return action.toString()
    }

    def String  HandleBuy (String product, Double price,  Double amount) {
        def action = new Action(product, price, amount, true)
        actions.add(action)
        this.totalBuy += (price * amount)
        return action.toString()
    }
}
