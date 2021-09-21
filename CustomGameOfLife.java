import java.util.Scanner;
import java.io.*;
import java.lang.Thread;
import java.lang.Math;   

class Main {

  public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.print("Width?: ");
    int W = scan.nextInt();
    
    System.out.print("Height?: ");
    int H = scan.nextInt();

    int[][] plane = new int[W][H];

    int randomNum;

    for (int w = 0; w < W; w++){
      for (int h = 0; h < H; h++){
        
        randomNum = (int)(Math.random() * 10) - 1;

        if (randomNum == 4 || randomNum == 8)        
          plane[w][h] = 1;
        else
          plane[w][h] = 0;
      }
    }

    Main.generate(plane, W, H);

    System.out.print("How many loops?: ");

    int loops = scan.nextInt();

    System.out.println();

    int[][] newPlane = new int[W][H];

    for (int k = 1; k <= loops; k++){
      Main.clearScreen();

      newPlane = Main.future(plane, W, H);
      Main.generate(plane, W, H);
      plane = newPlane;

      try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      
      
    }
    
  }

  static int[][] future(int[][] plane, int W, int H){
    int[][] future = new int[W][H];
    
    for (int w = 1; w < W - 1; w++){
      for (int h = 1; h < H - 1; h++){
        int neighbors = 0;

        for (int i = -1; i <= 1; i++){
          for (int j = -1; j <= 1; j++){
            neighbors += plane[w + i][h + j];

          }
        }
        
        neighbors -= plane[w][h];

        if (plane[w][h] == 1 && neighbors > 3)
          future[w][h] = 0;

        else if (plane[w][h] == 1 && neighbors < 2)
          future[w][h] = 0;

        else if (plane[w][h] == 0 && neighbors == 3)
          future[w][h] = 1;

        else
          future[w][h] = plane[w][h];

        

      }
    }

    return future;
    
  }

  static void generate(int[][] plane, int W, int H){

    for (int i = 0; i < W; i++){
      for (int j = 0; j < H; j++){
        if (plane[i][j] == 0)
          System.out.print("⬛ ");
        else
          System.out.print("⬜ ");
        
      }

      System.out.println();
    }

  }
}