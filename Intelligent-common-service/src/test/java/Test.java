import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

      int zhengshu = 0;
      int fushu = 0;
        Scanner scanner = new Scanner(System.in);
      for(;;){
          System.out.println("请输入一个整数");
          int num = scanner.nextInt();
          if(num > 0){
              zhengshu ++;
          }else if(num<0){
              fushu ++;
          } else {
              System.out.println("整数个数"+zhengshu);
              System.out.println("负数个数"+fushu);
              break;
          }
      }

    }
}
