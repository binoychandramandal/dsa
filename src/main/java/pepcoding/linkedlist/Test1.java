package pepcoding.linkedlist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test1 {

    public static void main(String[] args) throws IOException {
        MyLinkedList l = new MyLinkedList();
//        Files.readAllLines(Paths.get("/Users/binoy.mandal/all/codebase/02-09-2020/DS/src/main/resources/linkedlisttest")).forEach(x->{
//            String[] token = x.split(" ");
//            if(token.length==3){
//                l.addAt(Integer.valueOf(token[1]),Integer.valueOf(token[2]));
//            }else if(token.length==2){
//                l.removeAt(Integer.valueOf(token[1]));
//            }else if(token.length==1){
//                l.dfs();
//                System.out.println();
//            }
//        });
//
        l.addAt(1,1);
        l.addAt(2,2);
        l.addAt(3,3);
        l.display();
        System.out.println("\nRemoved 1");
        l.removeAt(1);
        l.display();
        System.out.println("\nRemoved1");
        l.removeAt(1);
        l.display();
        System.out.println("\nRemoved");
        l.removeAt(1);
        l.display();
        System.out.println("\nadd 1");
        l.addAt(1,1);
        l.display();
    }


    static class Node {
        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    static class MyLinkedList {
        private Node head;
        private Node tail;
        private int size=0;

        public boolean isEmpty() {
            return size == 0;
        }

        public void addFirst(int data) {
            Node temp = new Node(data);
            if (isEmpty()) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        public void addLast(int data) {
            Node temp = new Node(data);
            if (isEmpty()) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public void removeFirst() {
            if (head == null) {
                return;
            }
            if (size==1) {
                head = tail = null;
                size=0;
            } else {
                head = head.next;
                size--;
            }

        }

        public void removeLast() {
            if (head == null) {
                return;
            }
            if (size==1) {
               removeFirst();
            } else {
                Node cur = head;
                for (int i = 0; i <size - 2; i++) {
                    cur = cur.next;
                }
                cur.next = null;
                tail = cur;
                size--;
            }

        }

        public void removeAt(int index) {
            if ( index-1 < 0 || index-1 > size+1) {
                return;
            }
            if (index-1 == 0) {
                removeFirst();
            } else if (size == index-1) {
                removeLast();
            } else {
                Node cur = head;
                for (int i = 0; i < index-2; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                size--;
            }

        }

        public void addAt(int index, int data) {
            if (index < 0 || (size!=0 && index-1 > size)) {
                return;
            }
            if (index-1 == 0) {
                addFirst(data);
            } else if (size == index-1) {
                addLast(data);
            } else {
                Node cur = head;
                for (int i = 0; i <index-2; i++) {
                    cur = cur.next;
                }
                Node newNode = new Node(data);
                newNode.next = cur.next;
                cur.next = newNode;
                size++;
            }

        }

        public void display() {
            Node cur = head;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
        }
    }


}
