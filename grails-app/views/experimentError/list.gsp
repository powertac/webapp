
<%@ page import="edu.kit.iism.experimentcenter.ExperimentError" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>ExperimentError List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="home" controller="experiment" action="list">Experiments</g:link></span>
            <span class="menuButton"><g:link class="home" controller="tradeLog" action="list">TradeLog</g:link></span>
            <span class="menuButton"><g:link class="home" controller="workerClient" action="list">Worker Clients</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ExperimentError</g:link></span>
        </div>
        <div class="body">
            <h1>ExperimentError List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Experiment</th>
                   	    
                   	        <g:sortableColumn property="logLevel" title="Log Level" />
                        
                   	        <g:sortableColumn property="message" title="Message" />
                        
                   	        <g:sortableColumn property="throwable" title="Throwable" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${experimentErrorInstanceList}" status="i" var="experimentErrorInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${experimentErrorInstance.id}">${fieldValue(bean:experimentErrorInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:experimentErrorInstance, field:'experiment')}</td>
                        
                            <td>${fieldValue(bean:experimentErrorInstance, field:'logLevel')}</td>
                        
                            <td>${fieldValue(bean:experimentErrorInstance, field:'errorMessage')}</td>
                        
                            <td>${fieldValue(bean:experimentErrorInstance, field:'errorStack')}</td>
                        
                            <td>${fieldValue(bean:experimentErrorInstance, field:'dateCreated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${experimentErrorInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
