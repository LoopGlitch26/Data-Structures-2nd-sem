import java.util.Scanner;

public class DSA_Minor1 {
    public static void main(String args[]) {
        char ch = 'y';
        Scanner sc = new Scanner(System.in);
        int cof,testvar=1;        
        System.out.println("DSA MINOR PROJECT \r\n\r\nName: Bravish Ghosh\r\nRegd No: 1941012333\r\nCSE Sec: Q\r\n");
        System.out.println("Objective: Given two polynomials, represent them by two linked lists and add these lists");

        while (ch == 'y') {
            Poly p1 = new Poly();
            Poly p2 = new Poly();
            Poly p3 = new Poly();
            System.out.println("\r\nFor the First polynomial");
            testvar = 1;
            while (testvar != 0) {
                System.out.println("Enter the coefficent value ");
                cof = sc.nextInt();
                System.out.println("Enter the exponent value ");
                testvar = sc.nextInt();
                p1.ins(cof, testvar);
            }

            System.out.println("\r\nFor the Second polynomial");
            testvar = 1;
            while (testvar != 0) {
                System.out.println("Enter the coefficent value ");
                cof = sc.nextInt();
                System.out.println("Enter the exponent value ");
                testvar = sc.nextInt();
                p2.ins(cof, testvar);
            }
            System.out.print("\r\n1st Polynomial: ");
            p1.display();
            System.out.print("2nd Polynomial: ");
            p2.display();
            p3.add(p1, p2);
            System.out.print("Resultant Polynomial: ");
            p3.display();
            System.out.println("\r\nPress y to continue ");
            ch = sc.next().charAt(0);
        }
    }
}

class Node {
    int temp1, temp2;
    Node next;

    public Node(int var1, int var2) {
        temp2 = var1;
        temp1 = var2;
    }

    public void display() {
        if (temp2 < 0)
            System.out.print(temp2 + "x^" + temp1 + " ");
        else {
            System.out.print(temp2 + "x^" + temp1);
            if (temp1 != 0)
                System.out.print(" + ");
        }
    }
}

class List {
    public Node init, esgo;

    public List() {
        init = null;
        esgo = null;
    }

    public void inslst(int a, int b) {
        Node c = new Node(a, b);
        if (isEmpty())
            init = c;
        else
            esgo.next = c;
        esgo = c;
    }

    public boolean isEmpty() {
        return (init == null);
    }

    public void display() {
        Node fin = init;
        while (fin != null) {
            fin.display();
            fin = fin.next;
        }
        System.out.println();
    }
}

class Poly {
    List l;
    Poly() {
        l = new List();
    }

    public void ins(int x, int y) {
        l.inslst(x, y);
    }

    public void display() {
        l.display();
    }

    public void add(Poly poly1, Poly poly2) {
        int x, y;
        Node curr1 = poly1.l.init;
        Node curr2 = poly2.l.init;

        while (curr1 != null && curr2 != null) {
            if (curr1.temp1 == curr2.temp1) {
                x = curr1.temp2 + curr2.temp2;
                y = curr1.temp1;
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1.temp1 > curr2.temp1) {
                x = curr1.temp2;
                y = curr1.temp1;
                curr1 = curr1.next;
            } else {
                x = curr2.temp2;
                y = curr2.temp1;
                curr2 = curr2.next;
            }
            l.inslst(x, y);
        }

        while (curr1 != null) {
            x = curr1.temp2;
            y = curr1.temp1;
            curr1 = curr1.next;
            l.inslst(x, y);
        }
        while (curr2 != null) {
            x = curr2.temp2;
            y = curr2.temp1;
            curr2 = curr2.next;
            l.inslst(x, y);
        }
    }
}