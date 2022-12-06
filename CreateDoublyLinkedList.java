public class CreateDoublyLinkedList {
    class Node{
        String data;
        Node prev;
        Node next;

        public Node(String data){
            this.data = data;
        }
    }
    int size = 0;
    Node head = null;
    Node tail = null;

    public void addNewNodeInBegin(String data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;

            head.prev = null;
            tail.next = null;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        }
        size++;
    }
    public void addNode(){ //yeni

    }
    public void deleteNode(){
        head =head.next;
        tail = tail.prev;
    }

    public void deleteNodeAtSpecifiedLocation(int position){
        if (head == null || position > size){
            System.out.println("\n" + position + "th position is not available\n");
        }
        else {
            if (position == 1){
                deleteNode();

                size--;
            }else {
                Node current = head;
                for (int i = 1; i < position; i++){
                    current = current.next;
                }
                current.next.prev = current.prev;
                current.prev.next = current.next;
            }
            System.out.println(position + " node is deleted successfully from DDL");
        }
    }
    public void addNodeAtSpecifiedLocation(int position){ //yeni

        if (head == null || position > size){
            System.out.println("\n" + position + "th position is not available\n");
        }
        else {
            if (position == 0){

                size++;
            }
        }
    }
    public void showData(){
        Node current = head;

        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Nodes of doubly linked list:");

        while (current != null){
            System.out.println(current.data + "\n");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CreateDoublyLinkedList obj = new CreateDoublyLinkedList();

        obj.addNewNodeInBegin("New York");
        obj.addNewNodeInBegin("Los Angeles");
        obj.addNewNodeInBegin("Chicago");
        obj.addNewNodeInBegin("Houston");

        obj.showData();

        obj.deleteNode();
        obj.deleteNode();
        obj.showData();

        obj.addNewNodeInBegin("Houston");
        obj.showData();
    }
}
