import java.util.ArrayList;
import java.util.Scanner;

/*
 * Đề bài: Nhập đa thức biến x có bâc n ( 0 <= n <= 100 )
 * a, Nhập/Xuất đa thức 
 * b, tính giá trị của đa thức với x0 bất kì
 * 
 * 
 * Giả sử:Bài toán có số và số lũy thừa có thể là 1 biểu thức trong dấu ngoăc kép "()"
 * +> Và trong dấu ngoặc kép lại chứa các biểu thức khác nữa.
 * 
 * +> Các lỗi có thể xảy ra ở bài toán:
 * 1. không đóng mở ngoắc kép.
 * 2. thiếu số lũy thừa
 * 3. sau dấu toán tử rỗng.
 * 4. trong số và số lũy thừa có chứa kí tự không phải số.
 * 
 */


/*
 * Giải quyết bài toán:
 * 1. Khi nhập vào chuỗi String điều đầu tiên cần làm là tách các số và số lũy thừa ra và chúng theo từng cặp.
 * Câu hỏi đặt ra là nên lưu như thế nào?
 * a> lưu vào mảng String 2 chiều.=> Việc tính toán với 1 biểu thức là số hay số lũy thừa, giải quyết thế nào:
 *    +>Tách nhỏ ra tiếp cho đến khi chỉ còn lại số. => Vấn đề liên kết các số với nhau bằng cách nào : 
 *        +>B1: duyệt vòng for: khi thấy các 
 *    
 *
 * 
 */

/*
 * (  )^(  ) + - +  - 1  x + 100x^7 + (   )x^(   ) + x^7
 * 1,nếu dùng x làm kí tự phân cách thì biểu thức đầu tiên phân tách bằng cách nào.
 *  Vấn đề: 
 *     +> làm sao biết dc kí tự x nào ở trong ngoặc, phần này xử lý dễ cứ bao giờ đóng hết ngoặc rồi hãng lấy x làm kí tự phân 
 *     cách còn k cứ lấy kí tự ")" làm kí tự cuối cùng.
 *     +> lấy "(" làm vị trí bắt đầu.
 * 1.2, Với biểu thức thứ 2 giải quyết bằng cách nào:
 *    +> lấy kí tự bắt đầu sau dấu toán tử cuối cùng, nếu gặp kí tự "-" ta sẽ bắt đầu đếm
 *       +> solan % 2 == 1, ta sẽ thêm dấu trừ vào trước biểu thức đã tách xong.
 *       +> solan % 2 == 0, giữ nguyên dấu biểu thức.
 *    +> Nếu lấy kí tự sau dấu toán tử cuối cùng làm vị trí bắt đầu ta sẽ thường xuyên gặp phải tình 
 *       trạng trước số hay biểu thức có 1 dấu cách. => không nên
 *    
 *    +> Ta lấy vị trí kết thúc là vị trí tìm thấy kí tự "x", vậy xác định vị trí bắt đầu bằng cách nào:
 *       +> trong quá trình duyệt nếu gặp bất cứ số nào sẽ bắt dầu đánh dấu lấy số từ vị trí đấy:
 *           Có 2 vấn đề xảy ra:
 *             1. như ví dụ trên, ta có số 1 đứng sau dấu cộng và sau số 1 không có dấu toán tử nào nữa cả.=>Đây là biểu thức sai
 *             2. Nếu không xảy ra lỗi như trường hợp 1 thì vị trí bắt đầu vẫn đang ở vị trí của dấu "(" cuối cùng, làm sao để lấy
 *               ra số 1 từ biểu thức trên.
 *               
 *           Giải quyết:
 *           
 *             1.nếu sau khi xác định được vị trí bắt đầu mà sau vị trí đó có dấu cách thì gửi thông báo lỗi và break vong lặp.
 *             Ở đây ta đang xét trường hợp thoát khỏi dấu ngoặc kép rồi hay count == 0.
 *             
 *             2.Ta xét vị trí trước kí tự x mà không có kí tự số nào => lấy số bằng 1
 *             
 *                  
 *                  
 *                  
 *                  
 *****Cách giải quyết cả bài toán:
 *    
 *    +> ta có các biến lần lượt sau:
 *    1. count = 0, đếm xem ta đăng xét biểu thức trong ngoặc hay không trong ngoặc.
 *       +> nếu gặp "(" ta tăng count lên 1, nếu count == 1 ta có vị trí bắt đầu bằng vị trí tìm thấy "(".
 *       +> nếu gặp ")" ta giảm count đi 1, nếu count ==0 ta  và xét trường hợp:
 *          1. nếu end - start = 1 => lỗi và break vong lặp
 *          2. end - start > 1: Các trường hợp xảy ra:
 *             1. Bên trong không có số hay biểu thức, chỉ có các kí tự không có ý nghĩa thì phần này sẽ xử lý khi tính toán]
 *             2. Bên trong chứa biểu thức có ý nghĩa.         
 *             => kiểm tra xem i có < pyl.length() - 1 hay không?:
 *               1. false: end = i.
 *               2. true: kiểm tra kí tự tiếp theo là gì:
 *                  1. Là x : end = i + 1
 *                  2. là ^ : end = i
 *                  3. Các kí tự khác => lỗi và break; 
 *                  
 *              => tách lấy chuối con và continue;    
 *       +> nếu count < 0 => lỗi và break vòng lặp
 *       +> nếu count ==0 ==> đã thoát ra khỏi "(  )"
 *           +> duyệt mảng for mà thấy các kí tự khác số, x, + , - , ( , ) => lỗi và break.
 *           +> duyệt mảng for cho đến khi tìm thấy kí tự số đầu tiên (dùng biến check kiểm tra) thì đánh vị trí bắt đầu. trường hợp có thể xảy ra:
 *              +> if check = 1 mà tìm thấy các kí tự tiếp theo không phải là số  thì thông báo lỗi và break vòng lặp
 *           +> duyệt mảng for cho đến khi tìm thấy kí tự "^" (dùng check đánh dấu) thì start = i + 1;
 *              +> if check = 2 mà tìm thấy các kí tự tiếp theo không phải sô , + , - thì thông báo lỗi và break.
 *           +> vị trí kết thúc là khi ta tìm thấy kí tự x đầu tiên Khi đó: check = 0.
 *           +> khi tìm thấy vị trí kết thúc ta xét vị trước nó xem có phải kí tự số không? nếu không phải => số =+-1.
 *       +> nếu i == pyl.length() - 1 && count > 0 => thông báo lỗi    
 *   2. solan = 0, kiểm tra dấu của sô hay số lũy thừa.
 *        
 * 
 *
 * 
 * 
 */

