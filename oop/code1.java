package oop;

public class code1 {
    public static void main (String args[]){
        Pen p1= new Pen();
        p1.SetColor("blue");
        p1.SetTip(5);
            System.out.println(p1.color);
            System.out.println(p1.tip); 
                
    }
}

class Pen {
    String color;
    int tip;

    void SetColor(String newColor){
        color = newColor;
    }
    void SetTip(int newTip){
        tip = newTip;
    }
}
