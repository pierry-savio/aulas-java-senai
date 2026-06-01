import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Double> grades = new ArrayList<>();
    private int year;
    private School school;
    private String ra;

    public Student(String name, int year, School school, String ra){
        this.name = name;
        this.year = year;
        this.school = school;
        this.ra = ra;
    }

    public Student(String name, ArrayList<Double> grades, int year, School school){
        this.name = name;
        this.grades = grades;
        this.year = year;
        this.school = school;
    }

    //Get
    public String getName() {
        return name;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public int getYear() {
        return year;
    }

    public School getSchool(){
        return school;
    }

    public String getRa(){
        return ra;
    }

    //Set
    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSchool(School school){
        this.school = school;
    }

    public void addGrade(double grade){
        grades.add(grade);
    }

    public void removeGrade(int index){
        grades.remove(index);
    }

    public double calcAverage(){
        double sum = 0.0;
        for (Double grade : grades){
            sum += grade;
        }
        return sum/grades.size();
    }

    public boolean isApproved(){
        return calcAverage() >= school.getMinGrade();
    }

    @Override
    public String toString(){
        if (calcAverage() >= 0) {
            if (isApproved()) {
                return "Nome: " + name + " | " + "Média: " + String.format("%.2f", calcAverage()) + " | Status: Aprovado";
            }
            else{
                return "Nome: " + name + " | " + "Média: " + String.format("%.2f", calcAverage()) + " | Status: Reprovado";
            }
        }
        else{
            return "Nome: " + name + " | " + "Média: 0 | Status: Reprovado";
        }
    }
}
