package lesson2;

import java.util.Scanner;

public class ConView implements View {
    private static final Scanner scan= new Scanner(System.in);

    @Override
    public void output(String outstring){
        System.out.println(outstring);
    }

    @Override
    public String input(String invite){
        System.out.print(invite);
        return input();
    }

    @Override
    public String input(){
        return scan.nextLine();
    }

}
