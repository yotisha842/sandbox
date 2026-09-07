package lumen.agents

import lumen.core.AgentRequest
import lumen.core.AgentResponse
import lumen.core.Subagent

/**
 * ОБРАЗЕЦ готового доменного сабагента.
 * Кинопоисковый сабагент рядом — пустой, его надо сделать «как этот, только про кино».
 */
class MusicSubagent : Subagent {

    override val name: String = "music"

    private val triggers = listOf("трек", "песн", "музык", "альбом", "плейлист")

    override fun canHandle(request: AgentRequest): Boolean {
        val text = request.lastUserText.lowercase()
        return triggers.any { text.contains(it) }
    }

    override fun handle(request: AgentRequest): AgentResponse {
        val query = request.lastUserText.trim()
        return AgentResponse(
            text = "Нашёл для тебя музыку по запросу: \"$query\"",
            handledBy = name,
        )
    }
}
