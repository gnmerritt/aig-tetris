package net.gnmerritt.tetris.player

import java.io.{InputStream, OutputStream}
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
    mainLoop(System.in, System.out, System.err)
  }

  def mainLoop(input: InputStream, outputStream: OutputStream, logStream: OutputStream) {
    val scanner = new Scanner(input)
    while (scanner.hasNextLine) {
      val line = scanner.nextLine()
      if (line.length > 0) {
        val (output, err) = handleLine(brain, line)
        say(err, logStream)
        say(output, outputStream)
      }
    }
  }

  def say(line: Option[String], output: OutputStream) {
    line.foreach(l => output.write(l.getBytes()))
  }

  def handleLine(brain: Brain, line: String) = {
    val parts = line.split(" ")
    try {
      parts(0) match {
        case "settings" =>
          gameState = SettingsParser.update(gameState, parts)
          (None, None)
        case "update" =>
          gameState = UpdateParser.update(gameState, parts)
          (None, None)
        case "action" =>
          val moves = brain.getMoves(gameState, parts(2).toInt)
          (Some(moves), None)
        case _ =>
          (Some(FAILSAFE), Some("Couldn't handle line: " + line))
        }
    } catch {
      case e: Exception => (Some(FAILSAFE), Some(e.getMessage))
    }
  }
}
