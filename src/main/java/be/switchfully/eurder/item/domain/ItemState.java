package be.switchfully.eurder.item.domain;

public enum ItemState {
    PRISTINE("Pristine", 0),
    SLIGHTLY_DAMAGED("Slightly damaged", 0.05),
    DAMAGED("Damaged", 0.1);

    private final String itemState;
    private final double discount;

    ItemState(String itemState, double discount) {
        this.itemState = itemState;
        this.discount = discount;
    }

    public String getItemState() {
        return itemState;
    }

    public double getDiscount() {
        return discount;
    }
}
