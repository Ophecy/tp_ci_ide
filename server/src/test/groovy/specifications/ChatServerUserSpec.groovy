package specifications

import chatProject.model.messages.ChatInstance
import chatProject.server.ChatServer
import chatProject.model.user.UserAccount
import spock.lang.Specification

class ChatServerUserSpec extends Specification {

    def "Adding a new User should add it in the model"() {
        given: "A server and a username"
        def server = new ChatServer(ChatInstance.initEmptyChat(), null, null)
        def username = "TestUser"
        when: "A new user is created"
        server.login(username)

        then: "The new user should be added to the model"
        UserAccount user = server.findUser(username) as UserAccount
        assert user.getUsername() == username
    }

    def "Login with an existing user should not create another one"() {
        given: "A server and a username"
        def server = new ChatServer(ChatInstance.initEmptyChat(), null, null)
        def username = "TestUser"
        when: "A new user is created"
        server.login(username) // create the user
        server.login(username) // login with the same user

        then: "The new user should be added to the model"
        assert server.getUsers().size() == 1
    }


}