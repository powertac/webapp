<%@ page import="edu.kit.iism.experimentcenter.Experiment" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Edit Experiment</title>
  <g:javascript library="codemirror"/>
</head>
<body>
<div class="nav">
  <span class="menuButton"><a class="home" href="${createLinkTo(dir: '')}">Home</a></span>
  <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
  <span class="menuButton"><g:link class="list" action="list">Experiment List</g:link></span>
  <span class="menuButton"><g:link class="home" controller="workerClient" action="list">Worker Clients</g:link></span>
  <span class="menuButton"><g:link class="create" action="create">New Experiment</g:link></span>
</div>
<div class="body" style="width: 100%;">
  <h1>Edit Experiment</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:hasErrors bean="${experimentInstance}">
    <div class="errors">
      <g:renderErrors bean="${experimentInstance}" as="list"/>
    </div>
  </g:hasErrors>
  <g:form method="post">
    <input type="hidden" name="id" value="${experimentInstance?.id}"/>
    <input type="hidden" name="version" value="${experimentInstance?.version}"/>
    <div class="dialog">
      <table style="width: 100%">
        <tbody>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="name">Series:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: experimentInstance, field: 'series', 'errors')}">
            <g:select optionKey="id" from="${edu.kit.iism.experimentcenter.Series.list()}" value="${experimentInstance?.series?.id}" name="series.id" noSelection="${['-1':'No Series']}"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="name">Name:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: experimentInstance, field: 'name', 'errors')}">
            <input type="text" id="name" name="name" value="${fieldValue(bean: experimentInstance, field: 'name')}"/>
          </td>
        </tr>


        <tr class="prop">
          <td valign="top" colspan="2" class="value ${hasErrors(bean: experimentInstance, field: 'description', 'errors')}">
            <h3><label for="experimentConfiguration" >Experiment Description:</label></h3>
            <g:textArea class="codebox" name="description" id="description" value="${experimentInstance?.description}"/>
            <script type="text/javascript">
            var descriptionEditor = CodeMirror.fromTextArea("description", {
                width: "100%",
                height: "250px",
                lineNumbers: true,
                parserfile: "parsedummy.js",
                stylesheet: "${createLinkTo(dir:'css',file:'plaincolors.css')}",
                path: "${createLinkTo(dir:'js')}/"
              });
            </script>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" colspan="2" class="value ${hasErrors(bean: experimentInstance, field: 'experimentConfiguration', 'errors')}">
            <h3><label for="experimentConfiguration">Experiment Configuration:</label></h3>
            <g:textArea class="codebox" id="experimentConfiguration" name="experimentConfiguration" value="${experimentInstance?.experimentConfiguration}"/>

            <script type="text/javascript">
              var configEditor = CodeMirror.fromTextArea("experimentConfiguration", {
                width: "100%",
                height: "800px",
                lineNumbers: true,
                parserfile: ["tokenizejavascript.js", "parsejavascript.js"],
                path: "${createLinkTo(dir:'js')}/",
                stylesheet: "${createLinkTo(dir:'css',file:'jscolors.css')}",
              });
            </script>

          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="experimentStatus">Experiment Status:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: experimentInstance, field: 'experimentStatus', 'errors')}">
            <g:select from="${edu.kit.iism.experimentcenter.enumerations.ExperimentStatus?.values()}" value="${experimentInstance?.experimentStatus}" name="experimentStatus"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="minVersionExperimentRunner">Min. Version Worker Client:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: experimentInstance, field: 'minVersionExperimentRunner', 'errors')}">
            <input type="text" id="minVersionExperimentRunner" name="minVersionExperimentRunner" value="${fieldValue(bean: experimentInstance, field: 'minVersionExperimentRunner')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="maxVersionExperimentRunner">Max. Version Worker Client:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: experimentInstance, field: 'maxVersionExperimentRunner', 'errors')}">
            <input type="text" id="maxVersionExperimentRunner" name="maxVersionExperimentRunner" value="${fieldValue(bean: experimentInstance, field: 'maxVersionExperimentRunner')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            Worker Client:
          </td>
          <td valign="top" class="value">
            ${experimentInstance?.targetMachine}
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">Date Created:</td>
          <td valign="top" class="value">${experimentInstance?.dateCreated}</td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">Last Updated:</td>
          <td valign="top" class="value">${experimentInstance?.lastUpdated}</td>
        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <span class="button"><g:actionSubmit class="save" value="Update"/></span>
      <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete"/></span>
    </div>
  </g:form>
</div>
</body>
</html>
