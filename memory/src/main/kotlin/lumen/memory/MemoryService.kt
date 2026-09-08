package lumen.memory

/**
 * Сервис памяти: хранит факты о пользователе.
 * Тестами покрыт частично — это одно из заданий.
 */
class MemoryService {

    private val storage = mutableMapOf<String, MutableList<String>>()

    fun remember(userId: String, fact: String) {
        if (fact.isBlank()) return
        storage.getOrPut(userId) { mutableListOf() }.add(fact)
    }

    fun recall(userId: String): List<String> =
        storage[userId].orEmpty().toList()

    fun forget(userId: String, fact: String): Boolean =
        storage[userId]?.remove(fact) ?: false

    fun count(userId: String): Int = storage[userId]?.size ?: 0
}
