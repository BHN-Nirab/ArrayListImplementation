import javax.xml.crypto.Data;
import java.util.ArrayList;

public class myArrayList {

    class DataField{

        Object data;
        DataField next;
    }

    DataField root = null;


    public void insert(Object data)
    {
        if(root == null)
        {
            DataField tmp = new DataField();
            tmp.data = data;
            tmp.next = null;

            root = tmp;
        }

        else
        {
            DataField curr = new DataField();
            curr.data = data;
            curr.next = null;

            DataField tmp = root;

            while(tmp.next!=null) tmp = tmp.next;

            tmp.next = curr;

        }
    }

    public void insert(Object data, int index)
    {
        int currIndex = 0;

        DataField newData = new DataField();
        newData.data = data;
        newData.next = null;

        DataField tmp = root;
        DataField parent = root;

        while(tmp!=null)
        {
            if(currIndex == index) break;
            parent = tmp;
            tmp = tmp.next;
            currIndex++;
            if(currIndex == index) break;

        }

        if(parent == root)
        {
            root = newData;
            newData.next = parent;
            return;
        }

        parent.next = newData;
        newData.next = tmp;

    }

    public void delete(Object data)
    {
        DataField tmp = root;
        DataField parent = root;

        while(tmp!=null)
        {
            if(tmp.data.toString().equals(data.toString())) break;

            parent = tmp;
            tmp = tmp.next;

            if(tmp == null) break;

            if(tmp.data.toString().equals(data.toString())) break;
        }

        if(tmp == null)
        {
            System.out.println("Object not found!");
            return;
        }

        else if(tmp == root)
        {
            root = tmp.next;
            tmp.next = null;

            return;
        }

        parent.next = tmp.next;
        tmp.next = null;

    }

    public void clear()
    {
        root = null;
    }

    public boolean search(Object data)
    {
        DataField tmp = root;

        if(tmp == null) return false;

        while(tmp!=null)
        {
            if(tmp.data.toString().equals(data.toString())) return true;
            else tmp = tmp.next;
        }

        return false;
    }

    public void display()
    {
        DataField tmp = root;

        if(tmp == null)
        {
            System.out.println("List is empty!");
            return;
        }

        while(tmp!=null)
        {
            System.out.print(tmp.data.toString() + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }



}
