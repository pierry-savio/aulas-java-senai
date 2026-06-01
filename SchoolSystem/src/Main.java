import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        cleanScreen();

        System.out.println("__ S I S T E M A  _  E S C O L A R __");
        System.out.println();
        System.out.println("__ Cadastro da Escola __");
        System.out.print("Nome: ");
        String schoolName = sc.nextLine();

        School school = new School(schoolName);

        cleanScreen();
        System.out.println(school);
        System.out.println();
        System.out.println("Escola criada com sucesso!");
        System.out.println("pressione enter para continuar...");
        sc.nextLine();

        cleanScreen();

        System.out.println("__ Cadastro de Alunos __");

        System.out.println();

        System.out.print("Quantidade de cadastros: ");
        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i<n; i++) {
            cleanScreen();
            System.out.println("__ Cadastro de Alunos __");
            System.out.println();
            System.out.println("Aluno #" + (i + 1));
            System.out.println("------------------");
            System.out.print("Nome: ");
            String studentName = sc.nextLine();
            System.out.print("Série: ");
            int studentYear = sc.nextInt();
            System.out.print("RA: ");
            sc.nextLine();
            String studentRA = sc.nextLine();
            school.addStudent(new Student(studentName, studentYear, school, studentRA));
        }

        cleanScreen();
        System.out.println("Cadastro feito com sucesso!");
        System.out.println("pressione enter para continuar...");
        sc.nextLine();

        cleanScreen();

        int option = 0;

        while (option != 3) {

            System.out.println("-----------------------");
            System.out.println("        M E N U        ");
            System.out.println(" 1 - Listar alunos     ");
            System.out.println(" 2 - Adicionar notas   ");
            System.out.println(" 3 - Sair              ");
            System.out.println("-----------------------");
            System.out.print("N: ");
            option = sc.nextInt();

            cleanScreen();

            switch (option){
                case 1:
                    for (Student student : school.getStudents()){
                        System.out.println(" - " + student);
                    }
                break;

                case 2:
                    for (Student student : school.getStudents()){
                        System.out.println(" - " + student.getName() + " | RA: " + student.getRa());
                    }
                    System.out.println("");

                    System.out.print("Student RA: ");
                    sc.nextLine();
                    String studentRa = sc.nextLine();

                    System.out.print("Quantidade de notas: ");
                    int gradesQuantity = sc.nextInt();

                    System.out.println();

                    for (int i = 0; i<gradesQuantity; i++){
                        System.out.print("Nota #" + (i+1) + ": " );
                        double grade = sc.nextDouble();
                        school.getStudentByRa(studentRa).addGrade(grade);
                    }
                break;
            }

            System.out.println();
            System.out.println("pressione enter para continuar...");
            sc.nextLine();
            sc.nextLine();
            cleanScreen();
        }

        cleanScreen();

        System.out.println("__ SAÍDA FINAL __");
        System.out.println();
        System.out.println(school);
        System.out.println();
        for (Student student : school.getStudents()){
            System.out.println(" - " + student);
        }
    }

    public static void cleanScreen(){
        for (int i = 0; i<80; i++){
            System.out.println();
        }
    }

    public static void cleanScreen(int lines){
        for (int i = 0; i<lines; i++){
            System.out.println();
        }
    }
}