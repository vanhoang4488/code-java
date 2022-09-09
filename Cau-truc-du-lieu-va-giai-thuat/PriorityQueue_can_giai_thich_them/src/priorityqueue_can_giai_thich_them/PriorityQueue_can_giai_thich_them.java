/*
Đề bài trong folder lưu trữ, kèm ví dụ chạy thử nghiệm
Thứ Cần giải thích là sự khi nào và lúc nào thì PriorityQueue sắp xếp.
Điều kiện sắp xếp mảng là k sai vì đã hoàn thành bài Test bằng List với điều kiện đó rồi
*/
package priorityqueue_can_giai_thich_them;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;
class Student implements Comparable<Student>{
    private double cgpa;
    private String fname;
    private int id;
    public Student(double cgpa, String fname, int id){
        this.cgpa = cgpa;
        this.fname = fname;
        this.id = id;
    }
    
    public double getCgpa(){
        return this.cgpa;
    }
    
    public String getName(){
        return this.fname;
    }
    public int getId(){
        return this.id;
    }
    public int compareTo(Student st){
        BigDecimal bst1 = new BigDecimal(String.valueOf(this.getCgpa()));
        BigDecimal bst2 = new BigDecimal(String.valueOf(st.getCgpa()));
        if(bst1.compareTo(bst2) != 0) return -bst1.compareTo(bst2);
        
        //neu cgpa = nhau => so sanh fname
        
        if(this.getName().compareTo(st.getName()) != 0) return this.getName().compareTo(st.getName());
        
        //neu fname = nhau => so sanh id
        if(this.getId() > st.getId()) return 1;
        return -1;
    }
    
    public String toString(){
        return this.getName();
    }
}

class Priorities{
    private Queue<Student> students = new PriorityQueue<Student>();
    
    public List<Student> getStudents(List<String> events){
        for(String s : events){
            if(s.equals("SERVED")) {System.out.println(students);students.poll();}
            else{
                String[] arr = s.split("\\s+");
                Student student = new Student(Double.parseDouble(arr[2]), arr[1], Integer.parseInt(arr[3]));
                students.add(student);
            }
        }
        System.out.println(students);
        students.poll();
        Student[] arr = students.toArray(new Student[students.size()]);
        return new ArrayList(Arrays.asList(arr));
    }
}

public class PriorityQueue_can_giai_thich_them {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}