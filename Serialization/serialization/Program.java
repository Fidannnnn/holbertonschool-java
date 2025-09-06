public class Program {  

    public static void main(String[] args) {    

        Student student1 = new Student(21, "Jane Doe", "1011121314");   
        Student student2 = new Student(33, "John Bannons", "1122334455");   
        Student student3 = new Student(27, "Alyssa White", "minha_senha_100");  
        Student student4 = new Student(35, "Maike Eed", "Maike@eed100");    
        Student student5 = new Student(19, "Peter Diemon", "123");

        List<Student> students = List.of(   
            student1, student2, student3, student4, student5    
        );  

        SerializeStudents<Student> serializeStudent1 = new SerializeStudents<Student>("students.data"); 
        serializeStudent1.serialize(students);  

        List<Student> deserializationList1 = serializeStudent1.deserialize();   

        for(Student e : deserializationList1) { 
            System.out.println(e);  
        }   

        SerializeStudents<Student> serializeStudent2 = new SerializeStudents<Student>("students1.data");    
        List<Student> deserializationList2 = serializeStudent2.deserialize();   
      } 
    }