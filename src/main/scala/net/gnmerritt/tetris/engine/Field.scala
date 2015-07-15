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
    for (y <- 0 until height) yield at(x, y)
  }

  def at(x: Int, y: Int): Block = {
    grid(y)(x)
  }

  def at(pt: Position): Block = {
    at(pt.x, pt.y)
  }

  def set(x: Int, y: Int, block: Block): Unit = {
    grid(y)(x) = block
  }

  def set(pt: Position, block: Block): Unit = {
    set(pt.x, pt.y, block)
  }
}
