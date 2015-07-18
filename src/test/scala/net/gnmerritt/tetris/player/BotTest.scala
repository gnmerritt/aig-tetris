package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.UnitSpec

/**
 * Test bot IO and printing
 */
class BotTest extends UnitSpec {
  val defaultBrain = new Brain

  "The IO Bot" should "handle bad input gracefully" in {
    val (out, err) = Bot.handleLine(defaultBrain, "adfkljalksdfj")
    assert(out == "drop")
    assert(err.toString().startsWith("Couldn't handle line"))
  }

  it should "return 'drop' as a failsafe" in {
    val (out, err) = Bot.handleLine(defaultBrain, "action moves 1000")
    assert(out == "drop")
    assert(err == ())
  }

  it should "return 'drop' after exceptions" in {
    val brain = new Brain {
      override def getMoves(state: GameState, time: Int): String = {
        throw new Exception("boom")
      }
    }
    val (out, err) = Bot.handleLine(brain, "action moves 50")
    assert(out == "drop")
    assert(err == "boom")
  }

  it should "handle settings lines" in {
    val (out, err) = Bot.handleLine(defaultBrain, "settings your_bot player1")
    assert(Bot.gameState.settings.you == "player1")
    assert(out == ())
    assert(err == ())
  }

  it should "handle update lines" in {
    val (out, err) = Bot.handleLine(defaultBrain, "update game round 2")
    assert(Bot.gameState.round.roundNum == 2)
    assert(out == ())
    assert(err == ())
  }
}
