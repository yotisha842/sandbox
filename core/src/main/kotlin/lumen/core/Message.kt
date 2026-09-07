package lumen.core

enum class Role { USER, ASSISTANT, SYSTEM }

data class Message(
    val role: Role,
    val text: String,
)

data class AgentRequest(
    val userId: String,
    val history: List<Message>,
) {
    val lastUserText: String
        get() = history.lastOrNull { it.role == Role.USER }?.text.orEmpty()
}

data class AgentResponse(
    val text: String,
    val handledBy: String,
)
