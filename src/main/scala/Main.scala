package me.yevtushok.kpi.y2022.l1

enum BSTree[+A]:
  case Empty
  case Branch(left: BSTree[A], right: BSTree[A], key: A)
  case Leaf(a: A)

object BSTree:
  private def sortList(list: List[Int]): List[Int] = list.sorted

  private def makeBst(list: List[Int], start: Int, end: Int): BSTree[Int] = {
    if (start > end) {
      Empty
    } else if (start == end) {
      Leaf(list(start))
    } else {
      val middle = (start + end) / 2
      Branch(
        makeBst(list, start, middle - 1),
        makeBst(list, middle + 1, end),
        list(middle)
      )
    }
  }

  private def getMinMax(tree: BSTree[Int], isMax: Boolean): Int = {
    tree match
      case Empty => 0
      case Leaf(a) => a
      case Branch(left, right, v) => {
        val borderValue = if (isMax) right else left

        if (borderValue != Empty) {
          getMinMax(borderValue, isMax)
        } else {
          v
        }
      }
  }

  def makeBst(tree: List[Int]): BSTree[Int] = makeBst(sortList(tree), 0, tree.size - 1)

  def min(tree: BSTree[Int]): Int = getMinMax(tree, false)

  def max(tree: BSTree[Int]): Int = getMinMax(tree, true)


  def size(tree: BSTree[Int]): Int = {
    tree match
      case Empty => 0
      case Leaf(a) => 1
      case Branch(left, right, v) => size(left) + size(right) + 1
  }

  def exist(tree: BSTree[Int], value: Int): Boolean = {
    tree match
      case Empty => false
      case Leaf(a) => a == value
      case Branch(left, right, v) => {
        if (v == value) {
          true
        } else if (v > value) {
          exist(left, value)
        } else if (v < value) {
          exist(right, value)
        } else {
          false
        }
      }
  }

  def hasPath(tree: BSTree[Int], path: List[Int], index: Int = 0): Boolean = {
    val pathSize = path.size - 1
    val currentPathValue = path(index)

    tree match
      case Empty => false
      case Leaf(a) => a == currentPathValue && pathSize == index
      case Branch(left, right, v) => {
        if (currentPathValue == v) {

          val newIndex = index + 1
          if (pathSize <= index) true else hasPath(left, path, newIndex) || hasPath(right, path, newIndex)
        } else {
          false
        }
      }
  }
