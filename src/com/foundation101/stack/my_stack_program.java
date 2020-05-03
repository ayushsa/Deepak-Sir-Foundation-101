package com.foundation101.stack;

import java.util.Stack;

class my_stack_program
{
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.push(10);
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.push(20);
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.push(30);
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.push(40);
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.pop();
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.pop();
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.pop();
        System.out.println(st+"->"+st.peek()+" "+st.size());
        st.pop();
        if (st.isEmpty())
        {
            System.out.println(st+"-> Stack is empty "+st.size());
        }
    }
}