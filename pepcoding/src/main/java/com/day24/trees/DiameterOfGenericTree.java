package com.day24.trees;

import java.io.*;
import java.util.*;

public class DiameterOfGenericTree {
        private static class Node {
            int data;
            ArrayList<Node> children = new ArrayList<>();
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



        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }

            Node root = construct(arr);
            int ans = getDiameterOfGT(root);
            System.out.println(diameter);

        }
        static int diameter = 0;
        public static int getDiameterOfGT(Node node){
             int h = -1;
             int smh = -1;

            for(Node child : node.children){
                int height = getDiameterOfGT(child);
                if(height > h){
                    smh = h;
                    h = height;
                }else if(height > smh){
                    smh = h;
                }
            }
            if(h+smh+2 > diameter ){
                diameter = h+smh+2;
            }
            h = h+1;
            return h;
        }
    }
