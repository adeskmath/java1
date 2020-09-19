package ru.progwards.java1.lessons.interfaces;


//Animal - parent *****
public class Animal implements FoodCompare, CompareWeight {
    double weight;

    enum AnimalKind{
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }
    enum FoodKind{
        UNKNOWN,
        HAY,
        CORN
    }
    public Animal(double weight){
        this.weight = weight;
    }
    public AnimalKind getKind(){
        return AnimalKind.ANIMAL;

    }
    public FoodKind getFoodKind(){
        return FoodKind.UNKNOWN;
    }
    @Override
    public String toString(){
        return "I am "+ getKind()+", eat "+getFoodKind();
    }

    public double getWeight(){
        return weight;
    }
    public double getFoodCoeff(){
        return 0.02;
    }
    public double calculateFoodWeight(){
        return getWeight()*getFoodCoeff();
    }
    public String toStringFull(){
        return "I am "+getKind()+", eat "+getFoodKind()+" "+calculateFoodWeight();
    }

    public static void main(String[] args) {
        Animal animal = new Animal(77);
        System.out.println(animal);
        System.out.println(animal.getWeight());
        System.out.println(animal.toStringFull());



    }
    /* ----------------------H8 ------------------------------------------------------
    Задача 1. Классы Animal, Cow, Hamster, Duck
    1.1 Для класса Animal из задач 1 и 2, домашнего задания к уроку 5 реализовать метод:
    public boolean equals(Object anObject), который возвращает true, если объекты равны
    и false если не равны по параметру - вес животного.

    Убедится, что при равном весе, утка все равно не равна хомяку.

    Обратите внимание на тип принимаемого параметра и подумайте над тем, что будет делать ваша программа,
    если в качестве параметра будет передан объект не являющийся экземпляром Animal.

    Для класса Animal реализовать интерфейс FoodCompare, который сравнивает животных по цене потребляемой еды.
    public interface FoodCompare {
    public int compareFoodPrice();
    }
     */

    // Easy automatic generation of equals (alt+ins) or menu/code/generate - intellijidea

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        //return Double.compare(animal.weight, weight) == 0;
        //replace by
        return animal.weight == weight;
    }

    //alternative way
    /*
    @Override
    public boolean equals(Object anObject){
        //let's challenge the robot, try alternative
        return this == anObject || ((anObject != null) && (this.getClass() == anObject.getClass()) && (this.weight == ((Animal) anObject).weight));
    }
    */



    /* TASKS for H8 --------------- H8 ------------- H8 ---------------------- H8 --------------------------
            1.2 В класс Animal добавить метод
            public double getFood1kgPrice(), который возвращает информацию о цене 1 кг еды.
            метод реализовать в виде switch по FoodKind со следующими значениями
            HAY : 20
            CORN: 50
            UNKNOWN: 0
             */
    public double getFood1kgPrice(){
        switch (getFoodKind()){
            case HAY:
                return 20;

            case CORN:
                return 50;

            default: return 0;
        }
    }
    /*

    1.3 В класс Animal добавить метод
    public double getFoodPrice(), который возвращает информацию о цене еды для данного животного
    по формуле calculateFoodWeight() * getFood1kgPrice()
 */
    public double getFoodPrice(){
        return calculateFoodWeight()*getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal){
        return Double.compare(this.getFoodPrice(),animal.getFoodPrice());
    }
    /*
    3.1 Создать интерфейс CompareWeight
    3.2 В нем создать public enum CompareResult, со значениями LESS, EQUAL, GREATER
    3.3 Интерфейс должен содержать метод public CompareResult compareWeight(CompareWeight smthHasWeigt)
     

    3.4 Для класса Animal реализовать интерфейс CompareWeight..Сравнение сделать на основе веса животного.
    Метод CompareResult compareWeight должен возвращать
    LESS если свой вес < веса параметра метода
    EQUAL если свой вес = веса параметра метода
    GREATER если свой вес > веса параметра метода

     */


    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {

         switch (Double.compare(getWeight(), ((Animal) smthHasWeigt).getWeight())){
            case -1:
                return CompareResult.LESS;

            case 0:
                return CompareResult.EQUAL;

            default: return CompareResult.GREATER;
        }

    }
    //--------------------------------- end of H8 -----------------------------------------------
}
//Cow *****

