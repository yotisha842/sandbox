package lumen.agents

import lumen.core.AgentRequest
import lumen.core.AgentResponse
import lumen.core.Subagent

class KinopoiskSubagent : Subagent {

    override val name: String = "kinopoisk"

    private val triggers = listOf("фильм", "кино", "сериал", "режиссёр", "актёр")

    override fun canHandle(request: AgentRequest): Boolean {
        val text = request.lastUserText.lowercase()
        return triggers.any { text.contains(it) }
    }

    override fun handle(request: AgentRequest): AgentResponse {
        val query = request.lastUserText.trim()
        return AgentResponse(
            text = "Нашёл для тебя кино по запросу: \"$query\"",
            handledBy = name,
        )
    }
}