package net.gnmerritt.tetris.engine

import net.gnmerritt.tetris.engine.Block.Block

/**
 * Playing field for a game of tetris
 */
class Field(val width: Int, val height: Int) {
  private val grid = Array.fill[Block](height, width) { Block.EMPTY }

  def row(y: Int): Array[Block] = {
    grid(y)
  }

  def at(x: Int, y: Int): Block = {
    grid(y)(x)
  }

  def at(pt: Point): Block = {
    at(pt.x, pt.y)
  }

  def set(x: Int, y: Int, block: Block): Unit = {
    grid(y)(x) = block
  }

  def set(pt: Point, block: Block): Unit = {
    set(pt.x, pt.y, block)
  }
}
