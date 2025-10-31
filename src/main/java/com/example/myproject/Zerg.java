package com.example.myproject;

public class Zerg {
    public void Overload(int zerggling)
    {
        System.out.println("저글링 " + zerggling + "마리");
    }
    public void Overload(int zerggling, int hydra)
    {
        System.out.println("저글링 " + zerggling + "마리" + "히드라 " + hydra + "마리");
    }
    public void Overload(int zerggling, int hydra, int lurker)
    {
        System.out.println("저글링 " + zerggling + "마리" + "히드라 " + hydra + "마리" + "럴커 " + lurker + "마리");
    }
    public void Overload(char zerggling)
    {
        System.out.println("저글링 " + zerggling + "등급");
    }

    public static void main(String[] args){
        Zerg zerg = new Zerg();
        zerg.Overload(10);
        zerg.Overload(10,20);
        zerg.Overload(10,20,30);
        zerg.Overload('A');
    }

}
