package SortingRGB

class SortingRGB {
  def sort(toBeSorted: List[Char]): List[Char] = {
    val charsToRepetition = toBeSorted.foldLeft(collection.mutable.HashMap[Char, Int]())((acc, v) => {
      val current = acc.get(v)
      acc.update(v, current.getOrElse(-1) + 1)
      acc
    })

    var repetitions = -1
    val keysIterator = List[Char]('R', 'G', 'B').iterator
    var currentValue = keysIterator.next()

    toBeSorted.map(_ => {
      if (repetitions == charsToRepetition(currentValue)) {
        currentValue = keysIterator.next()
        repetitions = -1
      }
      repetitions += 1
      currentValue
    }
    )
  }
}
