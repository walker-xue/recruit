package com.ncs.recruit.infrastructure.enums;

public enum EnumState {

    // 数据库状态

    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8);

    private int index;

    private EnumState(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
