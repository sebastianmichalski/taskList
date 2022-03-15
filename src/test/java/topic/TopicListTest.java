package topic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopicListTest {

    private TopicList topicList;
    private final BufferedReader in = mock(BufferedReader.class);
    private final PrintWriter out = mock(PrintWriter.class);

    @BeforeEach
    public void setup() {
        topicList = new TopicList(in, out);
    }

    @Test
    void helpShouldWork() throws IOException {
        // When
        when(in.readLine()).thenReturn("help", "exit");
        topicList.run();

        // Then
        verify(out).println("Commands:");
        verify(out).println("  show");
        verify(out).println("  help");
        verify(out).println();
    }
}
