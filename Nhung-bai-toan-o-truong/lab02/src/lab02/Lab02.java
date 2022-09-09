package lab02;
public class Lab02 {
    static Student[] list = new Student[100] ;
    
    public static boolean sameGroup(Student s1, Student s2){
        boolean sosanh = s1.getGroup().equals(s2.getGroup());
        System.out.println(sosanh);
        return sosanh;
    }
    
    public static void main(String[] args) {
        Student[] s;
        s = new Student[5];
        s[1] = new Student();
        s[1].setName("Hoang");
        s[1].setId("17020769");
        s[1].setGroup("INT22042");
        s[1].setEmail("hoangie2k62@gmail.com");
        System.out.println("Name is:"+ s[1].getName());
        s[1].getInfo();
        
        s[2] = new Student();
        s[2].getInfo();
        
        s[3] = new Student("Hoang_luoi","17020769","hoang_luoi@gmail.com");
        s[3].getInfo();
        
        s[4] = new Student(s[3]);
        s[4].getInfo();
        
        sameGroup(s[1],s[2]);
        
        s[0] = new Student(s[1]);
        
        for(int i= 0 ; i<4 ; i++)
        {
            for(int j =i ; j <5 ; j++)
            {
                System.out.print("s["+i+"] cung lop voi s["+j+"] la :");
                sameGroup(s[i],s[j]);
            }
        } 
        studentsByGroup();
        removeStudent("INT22041");
    }
    
    public static void studentsByGroup(){
        for ( int x = 0 ; x < 100 ; x++ ){
              list[x] = new Student(5); 
              System.out.println("s[" + x + "] la sinh vien lop:" + list[x].getGroup());
        } 
    }
    public static void removeStudent(String id){
        for ( int x = 0 ; x < 100 ; x++ ){
            if(list[x].getGroup().equals(id)) {
                list[x]=null;
            }
        } 
    }
}
