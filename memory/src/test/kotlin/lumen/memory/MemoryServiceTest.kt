package lumen.memory

import kotlin.test.Test
import kotlin.test.assertEquals

class MemoryServiceTest {

    @Test
    fun `count возвращает число сохранённых фактов`() {
        val service = MemoryService()
        service.remember("u1", "любит бег")
        service.remember("u1", "пишет на Kotlin")

        assertEquals(2, service.count("u1"))
    }

    @Test
    fun `count возвращает ноль для незнакомого пользователя`() {
        assertEquals(0, MemoryService().count("нет-такого"))
    }
}