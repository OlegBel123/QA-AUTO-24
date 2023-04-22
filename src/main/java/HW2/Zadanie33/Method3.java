package HW2.Zadanie33;

import org.openqa.selenium.WebElement;

//3)
//Написать метод который выводит сообщение об айди элемента,
//значении тэга элемента, значении класса элемента,
//значении атрибута name элемента, текста данного элемента,
//а также о координатах центра контейнера данного элемента.
//Создать свой тип исключений, который будет вызываться если у элемента
//нет определенного атрибута и на экран будет выводиться сообщение об отсутствии данного атрибута.
public class Method3 {
    public static void methodZero(WebElement element) throws ZeroValClass,  ZeroValGetText, ZeroValTagName,
            ZeroValID, ZeroValName {
        int centerW=element.getSize().width/2;
        int centerH=element.getSize().height/2;
        System.out.println("Координаты центра контейнера " + centerW+" : "+centerH);
        try {
            if (element.getAttribute("id") == null) {
                throw new ZeroValID();
            }else
                System.out.println("Id элемента: " + element.getAttribute("id"));
            if (element.getTagName() == null) {
                throw new ZeroValTagName();
            }else
                System.out.println("Значение тэга элемента: " + element.getTagName());
            if (element.getAttribute("class") == null) {
                throw new ZeroValClass();
            }else
                System.out.println("Значение класса элемента: " + element.getAttribute("class"));
            if (element.getAttribute("name") == null) {
                throw new ZeroValName();
            }else
                System.out.println("Значение атрибута name элемента: " + element.getAttribute("name"));
            if (element.getText() == null) {
                throw new ZeroValGetText();
            }else
                System.out.println("Текст данного элемента: " + element.getText());
        }
            catch (ZeroValID a) {
                System.out.println(a.getMEssege());
            } catch (ZeroValTagName a) {
                System.out.println(a.getMEssege());
            } catch (ZeroValClass a) {
                System.out.println(a.getMEssege());
            } catch (ZeroValName a) {
                System.out.println(a.getMEssege());
            } catch (ZeroValGetText a) {
                System.out.println(a.getMEssege());
            }

        }
    }
