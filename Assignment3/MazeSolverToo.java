/**
 * ??
 *
 * @author Hamza Bana
 * 250857725
 * CS1027 - Assignment 3
 * @version
 */
 
import java.io.*;

public class MazeSolverToo {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownMazeCharacterException 
	 */
	public static void main (String[] args) throws UnknownMazeCharacterException, IOException {
		try{
			if (args.length<1){
				throw new IllegalArgumentException ("No Maze Provided");
			}
		} catch (Exception e){
			System.out.println("Maze launched");
		}
		Maze m1 = null; //declare and initialize maze object
		try {
			m1 = new Maze (args[0]); //create new maze object, throw exception if file not found for object
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int hexagonOnQueue = 0; //initialize variable hexagonOnQueue to keep count of the number of tiles in the queue
		int steps = 0; //keep count of the steps it takes to find the exit hexagon
		Hexagon start = m1.getStart(); //get the location of the start hexagon on the maze
		LinkedPriorityQueue <Hexagon> priorityQueue = new LinkedPriorityQueue <Hexagon>(); //create a new LinkedPriorityQueue object with type Hexagon object
		start.setStarted(); //update the start tile
		m1.repaint(); //repaint the maze to show color changes of the hexagon tiles
		priorityQueue.enqueue(start); //enqueue the start tile
//		start.setEnqueued();
//		m1.repaint();
		int exitFound = 0; //initialize variable to mark the exit of the program
		hexagonOnQueue ++; //update the number of hexagons in the queue
		while (!priorityQueue.isEmpty()) {
			/**
		}
			Hexagon newTile = priorityQueue.first();
			//System.out.println(priorityQueue.size());
			priorityQueue.dequeue();
			newTile.setEnqueued();
			//System.out.println(priorityQueue.size());
			m1.repaint();
			hexagonOnQueue --;
			steps ++;
			**/
			//System.out.println(priorityQueue.size());
			
			Hexagon newTile = priorityQueue.first(); //create a variable newTile and set it as the first tile from the maze
			priorityQueue.dequeue(); //dequeue first tile from the queuue
			newTile.setDequeued(); //update the tile as dequeued and its color
			hexagonOnQueue--; //update the number of hexagons on the stack. Subtract one because of the dequeue
			m1.repaint(); //repaint the maze
//			if (newTile.isEnd()) {
//				newTile.setFinished();
//				m1.repaint();
//				System.out.println("End found in this many steps: " + steps);
//				System.out.println("Hexagons on queue: " + hexagonOnQueue);
//				System.exit(0);
//			}
//			else {
			//Hexagon newTile = priorityQueue.first();
			//priorityQueue.enqueue(newTile);
			
			//System.out.println(priorityQueue.size());
			//priorityQueue.dequeue();
			//newTile.setDequeued();
			//System.out.println(priorityQueue.size());
			//m1.repaint();
			//hexagonOnQueue --;
			//steps ++;
			for (int i = 0; i < 6; i ++) {//start loop to get the neighbors of the hexagons on each side
				Hexagon neighbor = newTile.getNeighbour(i);//initialize variable neighbor of type hexagon and set it as the neighboring hexagons
				//System.out.println(priorityQueue.size());

				//priorityQueue.enqueue(neighbor);
				//neighbor.setEnqueued();
				//newTile.setDequeued();
				//m1.repaint();
				if (neighbor != null) { //if neighbor is not null, enter the loop
					if (neighbor.isWall() || neighbor.isDequeued()) { //check if neighbor is wall or it is already dequeued
						continue; //if above is true, continue
					}
//					if (neighbor.isEnqueued()) {
//						neighbor.setCurrent();
//						m1.repaint();
//					}
					if (!neighbor.isEnqueued()) { //if neighbor hexagon is not enqueued, do the following
//						if (neighbor.distanceToEnd(m1) < (priorityQueue.first()).distanceToEnd(m1)) {
//							priorityQueue.enqueue(neighbor, 1);
//						}
//						else
//							priorityQueue.enqueue(neighbor);
						priorityQueue.enqueue(neighbor,neighbor.distanceToEnd(m1)); //enqueue the tile based on the heuristic
						hexagonOnQueue++; //update the counter of hexagon on queue
						neighbor.setEnqueued(); //set neighbor as enqueued
						m1.repaint();//update the maze color
						steps++;//update the steps counter
//						neighbor.setCurrent();
//						m1.repaint();
					}
					if (neighbor.isEnd()) { //check if neighbor hexagon is the end
						//neighbor.setDequeued();
						//m1.repaint();
						neighbor.setFinished(); //set it as finished if it is the end
						m1.repaint();//repaint the maze
						hexagonOnQueue--;//update hexagon on queue counter
						System.out.println("End found in this many steps: " + steps); 
						System.out.println("Hexagons on queue: " + hexagonOnQueue);
						exitFound=1; //update variable exit found
						break;//break out of loop
						//System.exit(0);
					}
				}
//				else
//					continue;
			}if(exitFound==1) { //enter the loop once thee exit found variable has been updated
				break;//break out of program
			}
//			else{
//				System.out.println("No Exit Found");
//				System.out.println("Steps taken: " + steps);
//				System.out.println("Hexagons in queue: " + hexagonOnQueue);
//			}
			
			/**
			if (newTile.isEnd()) {
				System.out.println("This is the end");
				System.out.println("Steps to reach the end: " + steps);
				System.out.println("Hexagon on stack: " + hexagonOnQueue);
				System.exit(0);
			}
			else {
				for (int i = 0; i < 6; i ++) {
					Hexagon neighbor = newTile.getNeighbour(i);
					priorityQueue.enqueue(neighbor);
					System.out.println(priorityQueue.size());
					if (neighbor != null) {
						if (neighbor.isWall() || neighbor.isDequeued() || neighbor.isEnqueued()) {
							continue;
						}
						if (neighbor.isEnd()) {
							m1.repaint();
							System.out.println("Steps to find the end: " + steps);
							System.exit(0);
						}
						else {
							if (neighbor.distanceToEnd(m1) < (priorityQueue.first()).distanceToEnd(m1)) {
								priorityQueue.enqueue(neighbor, 1);
							}
							else {
								priorityQueue.enqueue(neighbor);
							}
							neighbor.setEnqueued();
							m1.repaint();
							hexagonOnQueue++;
							steps++;
						}
					}
					else
						continue;
				}
			}
		}
		**/
		}
		if (exitFound == 0){ //if exit found variable is 0, that means that loop doesnt have exit. print the following statements
			System.out.println("No Exit Found");
			System.out.println("Steps taken: " + steps);
			System.out.println("Hexagons in queue: " + hexagonOnQueue);
		}
	}
}