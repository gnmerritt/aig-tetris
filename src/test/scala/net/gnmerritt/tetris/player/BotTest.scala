package net.gnmerritt.tetris.player

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import net.gnmerritt.tetris.UnitSpec

/**
 * Test bot IO and printing
 */
class BotTest extends UnitSpec {
  val defaultBrain = new Brain

  "The line handler" should "handle bad input gracefully" in {
    val (out, err) = Bot.handleLine(defaultBrain, "adfkljalksdfj")
    assert(out == Some("drop"))
    assert(err.get.startsWith("Couldn't handle line"))
  }

  it should "return 'drop' as a failsafe" in {
    val (out, err) = Bot.handleLine(defaultBrain, "action moves 1000")
    assert(out == Some("drop"))
    assert(err == None)
  }

  it should "return 'drop' after exceptions" in {
    val brain = new Brain {
      override def getMoves(state: GameState, time: Int): String = {
        throw new Exception("boom")
      }
    }
    val (out, err) = Bot.handleLine(brain, "action moves 50")
    assert(out == Some("drop"))
    assert(err == Some("boom"))
  }

  it should "handle settings lines" in {
    val (out, err) = Bot.handleLine(defaultBrain, "settings your_bot player1")
    assert(Bot.gameState.settings.you == "player1")
    assert(out == None)
    assert(err == None)
  }

  it should "handle update lines" in {
    val (out, err) = Bot.handleLine(defaultBrain, "update game round 2")
    assert(Bot.gameState.round.roundNum == 2)
    assert(out == None)
    assert(err == None)
  }

  "The main loop" should "read from the provided streams" in {
    val outputStream = new ByteArrayOutputStream()
    val input = new ByteArrayInputStream("action moves 1000".getBytes())
    Bot.mainLoop(input, outputStream, outputStream)
    assert(outputStream.toString() == "drop")
  }

  "Say function" should "write to the correct place" in {
    val testLine = "this line should come back to us"
    val outputStream = new ByteArrayOutputStream()
    Bot.say(Option(testLine), outputStream)
    assert(outputStream.toString == testLine)
  }
}
