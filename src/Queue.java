import java.util.NoSuchElementException;

public class Queue <Item> {

    //for the queue
    private Queue.Node<Item> top;
    private Queue.Node<Item> bottom;
    private int size;


    Stack <Item> errorLog;

    public Queue() {

        top = null;
        bottom = null;
        errorLog = null;
        size = 0;

    }

    private static class Node<Item> {

        private Item item;
        private Queue.Node<Item> next;

    }

    public void enqueue(Item item) {

        Node<Item> newNode = bottom;
        bottom = new Node<Item>();
        bottom.item = item;
        bottom.next = null;
        if (isEmpty()){ top = bottom;}
        else {newNode.next = bottom; size++;}

    }

    public Item dequeue(){

        if(isEmpty()) throw new NoSuchElementException("Queue overflow.");
        Item item = top.item;

        top = top.next;
        size--;
        if (isEmpty()) bottom = null;
        return item;

    }

    public boolean isEmpty(){

        return top == null;

    }

    public int size(){

        return size;

    }
}
