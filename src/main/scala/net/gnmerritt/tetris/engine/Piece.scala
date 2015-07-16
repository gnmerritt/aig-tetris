package net.gnmerritt.tetris.engine

import Block._

/**
 * Types of Tertis pieces
 */
sealed abstract class AbstractPiece
case class Piece(val name: String, val grid: Array[Array[Block]]) extends AbstractPiece {
  override def equals(o: Any): Boolean = o match {
    case that: Piece => this.name == o.asInstanceOf[Piece].name
    case _ => false
  }
}

object IPiece extends Piece(
  "I",
  Array(
    Array(EMPTY, EMPTY, EMPTY, EMPTY),
    Array(PIECE, PIECE, PIECE, PIECE),
    Array(EMPTY, EMPTY, EMPTY, EMPTY),
    Array(EMPTY, EMPTY, EMPTY, EMPTY)
  )
)
object JPiece extends Piece(
  "J",
  Array(
    Array(PIECE, EMPTY, EMPTY),
    Array(PIECE, PIECE, PIECE),
    Array(EMPTY, EMPTY, EMPTY)
  )
)
object LPiece extends Piece(
  "L",
  Array(
    Array(EMPTY, EMPTY, PIECE),
    Array(PIECE, PIECE, PIECE),
    Array(EMPTY, EMPTY, EMPTY)
  )
)
object OPiece extends Piece(
  "O",
  Array(
    Array(PIECE, PIECE),
    Array(PIECE, PIECE)
  )
)
object SPiece extends Piece(
  "S",
  Array(
    Array(EMPTY, PIECE, PIECE),
    Array(PIECE, PIECE, EMPTY),
    Array(EMPTY, EMPTY, EMPTY)
  )
)
object TPiece extends Piece(
  "T",
  Array(
    Array(EMPTY, PIECE, EMPTY),
    Array(PIECE, PIECE, PIECE),
    Array(EMPTY, EMPTY, EMPTY)
  )
)
object ZPiece extends Piece(
  "Z",
  Array(
    Array(PIECE, PIECE, EMPTY),
    Array(EMPTY, PIECE, PIECE),
    Array(EMPTY, EMPTY, EMPTY)
  )
)
