import java.util.Locale;

public class SolveEquation {
    Digit top; // top of stack
    int noOfDigits; // number of Digits

    // Constructor
    SolveEquation(){
        //Write your codes here
        this.top = null;
        this. noOfDigits = 0;
    }

    public double solve(String exp) {
        //Write your codes here
        String[] splited = exp.split("\\s+");
        for (String item : splited){
            if (item.equals("+")){
                int temp = top.d;
                this.pop();
                top.d += temp;
            } else if (item.equals("-")) {
                int temp = top.d;
                this.pop();
                top.d -= temp;
            } else if (item.equals("*")) {
                int temp = top.d;
                this.pop();
                top.d *= temp;
            } else if (item.equals("/")) {
                int temp = top.d;
                this.pop();
                top.d /= temp;
            }else {
                push(Integer.parseInt(item));
            }
        }

        return this.top.d; // don't forget to delete this line
    }

    // Utility function to add an element Digit to the stack
    public void push(int d){
        //Write your codes here
        Digit newDigit = new Digit(d);
        newDigit.next = top;
        top = newDigit;
        noOfDigits++;
    }

    // Utility function to pop a top element from the stack
    public int pop(){
        //Write your codes here
        int number = top.d;
        top = top.next;
        if (noOfDigits == 1){
            top = null;
        }
        noOfDigits--;
        return number; // don't forget to delete this line
    }

    // Utility function to return the top element of the stack
    public int top(){
        //Write your codes here
        if (noOfDigits == 0){
            return -1;
        }
        return top.d; // don't forget to delete this line
    }

    // Utility function to check if the stack is empty or not
    public Boolean isEmpty(){
        //Write your codes here
        if (noOfDigits == 0){
            return true;
        }
        return false;
    }

    // Utility function to return the size of the stack
    public int size() {
        //Write your codes here
        return noOfDigits; // don't forget to delete this line
    }

}
