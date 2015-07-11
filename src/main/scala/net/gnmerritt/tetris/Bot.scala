package net.gnmerritt.tetris

/**
 * Created by nathan on 7/10/15.
 */
object Bot extends App {
  println("Starting up")
  for (ln <- io.Source.stdin.getLines) System.err.println(ln)
}
