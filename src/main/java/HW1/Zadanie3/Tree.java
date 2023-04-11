package HW1.Zadanie3;
//Создать класс Tree с перегруженными конструкторами.
//   В классе есть Tree есть поля:
//   String type; int height, int coutOfsticks, String colour;
//
//   Конструктор1 принимающий в параметры String type; int height
//   и присваивающий значение полям coutOfsticks значение 13,
//   colour "Зеленый".
//
//   Конструктор2 принимающий в параметры int height, int coutOfsticks,
//   String colour и присваивающий значение полю type "пихта".
//
//   Констуктор по умолчанию 3, который присваивает height = 350, coutOfsticks = 29,
//   сolour = "Желтый".
//
//   Конструктор4 который принимает в параметры String type,
//   и вызывает внутри себя конструктор 3.
//
//   Создать в отдельном классе main 4 объекта класса Tree используя 4 созданных конструктора.

    public class Tree {
        String type; // тип дерева
        int height; // высота дерева
        int countOfSticks; // количество веток
        String colour; // цвет дерева

        // Конструктор 1, принимающий в параметры тип дерева и его высоту
        // и устанавливающий количество веток в 13 и цвет зеленым
        public Tree(String type, int height) {
            this.type = type;
            this.height = height;
            this.countOfSticks = 13;
            this.colour = "Зеленый";
        }

        // Конструктор 2, принимающий в параметры высоту дерева, количество веток и цвет
        // и устанавливающий тип дерева как "Пихта"
        public Tree(int height, int countOfSticks, String colour) {
            this.type = "Пихта";
            this.height = height;
            this.countOfSticks = countOfSticks;
            this.colour = colour;
        }

        // Конструктор по умолчанию, устанавливающий значения по умолчанию для полей класса
        public Tree() {
            this.height = 350;
            this.countOfSticks = 29;
            this.colour = "Желтый";
        }

        // Конструктор 4, принимающий тип дерева и вызывающий конструктор по умолчанию
        public Tree(String type) {
            this();
            this.type = type;
        }

        public void getInfo() {
            System.out.println(type);
            System.out.println(countOfSticks);
            System.out.println(colour);
            System.out.println(height);
        }


    }

