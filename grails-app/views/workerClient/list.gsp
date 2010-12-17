<%@ page import="edu.kit.iism.experimentcenter.WorkerClient" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>WorkerClient List</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><a class="home" href="${resource(dir: '')}">Home</a></span>
  <span class="menuButton"><g:link class="home" controller="experiment" action="list">Experiments</g:link></span>
  <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
</div>
<div class="body">
  <h1>WorkerClient List</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <div class="list">
    <table>
      <thead>
      <tr>

        <g:sortableColumn property="hostName" title="Host Name"/>

        <g:sortableColumn property="ipAddress" title="Ip Address"/>

        <g:sortableColumn property="appVersion" title="App Version"/>

        <g:sortableColumn property="workerStatus" title="Worker Status"/>

        <g:sortableColumn property="enabled" title="Enabled"/>

        <g:sortableColumn property="online" title="Online"/>

        <g:sortableColumn property="lastSeen" title="Last Seen"/>

        <th>Action</th>

      </tr>
      </thead>
      <tbody>
      <g:each in="${workerClientInstanceList}" status="i" var="workerClientInstance">
        <g:form method="post">
          <input type="hidden" name="id" value="${workerClientInstance?.id}"/>
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}" onclick='window.location = "show?id=${workerClientInstance.id}"'>

            <td>${fieldValue(bean: workerClientInstance, field: 'hostName')}</td>

            <td>${fieldValue(bean: workerClientInstance, field: 'ipAddress')}</td>

            <td>${fieldValue(bean: workerClientInstance, field: 'appVersion')}</td>

            <td>${fieldValue(bean: workerClientInstance, field: 'workerStatus')}</td>

            <td>${fieldValue(bean: workerClientInstance, field: 'enabled')}</td>

            <td>&nbsp;
              <g:if test="${workerClientInstance?.online}">
                <img src="${createLinkTo(dir: 'images', file: 'online.png')}" width="20px" alt="Online"/>
              </g:if>
              <g:else>
                <img src="${createLinkTo(dir: 'images', file: 'offline.png')}" width="20px" alt="Offline"/>
              </g:else>
            </td>

            <td>${fieldValue(bean: workerClientInstance, field: 'lastSeen')}</td>
            <td>
              <g:if test="${workerClientInstance.enabled}"><span class="button"><g:actionSubmit onclick="return confirm('Disable Worker Client?');" value="Disable" /></span></g:if>
              <g:else><span class="button"><g:actionSubmit onclick="return confirm('Enable Worker Client?');" value="Enable" /></span></g:else>
            </td>

          </tr>
        </g:form>
      </g:each>
      </tbody>
    </table>
  </div>
  <div class="paginateButtons">
    <g:paginate total="${workerClientInstanceTotal}"/>
  </div>
</div>
</body>
</html>
