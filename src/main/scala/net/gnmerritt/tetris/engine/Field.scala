package net.gnmerritt.tetris.engine

import net.gnmerritt.tetris.engine.Block.Block

/**
 * Playing field for a game of tetris
 */
class Field(val width: Int, val height: Int) {
  private val grid = Array.fill[Block](height, width) { Block.EMPTY }

  def row(y: Int): Seq[Block] = {
    grid(y)
  }

  def column(x: Int): Seq[Block] = {
    for (y <- 0 until height) yield apply(x, y)
  }

  def apply(x: Int, y: Int): Block = grid(y)(x)

  def apply(pt: Position): Block = apply(pt.x, pt.y)

  def update(x: Int, y: Int, block: Block): Unit = {
    grid(y)(x) = block
  }

  def update(pt: Position, block: Block): Unit = {
    update(pt.x, pt.y, block)
  }

  // TODO: this isn't right, but ok for now
  override def equals(other: Any): Boolean = other match {
    case that: Field => {
      val otherField = other.asInstanceOf[Field]
      this.height == otherField.height &&
      this.width == otherField.width
    }
    case _ => false
  }
}
