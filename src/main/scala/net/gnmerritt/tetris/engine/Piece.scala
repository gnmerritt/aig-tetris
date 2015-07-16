package net.gnmerritt.tetris.engine

import Block._
import enumeratum._

/**
 * Types of Tertis pieces
 */
sealed trait Piece extends EnumEntry {
  def name: String
  def grid: Array[Array[Block]]

  override def equals(o: Any): Boolean = o match {
    case that: Piece => this.name == o.asInstanceOf[Piece].name
    case _ => false
  }
}

object Piece extends Enum[Piece] {

  val values = findValues

  def bySymbol(symbol: String): Option[Piece] = {
    values.find((p: Piece) => p.name == symbol)
  }

  case object IPiece extends Piece {
    override def name: String = "I"
    override def grid: Array[Array[Block]] = Array(
      Array(EMPTY, EMPTY, EMPTY, EMPTY),
      Array(PIECE, PIECE, PIECE, PIECE),
      Array(EMPTY, EMPTY, EMPTY, EMPTY),
      Array(EMPTY, EMPTY, EMPTY, EMPTY)
    )
  }

  case object JPiece extends Piece {
    override def name: String = "J"
    override def grid: Array[Array[Block]] = Array(
      Array(PIECE, EMPTY, EMPTY),
      Array(PIECE, PIECE, PIECE),
      Array(EMPTY, EMPTY, EMPTY)
    )
  }

  case object LPiece extends Piece {
    override def name: String = "L"
    override def grid: Array[Array[Block]] = Array(
      Array(EMPTY, EMPTY, PIECE),
      Array(PIECE, PIECE, PIECE),
      Array(EMPTY, EMPTY, EMPTY)
    )
  }

  case object OPiece extends Piece {
    override def name: String = "O"
    override def grid: Array[Array[Block]] = Array(
      Array(PIECE, PIECE),
      Array(PIECE, PIECE)
    )
  }

  case object SPiece extends Piece {
    override def name: String = "S"
    override def grid: Array[Array[Block]] = Array(
      Array(EMPTY, PIECE, PIECE),
      Array(PIECE, PIECE, EMPTY),
      Array(EMPTY, EMPTY, EMPTY)
    )
  }

  case object TPiece extends Piece {
    override def name: String = "T"
    override def grid: Array[Array[Block]] = Array(
      Array(EMPTY, PIECE, EMPTY),
      Array(PIECE, PIECE, PIECE),
      Array(EMPTY, EMPTY, EMPTY)
    )
  }

  case object ZPiece extends Piece {
    override def name: String = "Z"
    override def grid: Array[Array[Block]] = Array(
      Array(PIECE, PIECE, EMPTY),
      Array(EMPTY, PIECE, PIECE),
      Array(EMPTY, EMPTY, EMPTY)
    )
  }
}
