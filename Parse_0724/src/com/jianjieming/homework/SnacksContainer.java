package com.jianjieming.homework;

public abstract class SnacksContainer {

    public static class SnacksCell {
        private Snacks snacks;
        private int number;

        public SnacksCell() {
        }

        public Snacks getSnacks() {
            return snacks;
        }

        public void setSnacks(Snacks snacks) {
            this.snacks = snacks;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
