package ru.progwards.java1.lessons.classes;

//Animal - parent *****
public class Animal {
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
}

//Cow *****
class Cow extends Animal{

    public Cow (double weight){
        super(weight);

    }
    @Override
    public AnimalKind getKind(){
        return AnimalKind.COW;
    }
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.HAY;
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
    }

}

// Hamster *****
class Hamster extends Animal{
    public Hamster (double weight){
        super(weight);
    }
    @Override
    public AnimalKind getKind(){
        return AnimalKind.HAMSTER;
    }
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff(){
        return 0.03;
    }
    public static void main(String[] args) {
        Hamster hamster = new Hamster(222);
        System.out.println(hamster + " weight= "+ hamster.weight);
    }
}

// Duck *****
class Duck extends Animal{
    public Duck (double weight){
        super(weight);
    }
    @Override
    public AnimalKind getKind(){
        return AnimalKind.DUCK;
    }
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
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
        // negative values of b is not required (see test numbers), but ...
        return b<0 ? a+""+b+"i" : a+"+"+b+"i";

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