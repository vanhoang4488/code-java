/*
* Đây là bài toán yêu cầu xử lý tới hàng chục nghìn, hàng trăm nghìn trường hợp thử nghiệm.
* Nên phải dùng biến thể của tìm kiếm nhị phân để giảm độ phức tạp của thuật toán.
* Để bài trong folder cài đặt.
*/
package Leaderboard;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranking = new ArrayList<>();
        int i = 0;
        while(i < ranked.size()){
            
            if(i > 0 && Objects.equals(ranked.get(i), ranked.get(i-1))) {
                ranked.remove(i);
            }else i++;
            
        }
        //System.out.println(ranked);
        //System.out.println(ranked.size());
        for(i = 0; i < player.size(); i++){
            int player_point = player.get(i);
            if( player_point < ranked.get(ranked.size() - 1) ){
                ranking.add(ranked.size() + 1);
                continue;
            }
            if( player_point == ranked.get(ranked.size() - 1)){
                ranking.add(ranked.size());
                continue;
            }
            if( player_point >= ranked.get(0)){
                ranking.add(1);
                continue;
            }
            
            int left = 1; int right = ranked.size() - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
//                System.out.println(mid);
//                System.out.println(ranked.get(mid) + " - " + ranked.get(mid-1));
                if( player_point >= ranked.get(mid)  && player_point < ranked.get(mid - 1)){
                   ranking.add(mid + 1);
                   break;
                }
                
               if(player_point > ranked.get(mid)){
                   right = mid - 1;
               }
               
               if(player_point < ranked.get(mid)){
                   left = mid + 1;
               }                
            }
        }
        return ranking;
    }

}

public class Leaderboard {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int rankedCount = scan.nextInt();

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = scan.nextInt();
            ranked.add(rankedItem);
        }

        int playerCount = scan.nextInt();

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = scan.nextInt();
            player.add(playerItem);
        }
        scan.close();
        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        //System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        
    }
}
