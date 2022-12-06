public class School {

    public static void main(String[] args) {
        int grade = 0;
        Course course = new Course();
        String exp_1 = "8 2 3 * + 7 / 1 -"; // = 1.0
        String exp_2 = "9 4 * 6 5 8 2 + + - /"; // = -4.0
        String exp_3 = "6 5 4 + + 3 * 5 - 8 /"; // = 5.0
        String exp_4 = "8 7 * 5 + 8 - 2 / 3 /"; // = 8.0

        if(course.isEmpty())
            grade += 5;

        course.insert("John");
        course.insert("Mike");
        course.insert("Lisa", 0);

        if(course.getByPosition(1).getName() == "John")
            grade += 5;

        course.insert("Taylor", 1);
        course.insert("Tom", 2);
        course.insert("Jimmy", 0);

        if(course.getByPosition(3).getName() == "Tom")
            grade += 5;

        if(course.getByPosition(0).getName() == "Jimmy")
            grade += 5;

        System.out.println("********************************************************************************");
        course.print();


        System.out.println("********************************************************************************");
        Student deleted_student = course.deleteByPosition(0);

        if(deleted_student.getName() == "Jimmy" && deleted_student.calculatePostfix(exp_1) == 1)
            grade += 15;

        System.out.println("********************************************************************************");
        System.out.println("For equation \"" + exp_1 + "\" " + deleted_student.getName() + " answer is " + deleted_student.calculatePostfix(exp_1));


        System.out.println("********************************************************************************");
        deleted_student = course.deleteByName("Taylor");

        if(deleted_student.getName() == "Taylor" && deleted_student.calculatePostfix(exp_2) == -4)
            grade += 15;

        System.out.println("********************************************************************************");
        System.out.println("For equation \"" + exp_2 + "\" " + deleted_student.getName() + " answer is " + deleted_student.calculatePostfix(exp_2));


        System.out.println("********************************************************************************");
        deleted_student = course.deleteByPosition(3);

        if(deleted_student.getName() == "Mike" && deleted_student.calculatePostfix(exp_3) == 5)
            grade += 15;

        System.out.println("********************************************************************************");
        System.out.println("For equation \"" + exp_3 + "\" " + deleted_student.getName() + " answer is " + deleted_student.calculatePostfix(exp_3));


        System.out.println("********************************************************************************");
        deleted_student = course.deleteByName("Tom");

        if(deleted_student.getName() == "Tom" && deleted_student.calculatePostfix(exp_4) == 8)
            grade += 15;

        System.out.println("********************************************************************************");
        System.out.println("For equation \"" + exp_4 + "\" " + deleted_student.getName() + " answer is " + deleted_student.calculatePostfix(exp_4));

        if(course.size() == 2)
            grade += 10;

        if(course.size() > 0 && (course.head.getName() == "Lisa" && course.tail.getName() == "John"))
            grade += 10;

        System.out.println("///////////////////////////////////////////////////////////////////////////////");
        System.out.println("Total Grade is " + grade);
    }
}
