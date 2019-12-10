/*
 * Copyright (c) 2002-2019 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.javascript.host.media;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.BrowserRunner;
import com.gargoylesoftware.htmlunit.BrowserRunner.Alerts;
import com.gargoylesoftware.htmlunit.BrowserRunner.BuggyWebDriver;
import com.gargoylesoftware.htmlunit.WebDriverTestCase;

/**
 * Tests for {@link AudioContext}.
 *
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class AudioContextTest extends WebDriverTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = "true",
            IE = "false")
    public void inWindow() throws Exception {
        final String html
            = "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    function test() {\n"
            + "      alert('AudioContext' in window);\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body onload='test()'>\n"
            + "</body>\n"
            + "</html>";

        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = "[object AudioBufferSourceNode]",
            IE = "AudioContext not available")
    public void createBufferSource() throws Exception {
        final String html
            = "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    function test() {\n"
            + "      if (!('AudioContext' in window)) {\n"
            + "        alert('AudioContext not available');\n"
            + "        return;\n"
            + "      }\n"

            + "      var audioCtx = new AudioContext();\n"
            + "      var source = audioCtx.createBufferSource();\n"
            + "      alert(source);\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body onload='test()'>\n"
            + "</body>\n"
            + "</html>";

        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"AudioContext prep done", "Error with decoding audio data"},
            IE = "AudioContext not available")
    @BuggyWebDriver(FF = "Todo")
    public void decodeAudioData() throws Exception {
        final String html
            = "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    function test() {\n"
            + "      if (!('AudioContext' in window)) {\n"
            + "        alert('AudioContext not available');\n"
            + "        return;\n"
            + "      }\n"

            + "      var audioCtx = new AudioContext();\n"
            + "      var audioData = new ArrayBuffer(0);\n"
            + "      audioCtx.decodeAudioData(audioData,\n"
            + "             function(buffer) { alert('Decoding audio data done'); },\n"
            + "             function(e) { alert('Error with decoding audio data'); }\n"
            + "           );\n"
            + "      alert('AudioContext prep done');\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body onload='test()'>\n"
            + "</body>\n"
            + "</html>";

        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"AudioContext prep done", "Error with decoding audio data"},
            IE = "AudioContext not available")
    public void decodeAudioData2() throws Exception {
        final String html
            = "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    function test() {\n"
            + "      if (!('AudioContext' in window)) {\n"
            + "        alert('AudioContext not available');\n"
            + "        return;\n"
            + "      }\n"

            + "      var audioCtx = new AudioContext();\n"
            + "      var audioData = new ArrayBuffer(0);\n"
            + "      audioCtx.decodeAudioData(audioData).then(\n"
            + "             function(buffer) { alert('Decoding audio data done'); },\n"
            + "             function(e) { alert('Error with decoding audio data'); }\n"
            + "           );\n"
            + "      alert('AudioContext prep done');\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body onload='test()'>\n"
            + "</body>\n"
            + "</html>";

        loadPageWithAlerts2(html);
    }
}
