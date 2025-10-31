package com.example.myproject;

public class Poodle extends Dog{
    public void Bark(){
        System.out.println("왈왈");
    }

    public static void main(String[] args){
        Dog dog = new Dog();

        Poodle pd = new Poodle();
        pd.Bark();

        dog = new Poodle();
        dog.Bark();
    }
}
