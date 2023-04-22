package HW2.Zadanie22;

import org.openqa.selenium.WebElement;

public class ExepensMethod {
    public static void exmethod (WebElement element1, WebElement element2){
        //Плащадь
        int S1,S2;
        S1 = element1.getSize().height*element1.getSize().width;
        S2 = element2.getSize().height*element2.getSize().width;
        if (S1>S2){
            System.out.println("Площадь S1 больше = " +S1);
        }
        else {
            System.out.println("Площадь S2 больше = " +S2);
        }
        //какой из элементов располагается левее на странице
        if (element1.getLocation().getX()<element2.getLocation().getX()){
            System.out.println("Левее на странице элемент 1 "+element1.getLocation().getX());
        } else if (element1.getLocation().getX()>element2.getLocation().getY()){
            System.out.println("Левее на странице элемент 2 "+element2.getLocation());
        } else System.out.println("Одиноковы");

        //Какой из двух элементов располагается  выше на странице
        if (element1.getLocation().getY()<element2.getLocation().getY()){
            System.out.println("Выше на странцие элемент 1 "+element1.getLocation());
        } else if (element1.getLocation().getY()>element2.getLocation().getY()) {
            System.out.println("Левее на странцие элемент 2"+element2.getLocation());
        }
    }}