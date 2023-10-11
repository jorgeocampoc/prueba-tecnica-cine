import java.sql.Array;
import java.util.Scanner;

public class Cinema {
  public static void main(String[] args) {
  getReserva();
  }
  public static void getReserva(){
    char[][] res = llenar();
    Scanner scanner = new Scanner(System.in);
    int option ;
    int fila = 0;
    int columna = 0;
    boolean band = false;
    do{
      System.out.println("****** Bienvenido al sistema de reserva de butacas ******");
      System.out.println("Seleccione una opcion:\n1. Mostrar asientos\n2. Reservar asiento\n3. Finalizar");
      option = scanner.nextInt();
      switch ( option ){
        case 1:
          imprimir(res);
          break;
        case 2:
          fila = verificarFilaColumna("Fila");
          columna = verificarFilaColumna("Columna");
          res = marcarAsiento(res, fila, columna);
          break;
        case 3:
          band = true;
          break;
      }
    }while (!band);
  }

  public static char[][] llenar(){
    char res[][] = new char[10][10];
    for (int i = 0; i<10;i++){
      for (int j = 0; j<10;j++){
        res[i][j] = 'L';
      }
    }
    return res;
  }
  public static void imprimir(char[][] res){
    String fila = "";
    System.out.println("    0   1   2   3   4   5   6   7   8   9");
    for (int i = 0; i<10;i++){
      for (int j = 0; j<10;j++){
          char  aux = res[i][j];
        fila = fila + " "+"["+aux+"]";
      }
      System.out.println(i+" "+fila);
      fila = "";
    }
  }

  public static int verificarFilaColumna(String filaColumna){
    Scanner scanner = new Scanner(System.in);
    int option ;
    int res = 0;
    boolean band = false;
    do {
      System.out.println(filaColumna+": Ingrese un valor entre 0 y 9");
      option = scanner.nextInt();
      if( option>=0 && option<10 ){
        res = option;
        band = true;
      }
    }while (!band);
    return res;
  }

  public static char[][] marcarAsiento(char[][] res, int fila, int columna){
    Scanner scanner = new Scanner(System.in);
    if(res[fila][columna] == 'X' ){
      System.out.println("El asiento con la posicion Fila:"+ fila+" y Columna:"+columna+", ya esta reservado");
      boolean band = false;
      do {
        System.out.println("Introdusca las posiciones del asiento");
        System.out.println("Fila: Ingrese un valor entre 0 y 9");
        fila = scanner.nextInt();
        System.out.println("Columna: Ingrese un valor entre 0 y 9");
        columna = scanner.nextInt();
        if( res[fila][columna] == 'X' ){
          System.out.println("El asiento con la posicion Fila:"+ fila+" y Columna:"+columna+", ya esta reservado");
        }else {
          res[fila][columna] = 'X';
          band = true;
        }
      }while (!band);
    }else {
      res[fila][columna] = 'X';
    }
    return res;
  }

}
