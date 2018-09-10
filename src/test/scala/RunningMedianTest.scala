import org.scalatest.{FlatSpec, Matchers}

class RunningMedianTest extends FlatSpec with Matchers{

  "Running median" should "compute values" in {
    val runningMedian = new RunningMedian.RunningMedian(List[Int](2, 1, 5, 7, 2, 0, 5).toStream)

    runningMedian.getRunningMedian should be (List[Double](2,1.5,2,3.5,2,2,2))
  }

  "Running median" should "return empty list for empty input" in {
    val runningMedian = new RunningMedian.RunningMedian(List[Int]().toStream)

    runningMedian.getRunningMedian should be (List[Double]())
  }
}
