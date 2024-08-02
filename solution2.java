import java.util.ArrayList;
import java.util.Scanner;

public class solution2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int val=0;
        ArrayList<Integer> arr=new ArrayList<>();
        System.out.println("run distributed_apple");
        while(val>=0){
            System.out.print("Enter apple weight in gram (-1 to stop) : ");
            val=sc.nextInt();
            if(val==-1) break;
            arr.add(val);
        }
        help(arr);
        System.out.println("Distributed Result : ");
        System.out.print("Ram : ");
        for(int i=0;i<ram.size();i++){
            System.out.print(arr.get(ram.get(i))+" ");
        }
        System.out.println();
        System.out.print("Sham : ");
        for(int i=0;i<sham.size();i++){
            System.out.print(arr.get(sham.get(i))+" ");
        }
        System.out.println();
        System.out.print("Rahim : ");
        for(int i=0;i<rahim.size();i++){
            System.out.print(arr.get(rahim.get(i))+" ");
        }
        System.out.println();
    }
    static ArrayList<Integer> ram=new ArrayList<>();
    static ArrayList<Integer> sham=new ArrayList<>();
    static ArrayList<Integer> rahim=new ArrayList<>();
    public static void help(ArrayList<Integer> arr){
//        Ram:50%
//        Sham:30%
//        Rahim:20%
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }
        int Rval=(sum*5)/10;
        int Sval=(sum*3)/10;
        int Rahval=(sum*2)/10;
        find(arr,Rval,Sval,Rahval,0);
    }
    public static boolean find(ArrayList<Integer> arr,int Rval,int Sval,int Rahval,int ind){
        if(Rval==0 && Sval==0 && Rahval==0 && ind==arr.size()) return true;
        if(Rval<0 || Sval<0 || Rahval<0 || ind>=arr.size()) return false;
        if(find(arr,Rval,Sval,Rahval-arr.get(ind),ind+1)){
            rahim.add(ind);
        }
        else if(find(arr,Rval,Sval-arr.get(ind),Rahval,ind+1)){
            sham.add(ind);
        }
        else if(find(arr,Rval-arr.get(ind),Sval,Rahval,ind+1)){
            ram.add(ind);
        }
        return true;
    }

}
