package HW1.Zadanie2;

public class Main2 {
    public static void main(String[] args) {
        Class2.OverloadedMethodExample example = new Class2.OverloadedMethodExample();
        example.print();
        example.print("Добрый день!");
        example.print(new String[]{"Weekend", "is", "cool"});
        example.print(new int[]{1, 2, 3, 4, 5});
        example.print(42, "Я люблю гулять в лесу");
}
}
