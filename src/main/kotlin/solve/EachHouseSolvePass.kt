package solve

import model.board.Board
import model.board.House
import model.board.HouseType
import solve.engine.SolveStep

abstract class EachHouseSolvePass(protected val type: HouseType, initialBoard: Board) :
  SolvePassBase(initialBoard) {
  final override fun executeInternal(): SolveStep.Change.Cells {
    prepare()

    val transformedHouse = initialBoard.houses(type).map(this::transformHouse)

    return SolveStep.Change.Cells(
      Board.fromHouse(type, transformedHouse),
      initialBoard)
  }

  protected open fun prepare() {
    //do nothing
  }

  protected abstract fun transformHouse(house: House): House
}
