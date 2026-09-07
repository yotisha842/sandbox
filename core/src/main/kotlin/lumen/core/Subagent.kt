package lumen.core

/**
 * Доменный сабагент: умеет отвечать на запросы своей предметной области.
 */
interface Subagent {
    val name: String

    /** Может ли этот сабагент взять запрос. */
    fun canHandle(request: AgentRequest): Boolean

    fun handle(request: AgentRequest): AgentResponse
}
