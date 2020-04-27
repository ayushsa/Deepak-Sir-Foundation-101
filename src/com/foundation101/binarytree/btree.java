package com.foundation101.binarytree;

import java.util.ArrayList;

public class btree {

    static node root = null;

    static class node
    {
        int data;
        node left;
        node right;

        node(int d)
        {
            this.data = d;
            this.left = null;
            this.right = null;
            //this.left = this.right = null;
        }
    }

    private static void construct(int[] data)
    {
        if (data == null)
        {
            return;
        }
        ArrayList<node> cpList = new ArrayList<>();
        for (int i=0; i < data.length; i++)
        {
            if (data[i] == -1)
            {
                cpList.remove(cpList.size() -1);
            }
            else
            {
                // make a new node first
                node currNode = new node(data[i]);

                if (root == null)
                {
                    root = currNode;
                }
                else
                {
                    node cp = cpList.get(cpList.size() -1);

                    if (cp.left == null)
                    {
                        cp.left = currNode;
                    }
                    else if (cp.right == null)
                    {
                        cp.right = currNode;
                    }
                }
                cpList.add(currNode);
            }
        }
    }

    private static void display(node root)
    {
        if (root == null)
        {
            return;
        }

        if (root.left != null)
        {
            System.out.print(root.left.data +" -> ");
        }

        System.out.print(root.data);

        if (root.right != null)
        {
            System.out.print(" <- "+ root.right.data);
        }
        System.out.println(".");

       if (root.left != null)
       {
           display(root.left);
       }
       if (root.right != null)
       {
           display(root.right);
       }
    }

    private static void preOrderIterativeDisplay(node root)
    {
        if (root == null)
        {
            return;
        }

        ArrayList<node> stack = new ArrayList<>();
        stack.add(root);

        while (stack.size() > 0)
        {
            node currNode = stack.remove(stack.size() -1);
            System.out.print(currNode.data +" ");

            if (currNode.right != null)
            {
                stack.add(currNode.right);
            }

            if (currNode.left != null)
            {
                stack.add(currNode.left);
            }
        }
    }

    public static class diaHelper
    {
        int d = 0; //diameter
        int h = 0; //height
    }

    public static diaHelper diameterByDP(node root)
    {
        if(root == null)
        {
            diaHelper baseAns = new diaHelper();
            return baseAns;
        }

        diaHelper left = diameterByDP(root.left);
        diaHelper right = diameterByDP(root.right);

        diaHelper myAns = new diaHelper();
        myAns.d = Math.max(left.h + right.h + 1 , Math.max(left.d, right.d));
        myAns.h = Math.max(left.h , right.h) +1;

        return myAns;
    }

    static class balanceHelper
    {
        int h = 0;
        boolean b = true;
    }

    public static balanceHelper isBalancedDP(node root)
    {
        if (root == null)
        {
            balanceHelper baseAns = new balanceHelper();
            return baseAns;
        }

        balanceHelper left = isBalancedDP(root.left);
        balanceHelper right = isBalancedDP(root.right);

        balanceHelper myAns = new balanceHelper();
        myAns.b = left.b && right.b && (left.h - right.h >= -1 && left.h - right.h <= 1);
        myAns.h =  Math.max(left.h, right.h);

        return myAns;
    }

    public static void main(String[] args) {
        int[] data = {10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
        construct(data);
        //display(root);
        //preOrderIterativeDisplay(root);

        //diaHelper ans = diameterByDP(root);
        //System.out.print(ans.d);

        System.out.print( isBalancedDP(root).b );
    }
}
