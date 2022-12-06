
public class Course {
    Student head; // head of linked list
    Student tail; // tail of linked list
    int noOfNodes = 0; // number of nodes int the linked list

    // Constructor
    public Course() {

        //
    }

    // Check list is empty or not
    public boolean isEmpty() {
        if (head == null && tail == null){
            return true;
        }else{
            return false;
        }
    }

    // This function first builds new node with the given data
    // than insert it to the LinkedList
    // new nodes are inserted to the tail of LinkedList
    public void insert(String name) {
        //Write your codes here
        Student newStudent = new Student(name);
        newStudent.next = null;
        newStudent.previous = tail;
        if (head == null && tail == null){
            head = newStudent;
            tail = newStudent;
        }
        else {
            tail.next = newStudent;
            tail = newStudent;
        }

        noOfNodes++;
    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(String name, int pos) {
        //Write your codes here
        //If list is empty
        Student newStudent = new Student(name);
        Student student = head;
        for (int i = 0; i < pos; i++){
            student = student.next;
        }
        if (head == null && tail == null){
            head = newStudent;
            tail = newStudent;
        } else if (pos == 0) {
            newStudent.next = student;
            student.previous = newStudent;
            head = newStudent;
        } else if (pos == noOfNodes -1) {
            newStudent.previous = student;
            student.next = newStudent;
            tail = newStudent;
        }else{
            newStudent.next = student;
            newStudent.previous = student.previous;
            student.previous.next = newStudent;
            student.previous = newStudent;
        }
        noOfNodes++;

    }

    // This method finds how many node are exist in LinkedList
    public int size() {
        if (head != null & tail != null) {
            return noOfNodes;
        }
        return 0;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public Student deleteByName(String name) {
        //Write your codes here
        Student newStudent = head;
        while (newStudent.getName() != null) {
            if (newStudent.getName().equals(name)) {
                newStudent.previous.next = newStudent.next;
                newStudent.next.previous = newStudent.previous;
                newStudent.next = null;
                newStudent.previous = null;
                noOfNodes--;
                break;
            }
            newStudent = newStudent.next;
        }
        return newStudent;
    }
    // This functions delete a node in the LinkedList by a given position
    public Student deleteByPosition(int pos) {
        //Write your codes here
        Student newStudent = head;

        for (int i = 0; i < pos; i++){
            newStudent = newStudent.next;
        }
        if (pos == 0){
            head = newStudent.next;
            head.previous = null;
            newStudent.next = null;
            newStudent.previous = null;
        } else if (pos == noOfNodes -1) {
            tail = newStudent.previous;
            tail.next = null;
        }else {
            newStudent.previous.next = newStudent.next;
            newStudent.next.previous = newStudent.previous;
            newStudent.next = null;
            newStudent.previous = null;
        }
        noOfNodes--;

        return  newStudent;
    }

    // This function get student by given position
    public Student getByPosition(int pos) {
        //Write your codes here
        Student newStudent = head;

        for (int i = 0; i < pos; i++){
            newStudent = newStudent.next;
        }
        return newStudent; // don't forget to delete this line
    }

    // That function prints  the LinkenList
    public void print() {
        System.out.print("Course student list: ");
        Student student = this.head;  // make a copy of head

        // never operate on "head", otherwise you will lost the linkedlist
        // unless you want to change "head"
        while (student != null) {
            System.out.print(student.getName() + "  ");
            student = student.next;  // iterate to next node
        }

        System.out.println();
    }

}

