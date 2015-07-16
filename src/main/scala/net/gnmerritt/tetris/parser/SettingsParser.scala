package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.player.GameState

/**
 * Parses game settings from lines
 */
object SettingsParser extends GameParser {
  def update(curr: GameState, parts: Array[String]): GameState = {
    parts(1) match {
      case "time_per_move" =>
        val time = parts(2).toInt
        return curr.copy(settings = curr.settings.copy(timePerMove = time))
      case "field_width" =>
        val width = parts(2).toInt
        return curr.copy(settings = curr.settings.copy(fieldWidth = width))
      case "field_height" =>
        val height = parts(2).toInt
        return curr.copy(settings = curr.settings.copy(fieldHeight = height))
      case "your_bot" =>
        return curr.copy(settings = curr.settings.copy(you = parts(2)))
      case _ => false
    }
    curr
  }
}
