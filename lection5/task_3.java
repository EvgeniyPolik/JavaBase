import java.util.Scanner;

public class task_3 {

    private static int countVar = 0;
    private static int checketVar = 0;

    private static Boolean CheckPosition(Integer x,  Integer y, int[][] placement, int inPlace) {
        for (int i = 0; i < inPlace; i++)
            if (x == placement[i][0] || y ==  placement[i][1] || Math.abs(x - placement[i][0]) == Math.abs(y - placement[i][1]))
                    return false;
        return true;
    }

    private static void PrintField(boolean[][] field, int numVar) {
        System.out.printf("Расстановка № %d\n", numVar);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j]) 
                    System.out.print("X ");
                else
                    System.out.print("0 ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private static void MakePosition(int needPosition, int numInPosition, int x, int y, boolean[][] field, 
    int[][] placement, int fieldSize) {
        if (needPosition == numInPosition) {           
            PrintField(field, ++countVar);
            return;
        }

        if (x == fieldSize - 1 && y == fieldSize) {
            return;
        }
        
        if (y == fieldSize) {
            x++;
            y = 0;
        }
        checketVar++;
        if (CheckPosition(x, y, placement, numInPosition)) {
            field[x][y] = true;
            placement[numInPosition][0] = x;
            placement[numInPosition][1] = y;
            MakePosition(needPosition, numInPosition + 1, x, y + 1, field, placement, fieldSize);
            field[x][y] = false;
            MakePosition(needPosition, numInPosition, x, y + 1, field, placement, fieldSize);
        } 
        else {
            field[x][y] = false;
            MakePosition(needPosition, numInPosition, x, y + 1, field, placement, fieldSize);
        }
                  
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите размер доски N x N: ");
        int fieldSize = console.nextInt();
        System.out.println("Введите количество ферзей: ");
        int needPosition = console.nextInt();
        boolean[][] field = new boolean[fieldSize][fieldSize];
        int[][] placement = new int[needPosition][2];
        MakePosition(needPosition, 0, 0, 0, field, placement, fieldSize);
        System.out.printf("Найдено %d варианта расстановки, всего проверенно %d\n", countVar, checketVar);
    }
}
