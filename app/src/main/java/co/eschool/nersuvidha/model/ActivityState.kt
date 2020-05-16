package co.eschool.nersuvidha.model

open class ActivityState

object ProgressState : ActivityState()
object SuccessState : ActivityState()
data class ErrorState(val exception: Exception) : ActivityState()