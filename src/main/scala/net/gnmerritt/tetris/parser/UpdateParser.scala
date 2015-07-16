package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.engine.{Position, Piece}
import net.gnmerritt.tetris.player.GameState

/**
 * Parses out round-by-round information
 */
object UpdateParser extends GameParser {
  def update(curr: GameState, parts: Array[String]): GameState = {
    parts(2) match {
      case "round" =>
        val round = parts(3).toInt
        return curr.copy(round = curr.round.copy(roundNum = round))
      case "this_piece_type" =>
        Piece.bySymbol(parts(3)) match {
          case Some(piece) => return curr.copy(round = curr.round.copy(thisPiece = piece))
          case None => false
        }
      case "this_piece_position" =>
        val pos = parts(3).split(",")
        if (pos.length == 2) {
          val newPos = new Position(pos(0).toInt, pos(1).toInt)
          return curr.copy(round = curr.round.copy(thisPiecePosition = newPos))
        }
      case "next_piece_type" =>
        Piece.bySymbol(parts(3)) match {
          case Some(piece) => return curr.copy(round = curr.round.copy(nextPiece = piece))
          case None => false
        }
      case _ => false
    }
    curr
  }
}
