package lection1;

import java.util.Scanner;
import java.lang.FunctionalInterface;


public class task_4 {
    @FunctionalInterface
    public interface Operate {
        int doIt(int a, int b);
    }
    public static void main(String[] args) {
        Scanner inConsole = new Scanner(System.in);
        System.out.print("Введите уравнение (Без пробелов! Напр: 1?+??=46): ");
        String equation = inConsole.next();
        inConsole.close();
        var ch = equation.toCharArray();
        Operate operate = (a, b) -> a + b;
        
        int numOperand = 0;

        StringBuilder firstVal = new StringBuilder();
        StringBuilder secondVal = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        String operSymbol = "+";

        for (int i = 0; i < ch.length; i++) 
        {
            switch(ch[i]) {
                case '+':
                    numOperand = 1;
                    break;
                case '-':
                    operSymbol = Character.toString(ch[i]);
                    operate = (a, b) ->  a - b;
                    numOperand = 1;
                    break;
                case '*':
                    operSymbol = Character.toString(ch[i]); 
                    operate = (a, b) ->  a * b;
                    numOperand = 1;
                    break;
                case '/':
                    operSymbol = Character.toString(ch[i]);
                    numOperand = 1;
                    operate = (a, b) ->  a / b;
                    break;
                case '=':
                    numOperand = 2;
                    break;
                default:
                    if (numOperand == 0)
                        firstVal.append(ch[i]);
                    else if (numOperand == 1)
                        secondVal.append(ch[i]);
                    else
                        answer.append(ch[i]);
            }

        }
            Boolean noSolver = true;
            for (int j = 0; j < 10; j++)
                {
                    Character val = (char) (j + 48);
                    String firstOper = firstVal.toString();
                    firstOper = firstOper.replace('?', val);
                    String secondOper = secondVal.toString();
                    secondOper = secondOper.replace('?', val);
                    String answ = answer.toString();
                    answ = answ.replace('?', val);
                    if (operate.doIt(Integer.parseInt(firstOper), Integer.parseInt(secondOper)) == Integer.parseInt(answ))
                    {
                        System.out.printf("%s %s %s = %s\n", firstOper, operSymbol, secondOper, answ);
                        noSolver = false;
                    }
                }
            if (noSolver)
                System.out.printf("Уравнение %s не имеет решений", equation);
    }
}
