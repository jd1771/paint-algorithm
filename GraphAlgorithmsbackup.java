/*
	Name: Jas Dhaul
	Student ID: V00939696
*/ 

import java.awt.Color;
import java.util.*;
import java.util.Iterator;

public class GraphAlgorithms{

	/* FloodFillDFS(v, writer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour){
		
		Hashtable<PixelVertex, Integer> dict = new Hashtable<PixelVertex, Integer>();
		FloodFillDFS(v,writer,fillColour,dict);
		
	}
	
	private static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour, Hashtable<PixelVertex, Integer> dict){
	
		dict.put(v,0);
		writer.setPixel(v.getX(), v.getY(), fillColour);
		
		LinkedList<PixelVertex> neighbours = v.getNeighbours();
		Iterator<PixelVertex> i = neighbours.listIterator(); 
		
		while (i.hasNext()){ 
			PixelVertex cur = i.next(); 
            if (!dict.containsKey(cur)){
				
                FloodFillDFS(cur,writer,fillColour,dict);
				
				
				
			}
        } 
		
		
		
	}
	
	
	/* FloodFillBFS(v, writer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, PixelWriter writer, Color fillColour){
		writer.setPixel(v.getX(), v.getY(), fillColour);
		// TODO: implement this method
		LinkedList<PixelVertex> q = new LinkedList<PixelVertex>();
		Hashtable<PixelVertex, Integer> dict = new Hashtable<PixelVertex, Integer>();
		LinkedList<PixelVertex> neighbours = v.getNeighbours();
		PixelVertex first = neighbours.remove();
		q.add(first);
		
		
		while(q.size() != 0 ){
			PixelVertex cur = q.remove();
			LinkedList<PixelVertex> curNeighbours = cur.getNeighbours();
			Iterator<PixelVertex> i = curNeighbours.listIterator(); 
			
			while (i.hasNext()){ 
			PixelVertex next = i.next(); 
            if (!dict.containsKey(next)){
				dict.put(next,1);
				writer.setPixel(next.getX(), next.getY(), fillColour);
				q.add(next);
                
				
				
				
			}
        } 
			
		
		}
		
		
	
	
	}
	
}