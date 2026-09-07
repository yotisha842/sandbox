package lumen.core

import kotlin.test.Test
import kotlin.test.assertEquals

class OrchestratorTest {

    private fun req(text: String) =
        AgentRequest(userId = "u1", history = listOf(Message(Role.USER, text)))

    private val stub = object : Subagent {
        override val name = "stub"
        override fun canHandle(request: AgentRequest) =
            request.lastUserText.contains("тест")
        override fun handle(request: AgentRequest) =
            AgentResponse(text = "ok", handledBy = name)
    }

    @Test
    fun `роутит запрос в подходящего сабагента`() {
        val response = Orchestrator(listOf(stub)).route(req("это тест"))
        assertEquals("stub", response.handledBy)
    }

    @Test
    fun `падает в фолбэк если никто не берёт запрос`() {
        val response = Orchestrator(listOf(stub)).route(req("привет"))
        assertEquals("fallback", response.handledBy)
    }
}
