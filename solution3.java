import java.util.Scanner;
public class solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("find_my_home_castle –soldiers ");
        int n = sc.nextInt();
        boolean[][] bool=new boolean[n][n];
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter coordinates for soldier " + i + ": ");
            String st=sc.next();
            int row = st.charAt(0)-'0';
            int col = st.charAt(2)-'0';
            bool[row][col]=true;
        }
        System.out.print("Enter the coordinates for your 'special' castle: ");
        String st=sc.next();
        int strow = st.charAt(0)-'0';
        int stcol = st.charAt(2)-'0';
        int ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;i<10;j++){
                if(j==strow) continue;
                ans+=help(strow,stcol,j,stcol,bool,i,n);
            }
            for(int j=0;i<n;j++){
                if(j==stcol) continue;
                ans+=help(strow,stcol,strow,j,bool,i,n);
            }
        }
        System.out.println("Thanks. There are "+ans+" unique paths for your 'special_castle'");
    }
    public static int[] x = {1,-1,0,0};
    public static int[] y = {0,0,1,-1};
    public static int help(int stx,int sty,int row,int col ,boolean[][] bool,int p,int len){
        if(stx==row && sty==col) return 1;
        if(!bool[row][col]) return 0;
        bool[row][col]=false;
        int ans=0;
        if(p==0){
            for(int i=0;i<len;i++){
                if(i==row) continue;
                ans+=help(stx,sty,row+x[p],col,bool,2,len);
            }
            for(int i=0;i<len;i++){
                if(i==col) continue;
                ans+=help(stx,sty,row,col+y[p],bool,2,len);
            }

        }
        else if(p==1){
            for(int i=0;i<len;i++){
                if(i==row) continue;
                ans+=help(stx,sty,row+x[p],col,bool,3,len);
            }
            for(int i=0;i<len;i++){
                if(i==col) continue;
                ans+=help(stx,sty,row,col+y[p],bool,3,len);
            }

        }
        else if(p==2){
            for(int i=0;i<len;i++){
                if(i==row) continue;
                ans+=help(stx,sty,row+x[p],col,bool,1,len);
            }
            for(int i=0;i<len;i++){
                if(i==col) continue;
                ans+=help(stx,sty,row,col+y[p],bool,1,len);
            }

        }
        else if(p==3){
            for(int i=0;i<len;i++){
                if(i==row) continue;
                ans+=help(stx,sty,row+x[p],col,bool,0,len);
            }
            for(int i=0;i<len;i++){
                if(i==col) continue;
                ans+=help(stx,sty,row,col+y[p],bool,0,len);
            }

        }
        return  ans;
    }
}


