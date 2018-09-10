import org.scalatest.{FlatSpec, Matchers}

class SortingRGBTest extends FlatSpec with Matchers {
  "Sorting RGB" should "return empty list for empty input" in {
    val sorting = new SortingRGB.SortingRGB()

    sorting.sort(List[Char]()) should be(List[Char]())
  }

  "Sorting RGB" should "map correctly random values" in {
    val sorting = new SortingRGB.SortingRGB()

    sorting.sort(List[Char]('G', 'B', 'R', 'R', 'B', 'R', 'G')) should be(List[Char]('R', 'R', 'R', 'G', 'G', 'B', 'B'))
  }

}
