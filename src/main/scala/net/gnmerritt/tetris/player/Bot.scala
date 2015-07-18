package net.gnmerritt.tetris.player

import java.util.Scanner

import net.gnmerritt.tetris.parser.{SettingsParser, UpdateParser}
;

/**
 * Bot runtime - reads line and hands them off to the scanner
 */
object Bot {
  val FAILSAFE = "drop"
  val brain = new Brain
  var gameState = new GameState

  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)
    while (scanner.hasNextLine) {
      val line = scanner.nextLine()
      if (line.length > 0) {
        val (output, err) = handleLine(brain, line)
        System.err.println(err)
        System.out.println(output)
      }
    }
  }

  def handleLine(brain: Brain, line: String) = {
    val parts = line.split(" ")
    try {
      parts(0) match {
        case "settings" =>
          gameState = SettingsParser.update(gameState, parts)
          ((), ())
        case "update" =>
          gameState = UpdateParser.update(gameState, parts)
          ((), ())
        case "action" =>
          val move = brain.getMoves(gameState, parts(2).toInt)
          (move, ())
        case _ =>
          (FAILSAFE, "Couldn't handle line: " + line)
        }
    } catch {
      case e: Exception => (FAILSAFE, e.getMessage)
    }
  }
}
