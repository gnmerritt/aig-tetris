package net.gnmerritt.tetris.engine

/**
 * Different types of blocks that can show up on the Field
 */
object Block extends Enumeration {
  type Block = Value
  val EMPTY, PIECE, FILLED, SOLID = Value
}
