package RunningMedian

import scala.collection.mutable

class RunningMedian(numbers: Stream[Int]) {

  def balanceHeaps(maxHeap: mutable.PriorityQueue[Int], minHeap: mutable.PriorityQueue[Int]): (mutable.PriorityQueue[Int],mutable.PriorityQueue[Int]) = {
    if(Math.abs(maxHeap.size - minHeap.size) > 1){
      val greaterHeap = if(maxHeap.size > minHeap.size) maxHeap else minHeap
      val lowerHeap = if(maxHeap.size > minHeap.size) minHeap else maxHeap

      val element = greaterHeap.dequeue()
      lowerHeap.enqueue(element)
    }

    (maxHeap,minHeap)
  }

  def calculateMedian(maxHeap: mutable.PriorityQueue[Int], minHeap: mutable.PriorityQueue[Int]): Double = {
    if(maxHeap.size == minHeap.size) return (maxHeap.head + minHeap.head)/2.0

    val greaterHeap = if(maxHeap.size > minHeap.size) maxHeap else minHeap

    greaterHeap.head
  }

  def getRunningMedian: List[Double] = {
    var maxHeap = mutable.PriorityQueue.empty[Int](Ordering[Int]) /* for storing lower numbers */
    var minHeap = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse) /* for storing higher numbers */

    this.numbers.foldLeft(List[Double]())((acc,e) => {
      /* add elements */
      if(maxHeap.isEmpty || maxHeap.head >= e){
        maxHeap.enqueue(e)
      }
      else{
        minHeap.enqueue(e)
      }

      /* rebalance */
      val heaps =  this.balanceHeaps(maxHeap,minHeap)
      maxHeap = heaps._1
      minHeap = heaps._2

      /* calculate median */
      this.calculateMedian(maxHeap,minHeap) :: acc
    }).reverse
  }
}
