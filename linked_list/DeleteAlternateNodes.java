class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        Node<Integer> curr = head;
        while(curr != null && curr.next != null){
            curr.next = curr.next.next;
            curr = curr.next;
        }
    }
}
