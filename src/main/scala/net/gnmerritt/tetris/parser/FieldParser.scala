package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.engine.{Block, Field}
import net.gnmerritt.tetris.player.GameState

/**
 * Parses a field from a game description
 */
object FieldParser extends GameParser {
  def update(curr: GameState, parts: Array[String]): GameState = {
    val player = parts(1)
    val field = parseField(parts(3))
    if (player == curr.settings.you) {
      curr.copy(you = curr.you.copy(field = field))
    } else {
      curr.copy(opponent = curr.opponent.copy(field = field))
    }
  }

  def parseField(fieldStr: String): Field = {
    val rows = fieldStr.split(";")
    val cols = rows(0).split(",")
    parseField(cols.length, rows.length, fieldStr)
  }

  def parseField(width: Int, height: Int, fieldStr: String): Field = {
    val field = new Field(width, height)
    for ((row, y) <- fieldStr.split(";").zipWithIndex) {
      for ((col, x) <- row.split(",").zipWithIndex) {
        val value = col.toInt
        field(x, y) = Block(value)
      }
    }
    field
  }
}
