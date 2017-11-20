import java.io.*;

public class ObjectsInFile {
        public static void main(String[] args) throws Exception {
                FileOutputStream fos = new FileOutputStream("students.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Student st = new Student("1", "Rose", "Rohini,Delhi");
                oos.writeObject(st);
                oos.flush();
                oos.close();
                FileInputStream fis = new FileInputStream("students.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                st = (Student) ois.readObject();
                System.out.println(st.toString());

                ois.close();
        }
}

class Student implements Serializable {
        private String id;
        private String name;
        private String address;

        public Student(String id, String name, String address) {
                this.id = id;
                this.name = name;
                this.address = address;
        }

        public String toString() {
                return "Student: " + id + ", " + name + ", " + address;
        }
}