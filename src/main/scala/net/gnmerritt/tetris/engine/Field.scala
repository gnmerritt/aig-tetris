package net.gnmerritt.tetris.engine

import net.gnmerritt.tetris.engine.Block.Block

/**
 * Created by nathan on 7/10/15.
 */
class Field(width: Int, height: Int) {
  private val grid = Array.fill[Block](height, width) { Block.EMPTY }

  def row(y: Int): Array[Block] = {
    grid(y)
  }

  def at(x: Int, y: Int): Block = {
    grid(y)(x)
  }
}
