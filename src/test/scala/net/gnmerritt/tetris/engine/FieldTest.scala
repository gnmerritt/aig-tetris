package net.gnmerritt.tetris.engine

import net.gnmerritt.tetris.UnitSpec

class FieldTest extends UnitSpec {
  val field = new Field(2, 3)

  "A Field" should "be the right size" in {
    for (x <- 0 until field.width; y <- 0 until field.height) {
      assert(field(x, y) == Block.EMPTY)
    }
  }

  it should "throw ArrayIndexOutOfBoundsException for bad access" in {
    intercept[ArrayIndexOutOfBoundsException] {
      field(4, 4)
    }
  }

  it should "respect its setters" in {
    field(0, 1) = Block.PIECE
    assert(field(0, 1) == Block.PIECE)
    val pt = new Position(1,1)
    field(pt) = Block.FILLED
    assert(field(pt) == Block.FILLED)
  }

  val narrow = new Field(1, 3)

  it should "expose row & column" in {
    narrow(0, 2) = Block.PIECE
    val column = narrow.column(0)
    assert(column.length == narrow.height)
    assert(column(2) == Block.PIECE)

    val row = narrow.row(2)
    assert(row.length == narrow.width)
    assert(row(0) == Block.PIECE)
  }

  "Two empty fields" should "be equal" in {
    assert(new Field(0, 0) == new Field(0, 0))
  }

  "Two dissimilar fields" should "not be equal" in {
    assert(new Field(1, 1) != new Field(2, 1))
  }
}
