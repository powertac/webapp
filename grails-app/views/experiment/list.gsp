
<%@ page import="edu.kit.iism.experimentcenter.enumerations.ExperimentStatus; edu.kit.iism.experimentcenter.Experiment" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Experiment List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
            <span class="menuButton"><g:link class="home" controller="workerClient" action="list">Worker Clients</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Experiment</g:link></span>
        </div>
        <div class="body">
            <h1>Experiment List</h1>
            <h3>Filter: <g:select from="${edu.kit.iism.experimentcenter.enumerations.ExperimentStatus?.values()}" value="${params.filter}" name="filter" id="filter" onChange="javascript:window.location='?filter='+options[selectedIndex].value" noSelection="${['':'All']}"></g:select></h3>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr style="border-left: 5px solid #ddd;">

                            <g:sortableColumn property="series.id" title="Series" />

                            <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="name" title="Name" />

                            <g:sortableColumn property="experimentStatus" title="Experiment Status" />
                        
                   	        <g:sortableColumn property="targetMachine" title="Worker Client" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />

                            <g:sortableColumn property="description" title="Description" />

                            <th>Action</th>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${experimentInstanceList}" status="i" var="experimentInstance">
                        <g:form method="post" >
                          <input type="hidden" name="id" value="${experimentInstance?.id}" />

                          <g:if test="${experimentInstance.experimentStatus == edu.kit.iism.experimentcenter.enumerations.ExperimentStatus.Running}">
                          <tr class="running-${(i % 2) == 0 ? 'odd' : 'even'}">
                          </g:if>
                          <g:elseif test="${experimentInstance.experimentStatus == edu.kit.iism.experimentcenter.enumerations.ExperimentStatus.Paused}">
                            <tr class="paused-${(i % 2) == 0 ? 'odd' : 'even'}">
                          </g:elseif>
                          <g:elseif test="${experimentInstance.experimentStatus == edu.kit.iism.experimentcenter.enumerations.ExperimentStatus.Pending}">
                            <tr class="pending-${(i % 2) == 0 ? 'odd' : 'even'}">
                          </g:elseif>
                          <g:elseif test="${experimentInstance.experimentStatus == edu.kit.iism.experimentcenter.enumerations.ExperimentStatus.InvalidConfiguration}">
                            <tr class="invalid-${(i % 2) == 0 ? 'odd' : 'even'}">
                          </g:elseif>
                          <g:elseif test="${experimentInstance.experimentStatus == edu.kit.iism.experimentcenter.enumerations.ExperimentStatus.Interrupted}">
                            <tr class="interrupted-${(i % 2) == 0 ? 'odd' : 'even'}">
                          </g:elseif>
                          <g:else>
                            <tr style="border-left: 5px solid #ddd;">
                          </g:else>
                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>${experimentInstance.series}</td>

                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>${experimentInstance.id}</td>
                        
                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>${fieldValue(bean:experimentInstance, field:'name')}</td>
                        
                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>
                              ${fieldValue(bean:experimentInstance, field:'experimentStatus')}
                              <g:if test="${experimentInstance.experimentStatus == edu.kit.iism.experimentcenter.enumerations.ExperimentStatus.Finished}">
                                <img style="margin-bottom:-2px" src="${createLinkTo(dir: 'images', file: 'finished.gif')}" alt="Experiment successfully finished"/>
                              </g:if>
                            </td>
                        
                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>${fieldValue(bean:experimentInstance, field:'targetMachine')}</td>
                        
                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>${fieldValue(bean:experimentInstance, field:'lastUpdated')}</td>

                            <td onclick='window.location = "show?id=${experimentInstance.id}"'>${fieldValue(bean:experimentInstance, field:'description')}</td>

                            <td>
                              <g:if test="${experimentInstance.experimentStatus != ExperimentStatus.Running}"><span class="button"><g:actionSubmit onclick="return confirm('Reset Experiment?');" value="Reset" /></span></g:if>
                              <g:if test="${experimentInstance.experimentStatus == ExperimentStatus.Running || experimentInstance.experimentStatus == ExperimentStatus.Pending}"><span class="button"><g:actionSubmit onclick="return confirm('Pause Experiment?');" value="Pause" /></span></g:if>
                              <g:if test="${experimentInstance.experimentStatus == ExperimentStatus.Paused}"><span class="button"><g:actionSubmit onclick="return confirm('Activate Experiment?');" value="Activate" /></span></g:if>
                              <span class="button"><span class="button"><g:actionSubmit onclick="return confirm('Duplicate Experiment?');" value="Duplicate" /></span>
                            </td>
                         </g:form>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${experimentInstanceTotal}" params="${params}" />
            </div>
        </div>
    </body>
</html>
