public class Digit {
    int d;
    Digit next;

    public Digit(int d){
        this.d = d;
        this.next = null;
    }

    //Getter method
    public int getDigit(){
        return this.d;
    }
}
