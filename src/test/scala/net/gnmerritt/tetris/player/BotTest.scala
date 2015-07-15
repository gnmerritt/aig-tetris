package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.UnitSpec

/**
 * Test bot IO and printing
 */
class BotTest extends UnitSpec {
  val defaultBrain = new Brain

  "The IO Bot" should "handle bad input gracefully" in {
    val (out, err) = Bot.handleLine(defaultBrain, "adfkljalksdfj")
    assert(out == ())
    assert(err.toString().startsWith("Couldn't handle line"))
  }

  it should "return 'drop' as a failsave" in {
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
}
