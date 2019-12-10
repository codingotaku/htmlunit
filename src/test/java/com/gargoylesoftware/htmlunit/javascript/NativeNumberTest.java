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
package com.gargoylesoftware.htmlunit.javascript;

import static com.gargoylesoftware.htmlunit.BrowserRunner.TestedBrowser.IE;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.BrowserRunner;
import com.gargoylesoftware.htmlunit.BrowserRunner.Alerts;
import com.gargoylesoftware.htmlunit.BrowserRunner.NotYetImplemented;
import com.gargoylesoftware.htmlunit.WebDriverTestCase;

/**
 * Number is a native JavaScript object.
 *
 * @author Marc Guillemot
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class NativeNumberTest extends WebDriverTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"false", "false", "false", "true", "true", "false", "false"},
            IE = "no Number.isFinite")
    @NotYetImplemented(IE)
    public void isFinite() throws Exception {
        final String html =
            "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    if (Number.isFinite === undefined) {\n"
            + "      alert('no Number.isFinite');\n"
            + "    } else {\n"
            + "      alert(Number.isFinite(Infinity));\n"
            + "      alert(Number.isFinite(NaN));\n"
            + "      alert(Number.isFinite(-Infinity));\n"
            + "      alert(Number.isFinite(0));\n"
            + "      alert(Number.isFinite(2e64));\n"
            + "      alert(Number.isFinite('0'));\n"
            + "      alert(Number.isFinite(null));\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body>\n"
            + "</body>\n"
            + "</html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"true", "true", "true", "false", "false", "false", "false",
                "false", "false", "false", "false", "false"},
            IE = "no Number.isInteger")
    @NotYetImplemented(IE)
    public void isInteger() throws Exception {
        final String html =
            "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    if (Number.isInteger === undefined) {\n"
            + "      alert('no Number.isInteger');\n"
            + "    } else {\n"
            + "      alert(Number.isInteger(0));\n"
            + "      alert(Number.isInteger(1));\n"
            + "      alert(Number.isInteger(-100000));\n"

            + "      alert(Number.isInteger(0.1));\n"
            + "      alert(Number.isInteger(Math.PI));\n"

            + "      alert(Number.isInteger(NaN));\n"
            + "      alert(Number.isInteger(Infinity));\n"
            + "      alert(Number.isInteger(-Infinity));\n"
            + "      alert(Number.isInteger('10'));\n"
            + "      alert(Number.isInteger(true));\n"
            + "      alert(Number.isInteger(false));\n"
            + "      alert(Number.isInteger([1]));\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body>\n"
            + "</body>\n"
            + "</html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"true", "true", "true", "false", "false", "false", "false",
                "false", "false", "false", "false", "false", "false", "false"},
            IE = "no Number.isNaN")
    @NotYetImplemented(IE)
    public void isNaN() throws Exception {
        final String html =
            "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    if (Number.isNaN === undefined) {\n"
            + "      alert('no Number.isNaN');\n"
            + "    } else {\n"
            + "      alert(Number.isNaN(NaN));\n"
            + "      alert(Number.isNaN(Number.NaN));\n"
            + "      alert(Number.isNaN(0 / 0));\n"

            + "      alert(Number.isNaN('NaN'));\n"
            + "      alert(Number.isNaN(undefined));\n"
            + "      alert(Number.isNaN({}));\n"
            + "      alert(Number.isNaN('blabla'));\n"

            + "      alert(Number.isNaN(true));\n"
            + "      alert(Number.isNaN(null));\n"
            + "      alert(Number.isNaN(37));\n"
            + "      alert(Number.isNaN('37'));\n"
            + "      alert(Number.isNaN('37.37'));\n"
            + "      alert(Number.isNaN(''));\n"
            + "      alert(Number.isNaN(' '));\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body>\n"
            + "</body>\n"
            + "</html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"true", "false", "true", "false", "false", "false", "false", "true"},
            IE = "no Number.isSafeInteger")
    @NotYetImplemented(IE)
    public void isSafeInteger() throws Exception {
        final String html =
            "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    if (Number.isSafeInteger === undefined) {\n"
            + "      alert('no Number.isSafeInteger');\n"
            + "    } else {\n"
            + "      alert(Number.isSafeInteger(3));\n"
            + "      alert(Number.isSafeInteger(Math.pow(2, 53)));\n"
            + "      alert(Number.isSafeInteger(Math.pow(2, 53) - 1));\n"
            + "      alert(Number.isSafeInteger(NaN));\n"
            + "      alert(Number.isSafeInteger(Infinity));\n"
            + "      alert(Number.isSafeInteger('3'));\n"
            + "      alert(Number.isSafeInteger(3.1));\n"
            + "      alert(Number.isSafeInteger(3.0));\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body>\n"
            + "</body>\n"
            + "</html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = "3.14",
            IE = "no Number.parseFloat")
    @NotYetImplemented(IE)
    public void parseFloat() throws Exception {
        final String html =
            "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    if (Number.parseFloat === undefined) {\n"
            + "      alert('no Number.parseFloat');\n"
            + "    } else {\n"
            + "      alert(Number.parseFloat('3.14'));\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body>\n"
            + "</body>\n"
            + "</html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = "4",
            IE = "no Number.parseInt")
    @NotYetImplemented(IE)
    public void parseInt() throws Exception {
        final String html =
            "<html>\n"
            + "<head>\n"
            + "  <script>\n"
            + "    if (Number.parseInt === undefined) {\n"
            + "      alert('no Number.parseInt');\n"
            + "    } else {\n"
            + "      alert(Number.parseInt('4'));\n"
            + "    }\n"
            + "  </script>\n"
            + "</head>\n"
            + "<body>\n"
            + "</body>\n"
            + "</html>";
        loadPageWithAlerts2(html);
    }

    /**
     * Test for the methods with the same expectations for all browsers.
     * @throws Exception if the test fails
     */
    @Test
    @Alerts({"toFixed: function", "toExponential: function", "toLocaleString: function", "toPrecision: function",
        "toString: function", "valueOf: function"})
    public void methods_common() throws Exception {
        final String[] methods = {"toFixed", "toExponential", "toLocaleString", "toPrecision", "toString", "valueOf"};
        final String html = NativeDateTest.createHTMLTestMethods("new Number()", methods);
        loadPageWithAlerts2(html);
    }

    /**
     * Test for the methods with the different expectations depending on the browsers.
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = "toSource: undefined",
            FF = "toSource: function")
    public void methods_different() throws Exception {
        final String html = NativeDateTest.createHTMLTestMethods("new Number()", "toSource");
        loadPageWithAlerts2(html);
    }

    /**
     * Test for Rhino bug 538172.
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("2.274341322658976e-309")
    public void toStringRhinoBug538172() throws Exception {
        final String html = "<html><head><title>foo</title><script>\n"
            + "alert(2.274341322658976E-309);\n"
            + "</script></head><body>\n"
            + "</body></html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("12,345")
    public void toLocaleString() throws Exception {
        final String html = "<html><head><script>\n"
            + "  alert((12345).toLocaleString('en'));\n"
            + "</script></head><body>\n"
            + "</body></html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("12.345")
    public void toLocaleStringDe() throws Exception {
        final String html = "<html><head><script>\n"
            + "  alert((12345).toLocaleString('de'));\n"
            + "</script></head><body>\n"
            + "</body></html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("12,345")
    public void toLocaleStringEnUS() throws Exception {
        final String html = "<html><head><script>\n"
            + "  alert((12345).toLocaleString('en-US'));\n"
            + "</script></head><body>\n"
            + "</body></html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("12,345")
    public void toLocaleStringNoParam() throws Exception {
        final String html = "<html><head><script>\n"
            + "  try {\n"
            + "    alert((12345).toLocaleString());\n"
            + "  } catch(e) { alert(e); }\n"
            + "</script></head><body>\n"
            + "</body></html>";
        loadPageWithAlerts2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("exception")
    public void toLocaleStringHintertupfingen() throws Exception {
        final String html = "<html><head><script>\n"
            + "  try {\n"
            + "    alert((12345).toLocaleString('Hintertupfingen'));\n"
            + "  } catch(e) { alert('exception'); }\n"
            + "</script></head><body>\n"
            + "</body></html>";
        loadPageWithAlerts2(html);
    }
}
