package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.player.GameState

/**
 * Parses a field from a game description
 */
object TetrisParser extends GameParser {
  def update(current: GameState, parts: Array[String]): GameState = {
    new GameState
  }
}
