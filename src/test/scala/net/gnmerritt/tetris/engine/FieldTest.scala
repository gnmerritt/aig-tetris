package net.gnmerritt.tetris.engine

import net.gnmerritt.tetris.UnitSpec

class FieldTest extends UnitSpec {
  val field = new Field(2, 3)

  "A Field" should "be the right size" in {
    for (x <- 0 until field.width; y <- 0 until field.height) {
      assert(field.at(x, y) == Block.EMPTY)
    }
  }

  it should "throw ArrayIndexOutOfBoundsException for bad access" in {
    intercept[ArrayIndexOutOfBoundsException] {
      field.at(4, 4)
    }
  }

  it should "respect its setters" in {
    field.set(0, 1, Block.PIECE)
    assert(field.at(0, 1) == Block.PIECE)
    val pt = new Point(1,1)
    field.set(pt, Block.FILLED)
    assert(field.at(pt) == Block.FILLED)
  }
}
