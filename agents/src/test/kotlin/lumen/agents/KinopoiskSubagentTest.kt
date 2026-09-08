package lumen.agents

import lumen.core.AgentRequest
import lumen.core.Message
import lumen.core.Role
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class KinopoiskSubagentTest {

    private fun req(text: String) =
        AgentRequest(userId = "u1", history = listOf(Message(Role.USER, text)))

    @Test
    fun `берёт запросы про кино`() {
        assertTrue(KinopoiskSubagent().canHandle(req("посоветуй фильм на вечер")))
    }

    @Test
    fun `не берёт запросы про музыку`() {
        assertFalse(KinopoiskSubagent().canHandle(req("поставь трек")))
    }

    @Test
    fun `отвечает от своего имени`() {
        val response = KinopoiskSubagent().handle(req("хочу сериал"))
        assertEquals("kinopoisk", response.handledBy)
    }

    @Test
    fun `не берёт пустой запрос`() {
        assertFalse(KinopoiskSubagent().canHandle(req("")))
    }
}