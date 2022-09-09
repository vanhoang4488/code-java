/*
* Đề bài trong folder;
*/
package playgame;
import java.util.*;

public class PlayGame {

    public static boolean canWin(int leap, int[] game) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        boolean win = false;
        while(!st.empty()){
            int pos = st.peek();
            if( (pos+leap) >= game.length){ 
                win = true; 
                break;
            }else if( pos == game.length - 1){
                win = true; 
                break;
            }
            else{//lần lượt các lựa chọn có thể xảy ra.
                if(game[pos] == 0) game[pos] = 1;
                if(game[pos+leap] == 0 && game[pos] % 5 != 0){
                    st.push(pos + leap);                   
                    game[pos] *= 5; // đánh dấu nó đã tiến leap bước
                    continue;
                }    
                
                else if(pos < game.length - 1 && game[pos+1] == 0 && game[pos] % 3 != 0){
                    st.push(pos + 1);                    
                    game[pos] *= 3; //đánh dấu nó đã tiến 1 bước
                    continue;
                }
                
                else if(pos >= 1 && game[pos-1] == 0 && game[pos] % 2 != 0){
                    st.push(pos - 1);
                    game[pos] *= 2; //đánh dấu nó đã lùi.
                    continue;
                }
                
                else{
                    st.pop();
                }
            }
        }
        return win;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}