package me.yevtushok.kpi.y2022.l1

import munit.FunSuite

class Test extends FunSuite {
  test("list to bst") {
    val list = List(5, 8, -1, 6, -10, 0, -2)

    val actual = BSTree.makeBst(list)
    val expected = BSTree.Branch(BSTree.Branch(BSTree.Leaf(-10), BSTree.Leaf(-1), -2), BSTree.Branch(BSTree.Leaf(5), BSTree.Leaf(8), 6), 0)
    assertEquals(actual, expected)
  }

  test("empty list to bst") {
    val list = List()

    val actual = BSTree.makeBst(list)
    val expected = BSTree.Empty
    assertEquals(actual, expected)
  }

  test("bst min value") {
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.min(bst)
    val expected = -10

    assertEquals(actual, expected)
  }

  test("bst max value") {
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.max(bst)
    val expected = 8

    assertEquals(actual, expected)
  }

  test("bst size") {
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.size(bst)
    val expected = 7

    assertEquals(actual, expected)
  }

  test("empty bst size") {
    val list = List()
    val bst = BSTree.makeBst(list)

    val actual = BSTree.size(bst)
    val expected = 0

    assertEquals(actual, expected)
  }

  test("single value bst size") {
    val list = List(-5)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.size(bst)
    val expected = 1

    assertEquals(actual, expected)
  }

  test("bst has value") {
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.exist(bst, 5)
    val expected = true

    assertEquals(actual, expected)
  }

  test("bst has no value") {
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.exist(bst, 15)
    val expected = false

    assertEquals(actual, expected)
  }

  test("bst has path") {
    val path = List(0, 6, 8)
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.hasPath(bst, path)
    val expected = true

    assertEquals(actual, expected)
  }

  test("bst has no path") {
    val path = List(0, 6, 4)
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.hasPath(bst, path)
    val expected = false

    assertEquals(actual, expected)
  }

  test("bst has short path") {
    val path = List(0, 6)
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.hasPath(bst, path)
    val expected = true

    assertEquals(actual, expected)
  }

  test("bst has long path") {
    val path = List(0, 6, 8, 15)
    val list = List(5, 8, -1, 6, -10, 0, -2)
    val bst = BSTree.makeBst(list)

    val actual = BSTree.hasPath(bst, path)
    val expected = false

    assertEquals(actual, expected)
  }
}
