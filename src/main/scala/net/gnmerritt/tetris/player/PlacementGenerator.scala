package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.engine.{Field, Piece, Placement, Position}

/**
 * Given a board and piece, generate a sequence of placements
 */
class PlacementGenerator(field: Field, piece: Piece) {
  def allLegal = {
    this.all.filter(_.isLegal)
  }

  def all = {
    for (x <- 0 until field.width; y <- 0 until field.height)
      yield new Placement(piece, field, Position(x, y))
  }
}
