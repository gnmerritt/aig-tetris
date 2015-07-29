package net.gnmerritt.tetris.engine

/**
 * A placement is the combination of a piece, field
 * and position.
 */
case class Placement(piece: Piece, field: Field, position: Position) {

  val isLegal = {
    true
  }

  val isFinal = {
    true
  }

  val isAccessible = {
    true
  }
}
