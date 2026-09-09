package lumen.core

/**
 * Простейшая оркестрация: выбирает первого подходящего сабагента,
 * иначе отвечает фолбэком.
 */
class Orchestrator(
    private val subagents: List<Subagent>,
) {
    private val handledCount = mutableMapOf<String, Int>()

    fun route(request: AgentRequest): AgentResponse {
        val agent = subagents.firstOrNull { it.canHandle(request) }
        if (agent == null) {
            handledCount.merge("fallback", 1, Int::plus)
            return AgentResponse(
                text = "Пока не умею отвечать на такое, но учусь.",
                handledBy = "fallback",
            )
        }
        handledCount.merge(agent.name, 1, Int::plus)
        return agent.handle(request)
    }

    /** Сколько запросов ушло в каждого сабагента. */
    fun stats(): Map<String, Int> = handledCount.toMap()
}