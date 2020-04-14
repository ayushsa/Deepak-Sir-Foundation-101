package com.adobe.binarytree.deepak.genericTree;

import java.util.ArrayList;

public class GenericTree {

    public static node root = null;

    static class node
    {
        int data;
        ArrayList<node> child ;

        node(int d)
        {
            this.data = d;
            this.child = new ArrayList<>();
        }
    }

    private static void treeConstruct(int[] data)
    {
        //CurrentParentList
        ArrayList<node> cpList = new ArrayList<>();

        for (int i=0; i< data.length ; i++)
        {
            if (data[i] == -1)
            {
                cpList.remove(cpList.size() -1);
            }
            else
            {
                node currentNode = new node(data[i]);

                if (root == null)
                {
                    root = currentNode;
                }
                else
                {
                    node cp = cpList.get(cpList.size() -1);
                    cp.child.add(currentNode);
                }
                cpList.add(currentNode);
            }
        }
    }

    private static void display(node root)
    {
        System.out.print(root.data+ "->");
        for(int i=0; i< root.child.size(); i++)
        {
            System.out.print(root.child.get(i).data + ",");
        }

        System.out.println(".");

        for(int i=0; i< root.child.size(); i++)
        {
            display(root.child.get(i));
        }
    }

    private static int size(node root)
    {
        if (root == null)
        {
            return 0;
        }

        int mySize =1;

        for(int i=0; i<root.child.size() ; i++)
        {
            mySize = mySize + size(root.child.get(i));
        }

        return mySize;
    }

    private static int maximum(node root)
    {
        if (root == null)
        {
            return -1;
        }

        int myMax = root.data;

        for (int i=0; i<root.child.size(); i++)
        {
            int childMax = maximum(root.child.get(i));
            if (childMax > myMax)
            {
                myMax = childMax;
            }
        }
        return myMax;
    }

    private static boolean find(node root, int value)
    {
        if (root == null)
        {
            return false;
        }

        if (root.data == value)
        {
            return true;
        }
        else
        {
            for (int i=0; i< root.child.size(); i++)
            {
                boolean ans = find(root.child.get(i), value);

                if(ans == true)
                {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args)
    {
        int [] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};

        treeConstruct(data);
        display(root);

        System.out.println("Size of GenericTree =" + size(root));
        System.out.println("Maximum is " + maximum(root));

        System.out.println("Does data exist -> " + find(root, 90));


    }



}