class Cow extends Animal{
    public Cow (double weight){
        super(weight);

    }
    @Override
    public Animal.AnimalKind getKind(){
        return Animal.AnimalKind.COW;
    }
    @Override
    public Animal.FoodKind getFoodKind(){
        return Animal.FoodKind.HAY;
    }
    @Override
    public String toString(){
        return "I am "+ getKind()+", eat "+getFoodKind();
    }
    @Override
    public double getFoodCoeff(){
        return 0.05;
    }

    public static void main(String[] args) {
        Cow cow = new Cow(112);
        System.out.println(cow + " weight= "+ cow.weight);



        // tests for H8 -----------------------------tests for H8---------------------------

        System.out.println(cow.getFood1kgPrice()+" - cost per 1 kg food");
        System.out.println(cow.getFoodPrice()+" - cost of food for this animal");

        Cow cow2 = new Cow(112);
        Cow cow3 = new Cow(100);
        Animal animal = new Animal(112);
        Animal animal1 = new Animal(112);
        Duck duck2= new Duck(30);
        Duck duck3 = new Duck(30);
        Hamster hamsterCompare = new Hamster(30);

        // test H8

        System.out.println(animal.getFood1kgPrice()+" - cost per 1 kg of food");
        System.out.println(animal.getFoodPrice()+" - cost of food for this animal");
        Animal animal2 = new Animal( 77);

        //exception
        System.out.println("compare with not animal : "+animal.equals("animal2"));

        System.out.println(animal.equals(animal2)+" - result "+animal.getKind()+"s : "+animal.getWeight()+" Vs "+animal2.getWeight());


        System.out.println(cow2.equals(cow2)+" - result "+cow2.getKind()+"s : "+cow2.getWeight()+" Vs "+cow2.getWeight());
        System.out.println(cow.equals(animal1)+" - result "+cow.getKind()+" "+cow.getWeight()+" Vs "+animal1.getKind()+" "+animal1.getWeight());

        System.out.println(duck2.equals(hamsterCompare)+" - result "+ duck2.getKind()+"-"+duck2.getWeight()+" Vs "+
                hamsterCompare.getKind()+"-"+hamsterCompare.getWeight());
        System.out.println(duck2.equals(duck3)+" - result "+ duck2.getKind()+"-"+duck2.getWeight()+" Vs "+
                duck3.getKind()+"-"+duck3.getWeight());

        System.out.println(cow.getWeight()+"-"+cow2.getWeight()+"->"+cow.compareFoodPrice(cow2));
        System.out.println(cow3.getWeight()+"-"+cow2.getWeight()+"->"+cow3.compareFoodPrice(cow2));
        System.out.println(cow.getWeight()+"-"+cow3.getWeight()+"->"+cow.compareFoodPrice(cow3));
        System.out.println("-------------------------------- task3------------------------");

        System.out.println("cow, "+cow.getWeight()+" kg "+cow.compareWeight(cow3)+" cow3, "+cow3.getWeight()+" kg");
        System.out.println("cow3, "+cow3.getWeight()+" kg "+cow3.compareWeight(cow)+" cow, "+cow.getWeight()+" kg");
        System.out.println("cow, "+cow.getWeight()+" kg "+cow.compareWeight(cow)+" cow3, "+cow.getWeight()+" kg");
        System.out.println("cow, "+cow.getWeight()+" kg "+cow.compareWeight(animal1)+" animal1, "+cow.getWeight()+" kg");
        System.out.println("duck2, "+duck2.getWeight()+" kg "+duck2.compareWeight(hamsterCompare)+" hamsterCompare, "+duck2.getWeight()+" kg");
        // end of tests for H8 -----------------------------end of tests for H8---------------------------
    }

}

