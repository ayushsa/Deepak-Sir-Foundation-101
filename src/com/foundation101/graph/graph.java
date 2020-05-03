package com.foundation101.graph;

import java.util.ArrayList;

class graph
{
//    public  static void longestAndShortestPaths(ArrayList<ArrayList<edge>> graph, int s, int d, boolean[] visited, String x)
//    {
//        if (s == d)
//        {
//            psf = psf + d;
//
//            if (csf < mincost)
//            {
//
//            }
//        }
//
//    }

    static class edge
    {
        int src;  //source
        int nbr;  //neighbour
        int weight; // weight

        edge(int src, int nbr, int weight) {
            // set the values in global variables
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }
    }

    public static void addEdge(ArrayList<ArrayList<edge>> graph, int src, int nbr, int weight)
    {
       graph.get(src).add(new edge(src, nbr, weight));
       graph.get(nbr).add(new edge(nbr, src, weight));
    }

    public static void display(ArrayList<ArrayList<edge>> graph)
    {
        for (int i=0; i < graph.size(); i++)
        {
            //System.out.print( i + " -> ");
            for (int j=0; j < graph.get(i).size() ;j++)
            {
                edge ce = graph.get(i).get(j);

                System.out.print("["+ ce.src + "->" + ce.nbr + " @ " + ce.weight+"],");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // ------Graph construction-----------
        //Step 1
        //It will create a arraylist with storing null in ArrayList <edge>
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();

        //Step 2
        for (int i =0; i<=6 ; i++)
        {
            //Now we have an empty arraylist in front of node arraylist.
            graph.add(new ArrayList<edge>());
        }

        //Step 3
        addEdge(graph, 0,1,10);
        addEdge(graph, 0,3, 40);
        addEdge(graph, 1,2, 10);
        addEdge(graph, 2,3, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4,5,3);
        addEdge(graph, 5,6,3);


        // ------Graph Display-----------
        display(graph);


    }
}

