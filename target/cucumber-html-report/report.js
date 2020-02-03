$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Televente.feature");
formatter.feature({
  "line": 1,
  "name": "Televente Login functionality",
  "description": "",
  "id": "televente-login-functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "veify login with valid credentials",
  "description": "",
  "id": "televente-login-functionality;veify-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "open chrome browser and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "verify loginfunctionality with \"S4333164\" and \"sg!t@2020\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});