package com.example.myproject;

public class Dog{
    protected int eyes, nose, mouth, ears;
//    protected String kinds;

    public Dog(){
        eyes = 0;
        nose = 0;
        mouth = 0;
        ears = 0;
    }
    public Dog(int eyes, int nose){
        this.eyes = eyes;
        this.nose = nose;
        mouth = 0;
        ears = 0;
    }

    public void Bark(){
        System.out.println("멍멍");
    }
}