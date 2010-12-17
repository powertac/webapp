<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Report List</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><a class="home" href="${createLinkTo(dir: '')}">Home</a></span>
  <span class="menuButton"><g:link class="home" controller="workerClient" action="list">Worker Clients</g:link></span>
  <span class="menuButton"><g:link class="home" controller="experiment" action="list">Experiment List</g:link></span>
</div>
<div class="body">
  <h1>Report List</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <div class="list">
    <table>
      <thead>
      <tr>
        <th>Available Reports</th>
        <th>Download</th>
      </tr>
      </thead>
      <tbody>
      <tr class="even">
        <td valign="middle">Experiment Overview</td>
        <td>
          <g:jasperReport name="ExperimentList" description=" " jasper="experiment-list" format="HTML,XLS,CSV,PDF,RTF" delimiterBefore=" " delimiterAfter=" " height="25px"/>
        </td>
      </tr>
      <tr class="odd">
        <td valign="middle">Targets and Allocations</td>
        <td>
          <g:jasperReport name="TargetsAndAllocations" description=" " jasper="targets-and-allocations" format="HTML,XLS,CSV,PDF,RTF" delimiterBefore=" " delimiterAfter=" " height="25px">
            Experiment <g:select optionKey="id" from="${edu.kit.iism.experimentcenter.Experiment.list()}" name="experiment.id" noSelection="${['':'Select One...']}"></g:select>
          </g:jasperReport>
        </td>
      </tr>
      <tr class="even">
        <td valign="middle">Order List</td>
        <td>
          <g:jasperReport name="OrderList" description=" " jasper="order-list" format="HTML,XLS,CSV,PDF,RTF" delimiterBefore=" " delimiterAfter=" " height="25px">
            Experiment <g:select optionKey="id" from="${edu.kit.iism.experimentcenter.Experiment.list()}" name="experiment.id" noSelection="${['':'Select One...']}"></g:select>
          </g:jasperReport>
        </td>
      </tr>
      <tr class="odd">
        <td valign="middle">Aggregated Targets and Alloctions</td>
        <td>
          <g:jasperReport name="AggregTargetsAndAllocations" description=" " jasper="aggreg-targets-allocations" format="HTML,XLS,CSV,PDF,RTF" delimiterBefore=" " delimiterAfter=" " height="25px">
          </g:jasperReport>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
