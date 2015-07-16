package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.player.GameState

/**
 * Handles a line of information and updates the game state
 */
trait GameParser {
  def update(current: GameState, line: String): GameState = {
    update(current, line.split(" "))
  }
  def update(current: GameState, parts: Array[String]): GameState
}
