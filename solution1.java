import java.util.Scanner;

class solution1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int flights=sc.nextInt();
        String[][] arr=new String[flights][3];
        for(int i=0;i<flights;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.next();
            }
        }
    }
}