import java.util.ArrayList;

public class School {
    private String name;
    private final double minGrade = 7;
    private ArrayList<Student> students = new ArrayList<>();

    public School(String name){
        this.name = name;
    }

    public School(String name, ArrayList<Student> students){
        this.name = name;
        this.students = students;
    }

    //Get
    public String getName(){
        return name;
    }

    public double getMinGrade(){
        return minGrade;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Student getStudentByRa(String ra){
        for (int i = 0; i<students.size(); i++){
            if (students.get(i).getRa().equals(ra)){
                return students.get(i);
            }
        }
        return null;
    }

    //Set
    public void setName(String name){
        this.name = name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(int index){
        students.remove(index);
    }

    @Override
    public String toString(){
        if (students != null) {
            return "Escola " + name + ": Nota mínima: " + minGrade + " | Alunos atuais: " + students.size();
        }
        else{
            return "Escola " + name + ": Nota mínima: " + minGrade + " | Alunos atuais: 0";
        }
    }
}
