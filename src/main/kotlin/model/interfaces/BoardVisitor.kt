package model.interfaces

import model.ui.Cell

interface BoardVisitor {
  fun visitCells(visitor: (Board, Args) -> Board): Board

  data class Args(
    val cell: Cell,
    val index: Int,
    val row: NumbersSet,
    val col: NumbersSet,
    val house: NumbersSet,
  )
}