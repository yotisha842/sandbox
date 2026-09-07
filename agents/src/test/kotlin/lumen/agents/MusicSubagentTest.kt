package lumen.agents

import lumen.core.AgentRequest
import lumen.core.Message
import lumen.core.Role
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MusicSubagentTest {

    private fun req(text: String) =
        AgentRequest(userId = "u1", history = listOf(Message(Role.USER, text)))

    @Test
    fun `берёт запросы про музыку`() {
        assertTrue(MusicSubagent().canHandle(req("посоветуй трек под пробежку")))
    }

    @Test
    fun `не берёт посторонние запросы`() {
        assertFalse(MusicSubagent().canHandle(req("какая завтра погода")))
    }
}
