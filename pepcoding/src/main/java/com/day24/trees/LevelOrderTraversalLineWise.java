package com.day24.trees;

import java.util .*;
import java.io.*;

/**
 * The type of queue you create will help to decide the solution complextiy
 *
 * Queue : ArrayDeque : we require 2 queues OR 1 queue and one stack
 *  : LinkedQueue
 *
 */
public class LevelOrderTraversalLineWise {

    private static class Node {
            int data;
            ArrayList<Node> children = new ArrayList<>();

            public Node(int data){
                data = this.data;
            }

            public Node(){
                data = 0;
            }
        }


        public static void display(Node node) {
            String str = node.data + " -> ";
            for (Node child : node.children) {
                str += child.data + ", ";
            }
            str += ".";
            System.out.println(str);

            for (Node child : node.children) {
                display(child);
            }
        }

        public static Node construct(int[] arr) {
            Node root = null;

            Stack<Node> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1) {
                    st.pop();
                } else {
                    Node t = new Node();
                    t.data = arr[i];

                    if (st.size() > 0) {
                        st.peek().children.add(t);
                    } else {
                        root = t;
                    }

                    st.push(t);
                }
            }

            return root;
        }

        public static int size(Node node) {
            int s = 0;

            for (Node child : node.children) {
                s += size(child);
            }
            s += 1;

            return s;
        }

        public static int max(Node node) {
            int m = Integer.MIN_VALUE;

            for (Node child : node.children) {
                int cm = max(child);
                m = Math.max(m, cm);
            }
            m = Math.max(m, node.data);

            return m;
        }

        public static int height(Node node) {
            int h = -1;

            for (Node child : node.children) {
                int ch = height(child);
                h = Math.max(h, ch);
            }
            h += 1;

            return h;
        }

        public static void traversals(Node node) {
            System.out.println("Node Pre " + node.data);

            for (Node child : node.children) {
                System.out.println("Edge Pre " + node.data + "--" + child.data);
                traversals(child);
                System.out.println("Edge Post " + node.data + "--" + child.data);
            }

            System.out.println("Node Post " + node.data);
        }

        public static void levelOrder(Node node) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);
            Node temp = new Node();
            temp.data = -1;
            queue.add(temp);//Adding "null" as marker will break it as null

            /*while (queue.size() > 0) {
                Node current  = queue.remove();
                if(current.data == -1)
                    System.out.println();
                else
                    System.out.print(current.data+" ");

                for (Node child : current.children) {
                    queue.add(child);
                }
                queue.add(temp);//This fails as after every child we will add the it will fail.
            }*/

        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }
            Node root = construct(arr);
            levelOrder(root);
        }

    /**
     * Approach 2 : Adding tUsing the the size of the array list
     *
     * @param node
     */
    public static void LevelOrderLinewise_Approach2(Node node)
    {
        Queue<Node> que = new ArrayDeque<>();

        que.add(node);

        while(que.size() > 0)
        {
            int size = que.size();

            for(int i = 0 ;i<size;i++)
            {
                Node rem = que.remove();
                System.out.print(rem.data+" ");

                for(Node child : rem.children)
                {
                    que.add(child);
                }
            }

            System.out.println();
        }
    }

    /**
     * Approach 1: using the temp node
     */
    public static void levelOrderLinewise(Node node){
        Queue<Node> que = new ArrayDeque<>();

        que.add(node);
        Node mark = new Node(-1);

        que.add(mark);


        while(que.size() >0)
        {
            Node rem = que.remove();

            if(rem.data != -1)
            {
                System.out.print(rem.data +" ");
                for(Node child : rem.children)
                {
                    que.add(child);
                }
            }

            else{
                if(que.size() > 0)
                {
                    System.out.println();
                    Node m = new Node(-1);
                    que.add(m);
                }

            }
        }
    }


}
