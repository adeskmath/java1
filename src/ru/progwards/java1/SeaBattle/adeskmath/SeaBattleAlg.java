package ru.progwards.java1.SeaBattle.adeskmath;

import ru.progwards.java1.SeaBattle.SeaBattle;


import java.util.Arrays;

public class SeaBattleAlg {
    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|

    char field[][];
    private SeaBattle seaBattle;
    int targetX, targetY;
    int innerHits=0;
    int totalFires=0;


    boolean checkCellRange(int x,int y){
        return ((x<10 & x>-1) & (y<10 & y>-1));
    }

    boolean checkCell(int x, int y){
        if (checkCellRange(x, y)) return  (field[x][y] == '-');
        return false;
    }

    void openAroundHit(int x, int y){
       // for (int i = 0; i<4; i++){}
        if (checkCell(x+1,y+1)) field[x+1][y+1]='o';
        if (checkCell(x+1,y-1)) field[x+1][y-1]='o';
        if (checkCell(x-1,y+1)) field[x-1][y+1]='o';
        if (checkCell(x-1,y-1)) field[x-1][y-1]='o';

    }
    void openAroundDestroyed(int x, int y){
        // for (int i = 0; i<4; i++){}
        if (checkCell(x+1,y)) field[x+1][y]='.';
        if (checkCell(x,y-1)) field[x][y-1]='.';
        if (checkCell(x,y+1)) field[x][y+1]='.';
        if (checkCell(x-1,y)) field[x-1][y]='.';

    }

    void finishTheShip(int x, int y, SeaBattle seaBattle){

        SeaBattle.FireResult fireResult=SeaBattle.FireResult.MISS;
        //System.out.println("hit main point "+x+" "+y);
        //fire right
        int i=0;
        do {
            i++;
            if (checkCell(x+i,y)) {
//                System.out.println("+ FIRE>>>RIGHT>>> "+(x+i)+" "+(y));
                seaBattle.fire(x+i,y);
                totalFires++;
                fireResult = seaBattle.fire(x+i,y);
                if (fireResult == SeaBattle.FireResult.MISS) {
                    field[x+i][y]='*';
                }

                if (fireResult == SeaBattle.FireResult.HIT) {
                    openAroundHit(x+i,y);
//                    System.out.println(">>>HIT---RIGHT>>> "+(x+i)+" "+(y));
                    innerHits=i;
                    field[x+i][y]='x';
                }
                if (fireResult == SeaBattle.FireResult.DESTROYED) {
                    openAroundHit(x+i,y);
                    openAroundDestroyed(x+i,y);
//                    System.out.println(">>>DESTROYED---RIGHT "+(x+i)+" "+(y));
                    innerHits=i;
                    field[x+i][y]='x';
                    return;
                }
            }
        } while (fireResult != SeaBattle.FireResult.MISS);
//-------------------------------------------------------------------
        //fire down

        int j=0;
        do {
            j++;
            if (checkCell(x,y+j)) {
//                System.out.println("+ FIRE>>>DOWN>>>"+x+" "+(y+j));
                seaBattle.fire(x,y+j);
                totalFires++;
                fireResult = seaBattle.fire(x, y+j);
                if (fireResult == SeaBattle.FireResult.MISS) {
                    field[x][y+j]='*';
                }
                if (fireResult == SeaBattle.FireResult.HIT) {
                    openAroundHit(x,y+j);
//                    System.out.println(">>>HIT---DOWN>>>"+x+" "+(y+j));
                    innerHits=j;
                    field[x][y+j]='x';
                }
                if (fireResult == SeaBattle.FireResult.DESTROYED) {
                    openAroundHit(x,y+j);
                    openAroundDestroyed(x,y+j);
//                    System.out.println(">>>DESTROYED---DOWN "+x+" "+(y+j));
                    innerHits=j;
                    field[x][y+j]='x';
                    return;
                }

            }

        } while (fireResult != SeaBattle.FireResult.MISS);

    }

    void init(SeaBattle seaBattle) {
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        for (int i = 0; i < seaBattle.getSizeY(); i++) {
            Arrays.fill(field[i], '-');
        }
        //String a = field.toString();
//        System.out.println(Arrays.toString(field));
//        System.out.println(Arrays.toString(field[0]));
//        System.out.println("|"+(field[0][0])+"|");
    }

    //void mark ()

//    public void battleAlgorithm(SeaBattle seaBattle) {
//        // пример алгоритма:
//        // стрельба по всем квадратам поля полным перебором
//        int hits = 0;
//        for (int y = 0; y < seaBattle.getSizeX(); y++) {
//            for (int x = 0; x < seaBattle.getSizeY(); x++) {
//                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
//                if (fireResult != SeaBattle.FireResult.MISS)
//                    hits++;
//                if (hits >= 20)
//                    return;
//            }
//        }
//    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        //  new SeaBattleAlg().init(seaBattle);

        init(seaBattle);
// show blank field
//        for (int i = 0; i < 10; i++){
//            for (int j = 0; j<10; j++){
//                System.out.print(field[j][i]);
//            }
//            System.out.println();
//        }


        int hits = 0;
        // simplest algorithm to be modified or finishTheShip
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if (checkCell(x,y)){

                    SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                    totalFires++;
//                    System.out.println("+ fire "+x+" "+y);
                    if (fireResult != SeaBattle.FireResult.MISS){
                        hits++;
                        field[x][y]='x';
                        openAroundHit(x,y);
                        if (fireResult == SeaBattle.FireResult.DESTROYED) {
                            openAroundDestroyed(x,y);
//                            System.out.println("destroyed "+x+" "+y);
                        } else {
//                            System.out.println("hit "+x+" "+y);
                            // strange, but finishTheShip does not give advantage
//                            finishTheShip(x,y,seaBattle);
//                            hits+=innerHits;
//                            System.out.println("finishing HITS-----------------"+innerHits);
                        }
                    } else field[x][y]='*';

                    if (hits >= 20) {
                        //System.out.println(seaBattle);
                        //show the field with my marks
//                        for (int i = 0; i < 10; i++){
//                            for (int j = 0; j<10; j++){
//                                System.out.print(field[j][i]);
//                            }
//                            System.out.println();
//                        }
//                        System.out.println("hits on target: "+hits);
//                        System.out.println("fired: "+totalFires);

                        return;
                    }
                }
            }
        }
    }

    static void test() {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());

    }

    static void comp() {
        SeaBattleAlg alg = new SeaBattleAlg();
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            SeaBattle seaBattle = new SeaBattle();
            alg.battleAlgorithm(seaBattle);
            result += seaBattle.getResult();
        }
        System.out.println(result/1000);
    }

    // функция для отладки
    public static void main(String[] args) {
        //test();
        comp();
    }
}
