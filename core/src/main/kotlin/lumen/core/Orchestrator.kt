package lumen.core

/**
 * Простейшая оркестрация: выбирает первого подходящего сабагента,
 * иначе отвечает фолбэком.
 */
class Orchestrator(
    private val subagents: List<Subagent>,
) {
    fun route(request: AgentRequest): AgentResponse {
        val agent = subagents.firstOrNull { it.canHandle(request) }
            ?: return AgentResponse(
                text = "Пока не умею отвечать на такое, но учусь.",
                handledBy = "fallback",
            )
        return agent.handle(request)
    }
}
