$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Televente.feature");
formatter.feature({
  "line": 1,
  "name": "Televente Login functionality",
  "description": "",
  "id": "televente-login-functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "verify SSO page",
  "description": "",
  "id": "televente-login-functionality;verify-sso-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "open chrome browser and start application",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "page has been verified",
  "keyword": "Then "
});
formatter.match({
  "location": "VerifyLoginPage.open_chrome_browser_and_start_application()"
});
formatter.result({
  "duration": 8953814700,
  "status": "passed"
});
formatter.match({
  "location": "VerifyLoginPage.page_has_been_verified()"
});
formatter.result({
  "duration": 651820200,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "verify login functionality for Admin user",
  "description": "",
  "id": "televente-login-functionality;verify-login-functionality-for-admin-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@Test2"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "verify username password and submit button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "enter username \"S4333164\" and Password \"sg!t@2020\" for Admin user",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Admin user should be login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "VerifyLoginPage.verify_username_password_and_submit_button()"
});
formatter.result({
  "duration": 139526500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "S4333164",
      "offset": 16
    },
    {
      "val": "sg!t@2020",
      "offset": 40
    }
  ],
  "location": "VerifyLoginPage.enter_username_and_Password_for_Admin_user(String,String)"
});
formatter.result({
  "duration": 5128238000,
  "status": "passed"
});
formatter.match({
  "location": "VerifyLoginPage.admin_user_should_be_login_successfully()"
});
formatter.result({
  "duration": 3276869600,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "verify login functionality for Reader user",
  "description": "",
  "id": "televente-login-functionality;verify-login-functionality-for-reader-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@Test3"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "enter username \"P8099488\" and Password \"P@ssword@2020\" for Reader user",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Reader user should be login successfully as Reader Role",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "P8099488",
      "offset": 16
    },
    {
      "val": "P@ssword@2020",
      "offset": 40
    }
  ],
  "location": "VerifyLoginPage.enter_username_and_Password_for_Reader_user(String,String)"
});
formatter.result({
  "duration": 20050968200,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//input[@id\u003d\u0027username\u0027]\"}\n  (Session info: chrome\u003d79.0.3945.79)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LT106307\u0027, ip: \u002710.87.62.182\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 79.0.3945.79, chrome: {chromedriverVersion: 79.0.3945.36 (3582db32b3389..., userDataDir: C:\\Users\\s4333164\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:57459}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: ce8025a39cf419837e27359741f4b524\n*** Element info: {Using\u003dxpath, value\u003d//input[@id\u003d\u0027username\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy18.clear(Unknown Source)\r\n\tat webElements_Identifiers.Login.typeUsername(Login.java:102)\r\n\tat pages.VerifyLoginPage.enter_username_and_Password_for_Reader_user(VerifyLoginPage.java:193)\r\n\tat ✽.Given enter username \"P8099488\" and Password \"P@ssword@2020\" for Reader user(Televente.feature:16)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "VerifyLoginPage.reader_user_should_be_login_successfully_as_Reader_Role()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 20,
  "name": "verify login functionality for invalid user",
  "description": "",
  "id": "televente-login-functionality;verify-login-functionality-for-invalid-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@Test4"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "enter username \"S4333164\" and Password \"sg!t@2020\" for invalid user",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Invalid user should be not be login",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "S4333164",
      "offset": 16
    },
    {
      "val": "sg!t@2020",
      "offset": 40
    }
  ],
  "location": "VerifyLoginPage.enter_username_and_Password_for_invalid_user(String,String)"
});
formatter.result({
  "duration": 12704524700,
  "status": "passed"
});
formatter.match({
  "location": "VerifyLoginPage.invalid_user_should_be_not_be_login()"
});
formatter.result({
  "duration": 20079727500,
  "status": "passed"
});
});