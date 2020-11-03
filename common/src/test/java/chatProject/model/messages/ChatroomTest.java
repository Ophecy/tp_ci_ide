package chatProject.model.messages;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChatroomTest {


    @Test
    public void testGetName() {
        String name = "TEST";
        final Chatroom<String> chatroom = new Chatroom<>(name, null, null);

        assertEquals("The chatroom Name",
                name, chatroom.getName());
    }
}
