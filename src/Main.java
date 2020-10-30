public class Main {

    public static void main(String[] args) {

        myArrayList list = new myArrayList();

        list.display();

        list.insert(new Integer(10));
        list.insert(new Integer(20));
        list.insert(new Integer(30));
        list.insert(new Integer(40));
        list.insert(new Integer(50));

        list.display();

        list.insert(new Integer(70), 7);


        list.display();

        list.delete(new Integer(1000));

        list.display();

        System.out.println(list.search(new Integer(388)));

        list.clear();

        list.display();





    }

}
