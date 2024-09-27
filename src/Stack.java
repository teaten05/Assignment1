import java.util.NoSuchElementException;

public class Stack<Item>{

    private Node<Item> top;
    private int size;

    private static class Node<Item>{

        private Item item;
        private Node<Item> next;

    }

    public Stack() {

        top = null;
        size = 0;

    }

    public boolean isEmpty() {

        return top == null;

    }

    public int size() {

        return size;

    }

    public void push(Item item) {

        Node<Item> newNode = top;
        top = new Node<Item>();
        top.item = item;
        top.next = newNode;
        size++;

    }

    public Item pop() {

        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        Item item = top.item;
        top = top.next;
        size--;
        return item;

    }

    public int getSize(){

        return size;

    }

}
