package net.gnmerritt.tetris.player

/**
 * Created by nathan on 7/10/15.
 */
object Bot {
  def main(args: Array[String]) {
    System.err.println("Starting up")
    for (ln <- io.Source.stdin.getLines) System.err.println(ln)
  }
}
