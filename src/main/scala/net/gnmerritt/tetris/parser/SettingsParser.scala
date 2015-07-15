package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.player.GameState

/**
 * Created by nathan on 7/10/15.
 */
object SettingsParser extends GameParser {
  def update(current: GameState, parts: Array[String]): GameState = {
    new GameState
  }
}
