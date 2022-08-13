package com.example.dicegame;

public class Dice {
        private int sides;
        private String name;

        public Dice(int sides, String name){
            this.sides = sides;
            this.name = name;
        }

        public int roll() {
            return (int) Math.round(Math.random() * sides);
        }
        // Getters
        public int getSides() {
            return this.sides;
        }

        public String getName() {
            return name;
        }

        public void getSides(int sides) {
            this.sides = sides;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setSides(int sides) {
            this.sides = sides;
        }

}
