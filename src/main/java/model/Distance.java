package model;

import java.util.List;

public class Distance {
    private int value;

    public Distance(int value) {
        this.value = value;
    }

    public void plus() {
        this.value++;
    }

    public void minus() {
        this.value--;
    }
}
