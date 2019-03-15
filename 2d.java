import java.io.*;
import java.util.*;

// boolean hasNext()
//     return true if there is another element in the whole structure

// int next()
//     return the value of the next element in the structure

// void remove()
//     remove the last element returned by the iterator.
//     That is, remove the element that the previous next() returned
//     This method can be called only once per call to next(), 
//     otherwise an exception will be thrown.

//     Removes from the underlying collection the last element returned
//     by this iterator (optional operation). This method can be called
//     only once per call to next().
//     The behavior of an iterator is unspecified if the underlying
//     collection is modified while the iteration
//     is in progress in any way other than by calling this method.

// Print
// Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
// Print:  1 2 3 4 5 6 7 8 9 10

// Remove
// Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
// Should result in:  [[],[1,3],[5],[],[],[],[7],[],[9],[],[]]
// Print:  1 3 5 7 9


// List<List<Integer>> input = new ArrayList<>(Arrays.asList(Arrays.asList(), Arrays.asList(1,2,3), Arrays.asList(4,5), Arrays.asList(), Arrays.asList(), Arrays.asList(6), Arrays.asList(7,8), Arrays.asList(), Arrays.asList(9), Arrays.asList(10), Arrays.asList()));


// private static void test1(){
//     Iterator it = new Iterator(getInput());
//     while (it.hasNext())
//       System.out.println(it.next());
//     // 1 2 3 4 5 6 7 8 9 10
//   }

//   private static void test2(){
//     Iterator it = new Iterator(getI 
//     nput());
//     System.out.println(it.next());
//     System.out.println(it.next());
//     System.out.println(it.next());
//     System.out.println(it.next());
//     // 1 2 3 4
//   }

//   private static void test3(){
//     ArrayList<ArrayList<Integer>> input = getInput();
//     Iterator it = new Iterator(input);
//     while (it.hasNext()){
//       if (it.next() % 2 == 0)
//         it.remove();
//     }
//     it = new Iterator(input);
//     while (it.hasNext())
//       System.out.println(it.next());
//     // 1 3 5 7 9
//   }

class Solution {
  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
  
  private static void test1(){
    TwoD it1 = new TwoD(getInput());
    while (it1.hasNext())
      System.out.println(it1.next());
    // 1 2 3 4 5 6 7 8 9 10
  }
  
  private static void test2(){
    TwoD it2 = new TwoD(getInput());
    System.out.println(it2.next());
    System.out.println(it2.next());
    System.out.println(it2.next());
    System.out.println(it2.next());
    // 1 2 3 4
  }
  
  private static void test3(){
    List<List<Integer>> input = getInput();
    TwoD it3 = new TwoD(input);
    // it3.remove();
    // System.out.println(it3.next());
    while (it3.hasNext()){
      if (it3.next() % 2 == 0)
        it3.remove();
    }
    it3 = new TwoD(input);
    while (it3.hasNext())
      System.out.println(it3.next());
    // 1 3 5 7 9
  }
  
  private static List<List<Integer>> getInput(){
    // List<List<Integer>> input = new ArrayList(Arrays.asList(Arrays.asList(), Arrays.asList(1,2,3), Arrays.asList(4,5), Arrays.asList(), Arrays.asList(), Arrays.asList(6), Arrays.asList(7,8), Arrays.asList(), Arrays.asList(9), Arrays.asList(10), Arrays.asList()));
    List<List<Integer>> input = new ArrayList<>();
    input.add(new ArrayList<Integer>(){{}});
    input.add(new ArrayList<Integer>(){{add(1);add(2);add(3);}});
    input.add(new ArrayList<Integer>(){{add(4);add(5);}});
    input.add(new ArrayList<Integer>(){{}});
    input.add(new ArrayList<Integer>(){{}});
    input.add(new ArrayList<Integer>(){{add(6);}});
    input.add(new ArrayList<Integer>(){{add(7);add(8);}});
    input.add(new ArrayList<Integer>(){{}});
    input.add(new ArrayList<Integer>(){{add(9);}});
    input.add(new ArrayList<Integer>(){{add(10);}});
    input.add(new ArrayList<Integer>(){{}});
    
    return input;
  }
}

class TwoD implements Iterator<Integer>{
  private Iterator<List<Integer>> rowIter;
  private Iterator<Integer> colIter;
  
  public TwoD(List<List<Integer>> vec2d){
    rowIter = vec2d.iterator();
    colIter = Collections.emptyIterator();
  }
  
  @Override
  public Integer next(){
    if(!hasNext()) return null;
    return colIter.next();
  }
  
  @Override
  public boolean hasNext(){
    while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext()){
      colIter = rowIter.next().iterator();
    }
    return colIter != null && colIter.hasNext();
  }
  
  @Override
  public void remove(){
    while (colIter == null && rowIter.hasNext()){
      colIter = rowIter.next().iterator();
    }
    if(colIter != null)
      colIter.remove();
  }
  
  
}

/* 

Hello Joey.

 */
