public class Pilha implements PilhaInterface{

    private Node top;
    private Integer size;

    public Pilha() {
        this.top = null;
        this.size = 0;
    }

    private class Node {

        public Object value;
        public Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }

    }

    public void push(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("");
        }

        Node newTop = new Node(object);
        newTop.next = top;
        top = newTop;
        size++;
    }

    public Object pop() {
        if (top == null) {
            throw new IllegalStateException("A pilha esta vazia!");
        }
        Object objectTop = top.value;
        this.top = top.next;
        this.size--;
        return objectTop;
    }

    @Override
    public Integer size() {
        return size;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push("A");
        pilha.push("B");

        System.out.println("Pop: " + pilha.pop());
        System.out.println("Pop: " + pilha.pop());
    }

}
