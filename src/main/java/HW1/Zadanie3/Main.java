package HW1.Zadanie3;

public class Main {
    public static void main (String[] args){
     Tree tree1= new Tree();
     tree1.getInfo();
     System.out.println("===========");

     Tree tree2= new Tree("Дуб");
     tree2.getInfo();
     System.out.println("===========");

     Tree tree3= new Tree("Ель", 230);
     tree3.getInfo();
     System.out.println("===========");

     Tree tree4= new Tree(40, 453,"Красный");
     tree4.getInfo();

    }
}