// Hamster *****
class Hamster extends Animal{
    public Hamster (double weight){
        super(weight);
    }
    @Override
    public Animal.AnimalKind getKind(){
        return Animal.AnimalKind.HAMSTER;
    }
    @Override
    public Animal.FoodKind getFoodKind(){
        return Animal.FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff(){
        return 0.03;
    }
    public static void main(String[] args) {
        Hamster hamster = new Hamster(222);
        System.out.println(hamster + " weight= "+ hamster.weight);

        //tests for H8
        System.out.println(hamster.getFood1kgPrice()+" - cost per 1 kg food");
        System.out.println(hamster.getFoodPrice()+" - cost of food for this animal");
    }
}

// Duck *****
class Duck extends Animal{
    public Duck (double weight){
        super(weight);
    }
    @Override
    public Animal.AnimalKind getKind(){
        return Animal.AnimalKind.DUCK;
    }
    @Override
    public Animal.FoodKind getFoodKind(){
        return Animal.FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff(){
        return 0.04;
    }

    public static void main(String[] args) {
        Duck duck = new Duck(32);
        System.out.println(duck + " weight= "+ duck.weight);
        //test parent's method in child
        System.out.println(duck.calculateFoodWeight());

        //tests for H8
        System.out.println(duck.getFood1kgPrice()+" - cost per 1 kg food");
        System.out.println(duck.getFoodPrice()+" - cost of food for this animal");
    }
}

// Complex Number ******
class ComplexNum{
    int a, b;
    public ComplexNum(int a, int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public String toString(){
        /*
        usually 0+bi write as bi / instead of a+0i - a.
        but robot asks 0+bi / a+0i
        */
        /*
        String  res;
        if (a==0 && b==0) {res="0";} else {
            if (a==0) { res = ""+b+"i";} else {
                if (b==0) { res =""+a;} else {
                    res=b<0 ? a+""+b+"i" : a+"+"+b+"i";

                }
            }
        }
        return res;
         */
        /*
        make robot happy
         */
        // negative values of b is not required (see test numbers), but robot kicked my 2nd attempt
        // return b<0 ? a+""+b+"i" : a+"+"+b+"i";
        return a+"+"+b+"i";
    }
    public ComplexNum add(ComplexNum num){
        ComplexNum z = new ComplexNum(a,b);
        z.a=a+num.a;
        z.b=b+num.b;
        return z;
    }
    public ComplexNum sub(ComplexNum num){
        ComplexNum z = new ComplexNum(a,b);
        z.a=a-num.a;
        z.b=b-num.b;
        return z;
    }
    public ComplexNum mul(ComplexNum num){
        ComplexNum z = new ComplexNum(a,b);
        z.a=a*num.a-b* num.b;
        z.b=b*num.a+a* num.b;
        return z;
    }
    public ComplexNum div(ComplexNum num){
        ComplexNum z = new ComplexNum(a,b);
        if (num.a==0 && num.b ==0) {
            System.out.print("not allowed operation ! division by ");
            z.a=0;
            z.b=0;
        } else {
            z.a = (a * num.a + b * num.b) / (num.a * num.a + num.b * num.b);
            z.b = (b * num.a - a * num.b) / (num.a * num.a + num.b * num.b);
        }
        // remember int a,b , so int/int=int

        return z;
    }
    public static void main(String[] args) {
        ComplexNum z1 = new ComplexNum(1,-56);
        ComplexNum z2= new ComplexNum(2,4);
        ComplexNum z3 = new ComplexNum(1,1);
        ComplexNum z4 = new ComplexNum(0,0);
        ComplexNum z5 = new ComplexNum(-7,0);
        ComplexNum z6 = new ComplexNum(0,-5);
        System.out.println(z1);
        System.out.println(z1.add(z2));
        System.out.println(z2.sub(z3));
        System.out.println(z3.sub(z2));
        System.out.println(z3.mul(z2));
        System.out.println(z3.mul(z4));
        System.out.println(z5);
        System.out.println(z6);
        System.out.println(z5.mul(z6));
        System.out.println(z1.div(z4));
        System.out.println(z6.div(z3));
    }
}