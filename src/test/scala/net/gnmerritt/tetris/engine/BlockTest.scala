package net.gnmerritt.tetris.engine

import net.gnmerritt.tetris.UnitSpec

/**
 * Make sure I understand how enums work...
 */
class BlockTest extends UnitSpec {
  "Blocks" should "create from index" in {
    assert(Block(0) == Block.EMPTY)
    assert(Block(1) == Block.PIECE)
    assert(Block(3) == Block.SOLID)
  }
}
