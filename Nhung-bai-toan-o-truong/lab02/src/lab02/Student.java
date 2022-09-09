package lab02;

public class Student {
    private String name, id, group, email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void getInfo(){
        System.out.println("Name is :" + name);
        System.out.println("Id is :" + id);
        System.out.println("Group is :" + group);
        System.out.println("Email is :" + email);
    }
    Student(){
        name = "Student";
        id = "000";
        group = "INT22041";
        email = "uet@vnu.edu.vn";
    }
    Student(String n, String sid, String em){
        name = n;
        id = sid ;
        email = em;
        group = "INT22041";
     }
    Student(Student s){
        name = s.name;
        id = s.id;
        group = s.group;
        email = s.email;
    }
    public Student(int n){
        int a = (int)(Math.random()*n + 1);
        this.group = "INT2204"+a;
    }
}
