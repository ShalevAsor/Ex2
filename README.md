<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up1/oizxyjuxymmw.png" border="0" alt="directed1" /></a>

## What is directed weighted graph? <br>
simple graph made up of vetices and edges. <br>
the difference btween simple unweighted graph to weighted graph <br>
is that each edge on a weight graph has weight wich is a positive number. <br>
the difference between directed graph to simple undirected graph is that <br>
each edge in direceted graph has a direction. <br>
edge between node 1 and node 2 is NOT equals to edge between node 2 to node 1. <br>
you can find much more information about directed graph [here](https://en.wikipedia.org/wiki/Directed_graph) <br>



## The benefits of using my dwg:
- Low Complexity
- Support more than one mil verteices and ten mil edges
- each public class has tests
- support algorithms like Dijkstra's and Bfs

## How it works? 
add node into the graph : addNode(<vertex>) <br>
connect two nodes: connect(<node key>,<node key>) <br>
remove node from the graph: remove(<node key>) <br>
Note: this method will remove all the edges that this node was associate with <br>
remove edge from the graph: removeEdge(<node key>,<node key>) <br>
For more information, i recommend diving into the code, there is explanations attached to each method. <br>
 
 
## DWG_Algo

This class supports few algorithms like bfs and dijkstra's <br>
it allows to save the graph into a json format and load a graph from json format <br>
the bfs algo used to find out if this graph is strongly connected <br>
method : isConnected - return true if this graph is strongly connected <br>
** what is strongly connected graph ? ** <br>
it means there is a path from each node in the graph to every other node <br>
for example: <br>
this graph is **Not strongly connected** <br>
<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up2/lh2ren5dkyjz.png" border="0" alt="dir2" /></a> <br>

this graph is **strongly connected** <br>
<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up3/dmtzaglnzz5j.png" border="0" alt="dir" /></a>

for more information about strongly connected graph : click [here](https://en.wikipedia.org/wiki/Strongly_connected_component) <br>
dijkstra's algorithm used in the methods shortestPathDis and shortestPath

Shortest path distance : this method return the shortest path distance between two nodes in the graph. <br>
the shortest path will be the path with the minimalist edges weight <br>
for example : <br>
<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up2/2mdhzomitddn.png" border="0" alt="shortest" /></a> <br>
the shortest path from node 1 to 2 is : 1---> 3--->2 <br>

Shortest Path works the same way but return the List represents the path from the source to destination. <br>

<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up3/wjhr2y4ywnoz.png" border="0" alt="catch" /></a> <br>

## What is catch the pokemons? 
catch the pokemons is a game that  illustrates the usefulness of the graph and its methods. <br>
**How it works?**
the game has 24 levels [0,23]
Each level has a certain number of agents and Pokemons <br>
The role of agents is to catch the Pokemons <br>
the agent work with next Node algorithm , to find out about this algorithm click [here](https://github.com/ShalevAsor/Ex2/wiki
) or go to the wiki page of the project <br>
<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up3/w1y0uig2wimm.png" border="0" alt="GRAPH2m" /></a> <br>
The red circle is the agent, the purple circle is negative pokemon type <br>
it means that the pokemon is on edge that the src<dest <br>
the green circle is positive pokemon type src>dest <br>

## Operating Instructions 
from  the cmd/terminal use git clone : <br>
```sh
git clone https://github.com/ShalevAsor/Ex2.git
```
or you can download the zip file : <br>
<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up3/iohzho0td5ty.png" border="0" alt="downzip" /></a>

after that you need to include the libraries from the libs directory in the project . <br>
<a href="http://www.siz.co.il/"><img src="http://up419.siz.co.il/up1/rdmiizmzldnb.png" border="0" alt="ps" /></a>

now you can run the project in the classic way from your workspace <br>
or you can use the Ex2.jar file that comes with the project 
and use this command : 
```sh
java -jar Ex2.jar <id> <level>
```
 





