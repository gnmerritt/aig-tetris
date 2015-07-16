package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.engine.{OPiece, Piece, Position}

/**
 * Container classes encapsulating the current game state
 */
case class GameState(settings: GameSettings = new GameSettings,
                     round: Round = new Round,
                     you: PlayerState = new PlayerState,
                     opponent: PlayerState = new PlayerState)

case class GameSettings(fieldHeight: Int = 0, fieldWidth: Int = 0,
                        you: String = "", timePerMove: Int = 0)

case class Round(thisPiece: Piece = OPiece, nextPiece: Piece = OPiece,
                 thisPiecePosition: Position = new Position, round: Int = 0)
