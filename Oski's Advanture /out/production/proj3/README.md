# Build Your Own World Design Document

**Partner 1:** Grace Zhang 

**Partner 2:** Leah Xue 

## Classes and Data Structures

Reference: http://journal.stuffwithstuff.com/2014/12/21/rooms-and-mazes/
https://zhuanlan.zhihu.com/p/30724817

1. Room class - define basic room, room has to be open room 

2. World class 
- use Union Find to connect rooms 
- store rooms in a linkedlist 

3. Position Class: x, y position 

4. Avatar Class, ending class, room class

## Algorithms
- use connect method to connect random rooms based on their position (from lower position to higher position)
- add walls in the process of creating rooms & creating hallways 
- generate a random door in the walls  
- background story 

-when you finish a project, you get 20 points - once you pass 60, game end - you win 
-after you finish one project, a following bosses will chase you; once you are caught, lose 20 points 
-lower than 0 points - end game lose 
-play till the game end, <60 -end game lose 
-redemption project (easter egg) allows you to regain 20 points 
-time to be decided 

6 Point: 
- Create a system for “encounters”, where a new interface appears when the avatar interacts with entities in the world, returning the avatar to the original interface when the encounter ends (e.g. Pokémon)

(each question is worthy 20 points )
four different endings:
not get 60 points within 5 questions: YouLose
get 60 points:
not choose to save princess: 
good key: good ending
bad key: bad ending
choose to save princess:
success:
good key: extra ending
bad key: bad ending
fail:
YouLose

for subworld -- use random to generate a new random Random random is updated each time; 
when trying to get the key: instruction -- are you sure, then give you a second chance to choose 


## Persistence
keep track of all you moves
keep track of whether the question is answered correctly (your score)

## extra credit
1. background story
2. four endings
3. good key/ bad key -- you don't know which one to choose (give you instructions to think twice)
4. option to rescue the princess for the extra ending