public class TinhDaThuc {

	private static Scanner input;
	private ArrayList<String> middle = new ArrayList<String>();
	private String[][] list;

	private void stepOne( String pyl) {
        int count = 0;	
		int start = 0, end = 0;	
		int solan = 0;	
		boolean check = false;	
		for(int i= 0; i< pyl.length(); i++) {		
			String s = Character.toString(pyl.charAt(i));		
		    // kiểm tra xem đã xet qua các biểu thức nào chưa?
			try {
				Double.parseDouble(s);
				check = true;		
			}catch(Exception e) {}
			if(s.equals("x") || s.equals("^"))  check = true;	
			//kiểm tra xem đã xet qua các biểu thức nào chưa?
			if( s.equals("(") ){
				count++;
			}else if( s.equals(")") ){
				count--;
			}			
			if(count == 0) {				
				if(s.equals("-") || s.equals("+") || i == pyl.length() - 1) {			    
					if(check) {					
						end = i ;						
						if(i == pyl.length() - 1) end = i + 1;						
						String z = pyl.substring(start, end).trim();						
						solan = 0;						
						middle.add(z);					
						start = end;					
						check = false;					
					}
				}
			}				
		}
		for(int i= 0; i< middle.size(); i++) {		
			System.out.println(middle.get(i));
		}
	}
	
	
	private void stepTwo() {
		list = new String[middle.size()][2];
		int row = -1;
		for(int i = 0; i< middle.size(); i++) {	
			int count = 0, start = 0, end = 0;
			int solan = 0;
			boolean check = false;
			String content = middle.get(i);
			row++;
			for(int j = 0; j < content.length(); j++) {		
				String s = Character.toString(content.charAt(j));			
				if( s.equals("(") ) {
					count++;
					if(start == 0) {
						check = true;
						start = j;
					}
				}else if( s.equals(")") ) {				
					count--;
				}
				if(count == 0) {
					if(s.equals("-")) solan++;
					try {
						Double.parseDouble(s);					
					    if(check == false) {
					    	check = true;
					    	start = j;
					    }
					}catch(Exception e) {}
					if(s.equals("x") && check == false) {
						check = true;
						start = j;
					}
					if( s.equals("^") ) {					
						end = j;
						String z = content.substring(start, end);
						if(solan % 2 ==1) z= "-" + z;
						list[row][0] = z;				
						start = end + 1;
					}
					if(j == content.length() - 1) {						
					    end = j + 1;
					    String z = content.substring(start, end);
					    if(list[row][0] == null) {	
					    	if( solan % 2 == 1 ) z = "-" + z;
					    	list[row][0] = z;
					    	list[row][1] = "1";
					    }else {
					    	list[row][1] = z;
					    }	
					}	
				}		
			}			
		}
		
		
		for(int i = 0; i< middle.size(); i++) {
			System.out.println(list[i][0] + "---"  + list[i][1]);		
		}
		
	}
	
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		TinhDaThuc sum = new TinhDaThuc();
		
		String pyl = input.nextLine().trim();
				
		System.out.println(pyl);
		
		sum.stepOne(pyl);
		
		System.out.println("-------------------------------------");
		
		sum.stepTwo();
	}
}
