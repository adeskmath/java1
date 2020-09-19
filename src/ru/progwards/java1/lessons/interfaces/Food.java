package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    int weight;
    Food(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        switch (Integer.compare(getWeight(), ((Food) smthHasWeigt).getWeight())){
            case -1:
                return CompareResult.LESS;

            case 0:
                return CompareResult.EQUAL;

            default: return CompareResult.GREATER;
        }
    }


    public static void main(String[] args) {
        Food food1 = new Food(55);
        Food food2 = new Food(33);
        Food food3 = new Food(22);
        Food food4 = new Food(11);
        Food food5 = new Food(44);
        System.out.println(food1.getWeight()+" is "+food1.compareWeight(food2)+ " than "+food2.getWeight());
        System.out.println(food1.getWeight()+" is "+food1.compareWeight(food3)+ " than "+food3.getWeight());
        System.out.println(food2.getWeight()+" is "+food2.compareWeight(food3)+ " than "+food3.getWeight());


    }


}
