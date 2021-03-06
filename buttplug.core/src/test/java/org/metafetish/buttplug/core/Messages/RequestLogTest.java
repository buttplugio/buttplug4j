package org.metafetish.buttplug.core.Messages;

import org.junit.Assert;
import org.junit.Test;
import org.metafetish.buttplug.core.ButtplugJsonMessageParser;
import org.metafetish.buttplug.core.ButtplugMessage;
import org.metafetish.buttplug.core.Messages.RequestLog.ButtplugLogLevel;

import java.io.IOException;
import java.util.List;

public class RequestLogTest {

    @Test
    public void test() throws IOException {
        String testStr = "[{\"RequestLog\":{\"Id\":7,\"LogLevel\":\"Error\"}}]";

        ButtplugJsonMessageParser parser = new ButtplugJsonMessageParser();
        List<ButtplugMessage> msgs = parser.parseJson(testStr);

        Assert.assertEquals(msgs.size(), 1);
        Assert.assertEquals(msgs.get(0).getClass(), RequestLog.class);
        Assert.assertEquals(msgs.get(0).id, 7);
        Assert.assertEquals(((RequestLog) msgs.get(0)).logLevel, ButtplugLogLevel.ERROR);

        String jsonOut = parser.formatJson(msgs);
        Assert.assertEquals(testStr, jsonOut);

        jsonOut = parser.formatJson(msgs.get(0));
        Assert.assertEquals(testStr, jsonOut);
    }

}
