public class AcademicGroup  {    private List<Student> students;    public AcademicGroup() {        this.students = new ArrayList<>();    }    public void addStudent(Student student) {        students.add(student);    }    public Student[] getStudents() {        return students.toArray(new Student[0]);    }}