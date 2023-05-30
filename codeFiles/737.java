public class DynamicStack { static  class Node{    int data;    Node next;    Node(int d){        data = d;        next = null;    }}static class Stack{    public static  Node topHead;    public static boolean isEmpty(){        return topHead == null;    }    public static void push(int data){                Node newnode = new Node(data);        if(isEmpty()){            topHead = newnode;            return;        }                newnode.next = topHead;        topHead = newnode;    }    public static int pop(){        if (isEmpty()) {            return -1;        }        int data = topHead.data;        topHead = topHead.next;        return data;    }        public static int peek(){        if (isEmpty()) {            return -1;        }                return topHead.data;    }}public static void main(String[] args) {    Stack st = new Stack();    st.push(1);    st.push(2);    st.push(3);    st.push(4);    while (!st.isEmpty()) {        System.out.println(st.peek());        st.pop();    }  }}