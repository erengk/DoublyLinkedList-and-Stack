public class Student {
    private String name;
    Student next;
    Student previous;

    // Constructor
    public Student(String n) {
        this.name = n;
        this.next = null;
        this.previous = null;
    }

    // Get method
    public String getName() {
        return this.name;
    }

	 // Solve given expression
    public double calculatePostfix(String exp) {
        SolveEquation s = new SolveEquation();
        return s.solve(exp);
    }

}
