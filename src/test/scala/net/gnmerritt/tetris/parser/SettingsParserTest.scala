package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.UnitSpec
import net.gnmerritt.tetris.player.GameState

/**
 * Tests that the SettingsParser can create GameSettings objects
 */
class SettingsParserTest extends UnitSpec {
  def line(line: String): GameState = {
    SettingsParser.update(new GameState, line)
  }

  "The settings parser" should "parse field dims" in {
    val height = line("settings field_width 18")
    assert(height.settings.fieldWidth == 18)

    val width = line("settings field_height 30")
    assert(width.settings.fieldHeight == 30)
  }

  it should "parse 'your bot'" in {
    val you = line("settings your_bot player2")
    assert(you.settings.you == "player2")
  }

  it should "parse time per move" in {
    val timePerMove = line("settings time_per_move 5000")
    assert(timePerMove.settings.timePerMove == 5000)
  }
}
