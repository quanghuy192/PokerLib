package vn.hn.quanghuy.model;

public enum ResultStatus {

    ADD, ADD_ALL, FOLLOW, DENY;

    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

}
