package lumen.agents

import lumen.core.AgentRequest
import lumen.core.AgentResponse
import lumen.core.Subagent

/**
 * TODO(задание): в нём сейчас вообще ничего нет.
 * Рядом лежит MusicSubagent как образец — сделай так же, только про кино.
 */
class KinopoiskSubagent : Subagent {

    override val name: String = "kinopoisk"

    override fun canHandle(request: AgentRequest): Boolean = false

    override fun handle(request: AgentRequest): AgentResponse =
        TODO("не реализовано")
}
